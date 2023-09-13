package de.gothaer.generator.impl;


import de.gothaer.generator.IntGenerator;
import de.gothaer.generator.IntGeneratorBuilder;

public class RandomGeneratorBuilder implements IntGeneratorBuilder {
    @Override
    public IntGenerator create() {
        return new RandomGenerator();
    }
}
