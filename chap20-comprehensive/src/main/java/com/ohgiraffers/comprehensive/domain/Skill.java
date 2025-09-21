package com.ohgiraffers.comprehensive.domain;

public enum Skill {
    FIREBALL("파이어볼", Element.FIRE, 1),
    WATER_CUTTER("워터커터", Element.WATER, 1),
    LEAF_STORM("리프스톰", Element.GRASS, 1);


    private final String label;
    private final Element element;
    private final int damage;

    Skill(String label, Element element, int damage) {
        this.label = label;
        this.element = element;
        this.damage = damage;
    }

    public String getLabel() {
        return label;
    }

    public Element getElement() {
        return element;
    }

    public int getDamage() {
        return damage;
    }
}
