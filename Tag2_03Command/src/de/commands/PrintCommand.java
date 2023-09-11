package de.commands;

import de.math.Calculator;

public class PrintCommand extends AbstractCommand{

    @Override
    public void execute() {
        Calculator.getInstance().print();
    }
}
