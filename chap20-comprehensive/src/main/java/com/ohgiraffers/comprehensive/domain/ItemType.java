package com.ohgiraffers.comprehensive.domain;

public enum ItemType {
    POTION("회복물약", 2);

    private final String label;
    private final int restoreHp;

    ItemType(String label, int restoreHp) {
        this.label = label;
        this.restoreHp = restoreHp;
    }

    public String getLabel() {
        return label;
    }

    public int getRestoreHp() {
        return restoreHp;
    }
}
