package de.gothaer.games.nimgame;

import de.gothaer.games.AbstractGame;
import de.gothaer.io.Writer;



public class NimGameImpl extends AbstractGame<Integer,Integer> {


    public NimGameImpl(final Writer writer) {
        super(writer);
        setBoard(23);
    }

    // Implemtierungssumpf ------------------------------------------)
    protected void updateBoard() {
        setBoard(getBoard() - getTurn());
    }

    protected boolean isGameOver() {
        return getBoard() < 1 || getPlayers().isEmpty();
    }

    protected boolean isTurnValid() {
        return getTurn() >= 1 && getTurn() <= 3;
    }
}
