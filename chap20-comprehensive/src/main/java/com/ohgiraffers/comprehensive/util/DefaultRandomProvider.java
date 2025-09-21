package com.ohgiraffers.comprehensive.util;

import java.util.Random;

public class DefaultRandomProvider implements RandomProvider {
    private final Random rnd;

    public DefaultRandomProvider() {
        this.rnd = new Random();
    }

    public DefaultRandomProvider(long seed) {
        this.rnd = new Random(seed);
    }

    @Override
    public int nextInt(int bound) {
        return rnd.nextInt(bound);
    }
}
