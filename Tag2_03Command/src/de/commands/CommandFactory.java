package de.commands;

import java.lang.reflect.InvocationTargetException;

public class CommandFactory {

    private static final String PREFIX = "de.commands.";
    private static final String SUFFIX = "Command";

    public static Command create(String zeile) {
        try {
            String [] tokens = zeile.split(" ");
            Command result = (Command) Class.forName(PREFIX + tokens[0] + SUFFIX).getConstructor().newInstance();
            result.parse(tokens);
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
