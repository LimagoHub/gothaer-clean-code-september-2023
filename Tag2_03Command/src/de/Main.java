package de;

import de.commands.Command;
import de.commands.CommandFactory;
import de.commands.CommandHistory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CommandHistory history = new CommandHistory();

        try(Scanner scanner = new Scanner(System.in)) {

            while(true) {
                System.out.print("#>");
                String zeile = scanner.nextLine();

                if(zeile.equalsIgnoreCase("ende")) break;
                if(zeile.equalsIgnoreCase("undo")) {
                    history.undo();
                    continue;
                }
                if(zeile.equalsIgnoreCase("redo")) {
                    history.redo();
                    continue;
                }

                Command command = CommandFactory.create(zeile);
                if(command == null) continue;;

                command.execute();
                history.addCommand(command);
            }

        }
    }
}
