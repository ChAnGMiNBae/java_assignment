package com.ohgiraffers.comprehensive.service;

import com.ohgiraffers.comprehensive.application.GameContext;
import com.ohgiraffers.comprehensive.domain.*;
import com.ohgiraffers.comprehensive.ui.GameIO;
import com.ohgiraffers.comprehensive.util.RandomProvider;

import java.util.List;

public class GameService {
    private final SaveService saveService;
    private final BattleService battleService;
    private final RandomProvider rng;


    public GameService(SaveService saveService, BattleService battleService, RandomProvider rng) {
        this.saveService = saveService;
        this.battleService = battleService;
        this.rng = rng;
    }

    public void startNew(GameContext ctx, GameIO io) { // 게임 시작
        io.printf("플레이어 닉네임 입력: ");
        String nick = io.readLine().trim();
        if (nick.isEmpty()) nick = "모험가";
        ctx.player = new Player(nick, 3, 3, 100);
        ctx.player.addItem(ItemType.POTION, 5);
        ctx.stage = Stage.BASIC;
        ctx.normalKills = 0;
        io.printf("%s 님, 모험을 시작합니다! (HP:%d)\n", ctx.player.getNickname(), ctx.player.getHp());
    }

    public boolean continueFromSave(GameContext ctx, GameIO io) {   // 세이브 파일 로드
        List<GameSave> saves = saveService.list(ctx.userId);
        if (saves.isEmpty()) { io.println("세이브 파일이 없습니다. 새 게임을 시작하세요."); return false; }
        io.println("\n== 세이브 선택 ==");
        for (int i = 0; i < saves.size(); i++) {
            GameSave s = saves.get(i);
            io.printf("%d) [%s] %s | Stage:%s | Kills:%d | Saved:%s\n",
                    i + 1, s.getSaveId().substring(0, 8), s.getPlayer().getNickname(), s.getStage(), s.getNormalKills(), s.getSavedAt());
        }
        int idx = io.readInt("번호 선택(0: 취소): ") - 1;
        if (idx < 0) return false;
        if (!saveService.loadInto(ctx, idx)) { io.println("잘못된 번호입니다."); return false; }
        io.printf("로드 완료! 닉네임:%s Stage:%s Kills:%d\n", ctx.player.getNickname(), ctx.stage, ctx.normalKills);
        return true;
    }

    public void runLoop(GameContext ctx, GameIO io) {   // 배틀 시작
        if (ctx.stage == Stage.BOSS || ctx.normalKills >= 3) {
            runBoss(ctx, io);
            return;
        }

        while (true) {
            EnemyType[] pool = EnemyType.values();
            Enemy enemy = pool[rng.nextInt(pool.length)].spawn();

            io.printf("\n적 등장! [%s] (약점은 비밀) HP:%d\n", enemy.getName(), enemy.getHp());
            Outcome outcome = battleService.run(ctx, enemy, false, io);

            if (outcome == Outcome.GAME_OVER) {
                if (!onGameOver(ctx, io)) return;
                continue;
            }
            if (outcome == Outcome.ESCAPE) continue;

            // 전투 승리 후 보상/세이브
            ctx.normalKills++;
            ctx.player.addGold(10 + rng.nextInt(11));
            if (rng.nextInt(100) < 35) {
                ctx.player.addItem(ItemType.POTION, 1);
                io.printf("포션 1개를 획득 했다!");
            }

            io.printf("전투 승리! 누적 처치:%d | 보유골드:%d\n", ctx.normalKills, ctx.player.getGold());
            if (io.confirm("세이브 하시겠습니까?")) {
                saveService.save(ctx);
                io.println("세이브 완료.");
            }

            if (ctx.normalKills >= 3) {
                io.println("\n--- 보스 스테이지로 진출합니다! ---");
                ctx.stage = Stage.BOSS;
                runBoss(ctx, io);
                return;
            }
        }
    }

    public void runBoss(GameContext ctx, GameIO io) { // 보스 배틀
        Boss boss = new Boss();
        io.println("\n===== 보스 스테이지: 마왕 등장! =====");
        Outcome outcome = battleService.run(ctx, boss, true, io);
        if (outcome == Outcome.GAME_OVER) {
            if (!onGameOver(ctx, io)) return;
            if (ctx.stage == Stage.BOSS) runBoss(ctx, io); else runLoop(ctx, io);
            return;
        }
        io.println("\n*** 마왕을 물리쳤습니다! 클리어를 축하합니다! ***");
    }


    private boolean onGameOver(GameContext ctx, GameIO io) { // 게임 오버
        int sel = io.readInt("\n*** 게임 오버 ***\n1) 이어하기(세이브에서) 0) 뒤로가기\n선택: ");
        if (sel == 1) return continueFromSave(ctx, io);
        return false;
    }
}
