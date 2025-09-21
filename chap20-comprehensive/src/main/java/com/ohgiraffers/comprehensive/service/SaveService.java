package com.ohgiraffers.comprehensive.service;

import com.ohgiraffers.comprehensive.application.GameContext;
import com.ohgiraffers.comprehensive.domain.GameSave;
import com.ohgiraffers.comprehensive.persistence.GameStorage;

import java.util.List;

public class SaveService {
    private final GameStorage storage;

    public SaveService(GameStorage storage) {
        this.storage = storage;
    }

    public List<GameSave> list(String userId) {
        return storage.loadPlayers(userId);
    }

    public void save(GameContext ctx) { // 게임 세이브
        List<GameSave> saves = storage.loadPlayers(ctx.userId);
        GameSave save = GameSave.of(ctx.userId, ctx.player, ctx.stage, ctx.normalKills);
        saves.add(save);
        storage.savePlayers(ctx.userId, saves);
    }

    public boolean loadInto(GameContext ctx, int index) { // 게임 로드
        List<GameSave> saves = storage.loadPlayers(ctx.userId);
        if (index < 0 || index >= saves.size()) return false;
        GameSave s = saves.get(index);
        ctx.player = s.getPlayer();
        ctx.stage = s.getStage();
        ctx.normalKills = s.getNormalKills();
        return true;
    }
}
