package de.commands;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {

    private Deque<Command> undoDeque = new ArrayDeque<>();
    private Deque<Command> redoDeque = new ArrayDeque<>();

    public void addCommand(Command command) {
        if(command.isQuery()) return;
        redoDeque.clear();
        undoDeque.push(command);
    }

    public void undo() {
        if(undoDeque.isEmpty())
            System.out.println("can't undo");
        else {
            Command command = undoDeque.pop();
            command.undo();
            redoDeque.push(command);
        }
    }

    public void redo() {
        if(redoDeque.isEmpty())
            System.out.println("can't redo");
        else {
            Command command = redoDeque.pop();
            command.execute();
            undoDeque.push(command);
        }
    }

}
