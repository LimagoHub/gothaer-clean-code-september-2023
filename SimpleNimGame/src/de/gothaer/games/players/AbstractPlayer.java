package de.gothaer.games.players;

public abstract class AbstractPlayer<BOARD,TURN> implements Player<BOARD,TURN>{

    private final String name;

    public AbstractPlayer() {
        this.name = getClass().getSimpleName();
    }
    public AbstractPlayer(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
