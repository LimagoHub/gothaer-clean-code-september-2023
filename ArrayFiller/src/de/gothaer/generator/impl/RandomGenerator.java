package de.gothaer.generator.impl;

import de.gothaer.generator.IntGenerator;

import java.util.Random;

public class RandomGenerator implements IntGenerator {

    private final Random random = new Random();
    @Override
    public int next() {
        return random.nextInt();
    }
}
