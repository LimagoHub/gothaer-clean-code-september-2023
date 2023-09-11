package de.commands;

import de.math.Calculator;

public class MultCommand implements Command{

    private double value;
    @Override
    public void parse(final String[] tokens) {
        value = Double.valueOf(tokens[1]);
    }

    @Override
    public void execute() {
        Calculator.getInstance().mult(value);
    }

    @Override
    public void undo() {
        Calculator.getInstance().div(value);
    }

    @Override
    public boolean isQuery() {
        return false;
    }
}
