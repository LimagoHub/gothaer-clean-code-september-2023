package de.gothaer.io;

public class ConsoleWrite implements Writer{
    @Override
    public void write(final String message) {
        System.out.println(message);
    }
}
