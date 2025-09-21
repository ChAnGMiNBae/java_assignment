package com.ohgiraffers.comprehensive.domain;

import java.util.Random;

public class Boss extends Enemy {
    private final Random rnd = new Random();
    private Element currentWeakness;


    public Boss() {
        super("마왕", 3, Element.FIRE); // base 값, 실제 약점은 currentWeakness로 사용
        rerollWeakness();
    }

    public Element currentWeakness() {
        return currentWeakness;
    }

    public void rerollWeakness() {
        Element[] els = Element.values();
        currentWeakness = els[rnd.nextInt(els.length)];
    }

    @Override
    public String hintLine() {
        return switch (currentWeakness) {
            case FIRE -> "마왕은 풀 속성 공격을 준비하고 있는 것 같다.";
            case WATER -> "마왕은 불 속성 공격을 준비하고 있는 것 같다.";
            case GRASS -> "마왕은 물 속성 공격을 준비하고 있는 것 같다.";
        };
    }

    @Override
    public int attackDamage() { return 1; }
}
