package main;

import de.gothaer.clients.GameClient;
import de.gothaer.games.Game;
import de.gothaer.games.nimgame.NimGameImpl;
import de.gothaer.games.nimgame.players.ComputerPlayer;
import de.gothaer.games.nimgame.players.HumanPlayer;
import de.gothaer.io.ConsoleWrite;
import de.gothaer.io.Writer;

public class Main {
    public static void main(String[] args) {
        Writer writer = new ConsoleWrite();
        NimGameImpl game = new NimGameImpl(writer);
        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        GameClient client = new GameClient(game);
        client.go();
    }
}