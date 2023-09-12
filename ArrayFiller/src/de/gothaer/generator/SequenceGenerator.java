package de.gothaer.generator;

import java.util.function.Function;

public class SequenceGenerator implements IntGenerator{

    private int oldvalue;
    private Function<Integer,Integer> function;

    public SequenceGenerator(final int seed, final Function<Integer,Integer> function) {
        this.oldvalue = seed;
        this.function = function;
    }

    @Override
    public int next() {
        oldvalue = function.apply(oldvalue);
        return oldvalue;
    }
}
