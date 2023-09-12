package de.gothaer.games.nimgame.players;

import de.gothaer.games.players.AbstractPlayer;

public abstract class AbstractNimGamePlayer extends AbstractPlayer<Integer,Integer> {

    private final String name;

    public AbstractNimGamePlayer() {
        name = this.getClass().getSimpleName();
    }
    public AbstractNimGamePlayer(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
