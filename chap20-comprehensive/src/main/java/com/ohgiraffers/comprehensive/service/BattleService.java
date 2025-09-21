package com.ohgiraffers.comprehensive.service;

import com.ohgiraffers.comprehensive.application.GameContext;
import com.ohgiraffers.comprehensive.domain.*;
import com.ohgiraffers.comprehensive.ui.GameIO;
import com.ohgiraffers.comprehensive.util.RandomProvider;

public class BattleService {

    private final RandomProvider rng;

    public BattleService(RandomProvider rng) {
        this.rng = rng;
    }

    public Outcome run(GameContext ctx, Enemy enemy, boolean isBoss, GameIO io) { // 몬스터와 전투
        Player player = ctx.player;
        while (player.isAlive() && enemy.isAlive()) {
            io.printf("\n[%s] HP:%d | 당신 HP:%d | 가방:%s\n",
                    enemy.getName(), enemy.getHp(), player.getHp(), summarizeBag(player));

            if (isBoss && enemy instanceof Boss bs) {
                bs.rerollWeakness();
                io.println(bs.hintLine());
            }
            io.println("1) 스킬 2) 가방 3) 도주");

            int sel = io.readInt("선택: ");
            switch (sel) {
                case 1 -> castSkill(player, enemy, isBoss, io);
                case 2 -> useBag(player, io);
                case 3 -> {
                    if (isBoss) {
                        io.println("보스전에서는 도주할 수 없습니다!");
                        break;
                    }
                    if (rng.nextInt(100) < 55) {
                        io.println("성공적으로 도주했습니다!");
                        return Outcome.ESCAPE;
                    } else {
                        io.println("도주 실패!");
                    }
                }
                default -> {
                }
            }

            if (enemy.isAlive()) {
                int dmg = enemy.attackDamage();
                player.takeDamage(dmg);
                io.printf("%s의 공격! 당신은 %d 피해\n", enemy.getName(), dmg);
            }

        }
        return player.isAlive() ? Outcome.WIN : Outcome.GAME_OVER;
    }

    private void castSkill(Player player, Enemy enemy, boolean isBoss, GameIO io) { // 스킬 공격
        Skill sk = chooseSkill(io);
        if (sk == null) return;

        Element targetWeakness = (isBoss && enemy instanceof Boss bs)
                ? bs.currentWeakness() : enemy.getWeakness();

        if (sk.getElement() == targetWeakness) {
            int dmg = sk.getDamage();
            enemy.takeDamage(dmg);
            io.printf("%s 명중! %s에게 %d 피해 (약점)\n", sk.getLabel(), enemy.getName(), dmg);
        } else {
            io.printf("공격 실패! 약점을 노려보세요.(적마다 약점이 있으며, 약점 속성으로 공격해야지만 데미지를 입습니다.)\n");
        }
    }

    private void useBag(Player player, GameIO io) { // 아이템 사용
        ItemType[] items = ItemType.values();
        io.println("\n== 가방 ==");
        for (int i = 0; i < items.length; i++) {
            io.printf("%d) %s x%d\n", i + 1, items[i].getLabel(),
                    player.getInventory().getOrDefault(items[i], 0));
        }
        int n = io.readInt("사용할 아이템 번호(0: 취소): ");
        if (n <= 0 || n > items.length) return;
        ItemType it = items[n - 1];
        if (player.useItem(it)) {
            io.printf("%s 사용! 현재 HP:%d\n", it.getLabel(), player.getHp());
        } else {
            io.println("아이템이 없습니다.");
        }
    }

    private Skill chooseSkill(GameIO io) {  // 스킬 선택
        Skill[] skills = Skill.values();
        io.println("\n== 스킬 선택 ==");
        for (int i = 0; i < skills.length; i++) {
            io.printf("%d) %s\n", i + 1, skills[i].getLabel());
        }
        int n = io.readInt("번호(0: 취소): ");
        if (n <= 0 || n > skills.length) return null;
        return skills[n - 1];
    }

    private String summarizeBag(Player p) { // 현재 인벤토리 상황
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (ItemType it : ItemType.values()) {
            int c = p.getInventory().getOrDefault(it, 0);
            if (c > 0) {
                if (!first) sb.append(", ");
                sb.append(it.name()).append(" x").append(c);
                first = false;
            }
        }
        return first ? "(비어있음)" : sb.toString();
    }

}
