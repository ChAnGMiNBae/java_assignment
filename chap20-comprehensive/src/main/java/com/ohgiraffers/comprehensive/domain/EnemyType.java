package com.ohgiraffers.comprehensive.domain;

public enum EnemyType {
    SLIME("슬라임", 1, Element.GRASS),
    ZOMBIE("좀비", 1, Element.FIRE),
    GOLEM("골렘", 1, Element.WATER);

    private final String enemyName;
    private final int baseHp;
    private final Element weakness;

    EnemyType(String name, int hp, Element weakness) {
        this.enemyName = name;
        this.baseHp = hp;
        this.weakness = weakness;
    }

    public Enemy spawn() {
        return new Enemy(enemyName, baseHp, weakness);
    }
}
