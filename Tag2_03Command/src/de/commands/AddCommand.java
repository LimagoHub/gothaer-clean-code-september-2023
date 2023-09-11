package de.commands;

import de.math.Calculator;

public class AddCommand implements Command{

    private double value;

    @Override
    public void parse(String[] tokens) {
        value = Double.valueOf(tokens[1]);
    }

    @Override
    public void execute() {
        Calculator.getInstance().add(value);
    }

    @Override
    public void undo() {
        Calculator.getInstance().sub(value);
    }

    @Override
    public boolean isQuery() {
        return false;
    }
}
