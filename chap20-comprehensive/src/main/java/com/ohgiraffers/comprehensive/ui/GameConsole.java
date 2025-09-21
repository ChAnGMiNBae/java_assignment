package com.ohgiraffers.comprehensive.ui;

import com.ohgiraffers.comprehensive.application.GameContext;
import com.ohgiraffers.comprehensive.domain.*;
import com.ohgiraffers.comprehensive.persistence.GameStorage;
import com.ohgiraffers.comprehensive.service.BattleService;
import com.ohgiraffers.comprehensive.service.GameService;
import com.ohgiraffers.comprehensive.service.SaveService;
import com.ohgiraffers.comprehensive.util.DefaultRandomProvider;
import com.ohgiraffers.comprehensive.util.RandomProvider;

import java.util.*;


public class GameConsole {
    private final GameIO io;
    private final GameService gameService;


    public GameConsole(GameIO io, GameService gameService) {
        this.io = io;
        this.gameService = gameService;
    }


    public GameConsole(GameIO io, GameStorage storage, RandomProvider rng) {
        this.io = io;
        SaveService save = new SaveService(storage);
        BattleService battle = new BattleService(rng);
        this.gameService = new GameService(save, battle, rng);
    }


    public GameConsole(GameIO io, GameStorage storage) {
        this(io, storage, new DefaultRandomProvider());
    }


    public void start(String userId) {
        GameContext ctx = new GameContext(userId);
        while (true) {
            io.println("\n==== 콘솔 RPG ====");
            io.println("1) 새 게임\n2) 이어하기\n0) 뒤로");
            int sel = io.readInt("선택: ");

            switch (sel) {
                case 1 -> {
                    gameService.startNew(ctx, io);  // 게임 새로 시작
                    gameService.runLoop(ctx, io);   // 바로 배틀
                }
                case 2 -> {
                    if (gameService.continueFromSave(ctx, io))  // 게임 이어서 시작
                        gameService.runLoop(ctx, io);   // 유저가 저장한 부분부터 배틀 시작
                }
                case 0 -> {
                    return;     // 다시 초기 화면으로
                }
            }
        }
    }
}

