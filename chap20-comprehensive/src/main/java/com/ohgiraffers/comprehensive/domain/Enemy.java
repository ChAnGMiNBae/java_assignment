package com.ohgiraffers.comprehensive.domain;

import java.io.Serializable;

public class Enemy implements Serializable {
    private final String name;
    private final int maxHp;
    private int hp;
    private final Element weakness;

    public Enemy(String name, int hp, Element weakness) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.weakness = weakness;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public Element getWeakness() { return weakness; }
    public boolean isAlive() { return hp > 0; }
    public void takeDamage(int dmg) { hp = Math.max(0, hp - dmg); }
    public int attackDamage() { return 1; }

    public String hintLine() { return ""; } // 기본 적은 힌트 없음
}
