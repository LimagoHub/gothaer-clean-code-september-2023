package de.gothaer.collections.impl;

import de.gothaer.collections.IntArrayFiller;
import de.gothaer.generator.IntGenerator;

public class SequentialArrayFiller implements IntArrayFiller {


    private final IntGenerator generator;


    public SequentialArrayFiller(final IntGenerator generator) {
        this.generator = generator;
    }

    @Override
    public int[] fill(final int[] fieldToPopulate) {

        for (int i = 0; i < fieldToPopulate.length ; i++) {
            fieldToPopulate[i] = generator.next();
        }
        return fieldToPopulate;
    }
}
