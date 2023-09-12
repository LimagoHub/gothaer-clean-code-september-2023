package main;

import de.gothaer.clients.GameClient;
import de.gothaer.games.nimgame.NimGameImpl;
import de.gothaer.games.nimgame.players.ComputerPlayer;
import de.gothaer.games.nimgame.players.HumanPlayer;
import de.gothaer.games.nimgame.players.OmaPlayer;
import de.gothaer.io.ConsoleWrite;
import de.gothaer.io.Writer;

public class Main {
    public static void main(String[] args) {
        try {
            mainImpl();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static void mainImpl() throws InterruptedException {
        Writer writer = new ConsoleWrite();
        NimGameImpl game = new NimGameImpl(writer);
        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        game.addPlayer(new OmaPlayer());
        GameClient client = new GameClient(game);
        client.go();
        Thread.sleep(500);
    }
}