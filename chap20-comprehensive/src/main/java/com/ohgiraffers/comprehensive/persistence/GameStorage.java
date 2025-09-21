package com.ohgiraffers.comprehensive.persistence;

import com.ohgiraffers.comprehensive.domain.GameSave;

import java.util.List;

public interface GameStorage {

    void savePlayers(String userId, List<GameSave> saves);
    List<GameSave> loadPlayers(String userId);
}
