package com.github.fabriciolfj.exampleresilience4j.infra;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM_VALUE = new Random();

    public static boolean isValid() {
        if (RANDOM_VALUE.nextInt(100) % 2 == 0) {
            return true;
        }

        return false;
    }
}
