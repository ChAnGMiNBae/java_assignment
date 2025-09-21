package com.ohgiraffers.comprehensive.application;

import com.ohgiraffers.comprehensive.domain.Player;
import com.ohgiraffers.comprehensive.domain.Stage;

public class GameContext {
    public final String userId;
    public Player player;
    public Stage stage;
    public int normalKills;

    public GameContext(String userId) {
        this.userId = userId;
    }
}
