package main;

import de.gothaer.clients.GameClient;
import de.gothaer.games.Game;
import de.gothaer.games.nimgame.NimGameImpl;

public class Main {
    public static void main(String[] args) {
        Game game = new NimGameImpl();
        GameClient client = new GameClient(game);
        client.go();
    }
}