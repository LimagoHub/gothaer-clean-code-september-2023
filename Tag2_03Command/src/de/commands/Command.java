package de.commands;

public interface Command {

    void parse(String [] tokens);
    void execute();
    void undo();
    boolean isQuery();
}
