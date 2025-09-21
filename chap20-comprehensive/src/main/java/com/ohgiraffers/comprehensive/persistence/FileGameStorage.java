package com.ohgiraffers.comprehensive.persistence;

import com.ohgiraffers.comprehensive.domain.GameSave;

import java.io.*;
import java.util.*;

public class FileGameStorage implements GameStorage {

    private static final String FILE_PATH =
            "src/main/java/com/ohgiraffers/comprehensive/db/playerDB.dat";

    @Override
    public void savePlayers(String userId, List<GameSave> saves) {
        try {
            File f = new File(FILE_PATH);
            File parent = f.getParentFile();
            if (parent != null) parent.mkdirs();

            Map<String, List<GameSave>> db = new HashMap<>();
            if (f.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                    Object obj = ois.readObject();
                    if (obj instanceof Map<?, ?> m) {
                        db = (Map<String, List<GameSave>>) m;
                    }
                } catch (EOFException ignored) {
                }
            }

            db.put(userId, new ArrayList<>(saves));

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                oos.writeObject(db);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("게임 세이브 저장 중 오류", e);
        }
    }

    @Override
    public List<GameSave> loadPlayers(String userId) {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();

            if (obj instanceof Map<?, ?> m) {
                Map<String, List<GameSave>> db = (Map<String, List<GameSave>>) m;
                List<GameSave> saves = db.get(userId);
                return saves == null ? new ArrayList<>() : new ArrayList<>(saves);
            } else {
                return new ArrayList<>();
            }
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("게임 세이브 로드 중 오류", e);
        }
    }


}