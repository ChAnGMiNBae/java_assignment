package com.ohgiraffers.comprehensive.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class GameSave implements Serializable {
    private final String saveId;
    private final String userId;
    private final Player player;
    private final Stage stage;
    private final int normalKills;
    private final LocalDateTime savedAt;

    public GameSave(String saveId, String userId, Player player, Stage stage,
                    int normalKills, LocalDateTime savedAt) {
        this.saveId = saveId;
        this.userId = userId;
        this.player = player;
        this.stage = stage;
        this.normalKills = normalKills;
        this.savedAt = savedAt;
    }

    public static GameSave of(String userId, Player player, Stage stage, int normalKills) {
        return new GameSave(UUID.randomUUID()
                .toString(), userId, player, stage, normalKills, LocalDateTime.now());
    }

    public String getSaveId() {
        return saveId;
    }

    public String getUserId() {
        return userId;
    }

    public Player getPlayer() {
        return player;
    }

    public Stage getStage() {
        return stage;
    }

    public int getNormalKills() {
        return normalKills;
    }

    public LocalDateTime getSavedAt() {
        return savedAt;
    }
}
