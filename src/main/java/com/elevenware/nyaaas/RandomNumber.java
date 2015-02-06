package com.elevenware.nyaaas;

import java.util.Random;

public class RandomNumber {

    private static Random random;

    static {
        random = new Random(Long.getLong("random.seed", System.currentTimeMillis()));
    }

    public int nextInt(int range) {
        return random.nextInt(range);
    }

    public static void seed(long seed) {
        random = new Random(seed);
    }
}
