package de.gothaer.games.nimgame.players;

import java.util.Random;

public class OmaPlayer extends AbstractNimGamePlayer{

    private static final Random RANDOM = new Random();
    public OmaPlayer() {
    }

    public OmaPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer stones) {
        final int zug = RANDOM.nextInt(5) +1 ;
        System.out.printf("Oma nimmt %s Steine.\n", zug);
        return zug;
    }
}
