package com.ohgiraffers.comprehensive.domain;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

public class Player implements Serializable {
    private final String nickname;
    private int hp;
    private final int maxHp;
    private int gold;
    private final Map<ItemType, Integer> inventory = new EnumMap<>(ItemType.class);

    public Player(String nickname, int hp, int maxHp, int gold) {
        this.nickname = nickname;
        this.hp = hp;
        this.maxHp = maxHp;
        this.gold = gold;
    }

    public String getNickname() {
        return nickname;
    }

    public int getHp() {
        return hp;
    }

    public int getGold() {
        return gold;
    }

    public Map<ItemType,Integer> getInventory() {
        return inventory;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void addItem(ItemType item, int count) {
        inventory.merge(item, count, Integer::sum);
    }

    public boolean useItem(ItemType item) {
        int have = inventory.getOrDefault(item, 0);
        if (have <= 0) return false;
        inventory.put(item, have - 1);
        if (item.getRestoreHp() > 0) heal(item.getRestoreHp());
        return true;
    }

    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
    }

    public void takeDamage(int dmg) {
        hp = Math.max(0, hp - dmg);
    }

    public void addGold(int g) {
        gold += g;
    }
}
