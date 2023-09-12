package de.gothaer.games;

import de.gothaer.games.players.Player;
import de.gothaer.io.Writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGame<BOARD, TURN> implements  Game{

    private final Writer writer;

    private final List<Player<BOARD,TURN>> players = new ArrayList<>();

    private BOARD board;

    private TURN turn;

    public AbstractGame(final Writer writer) {
        this.writer = writer;
    }


    private Player<BOARD,TURN> currentPlayer;

    protected Player<BOARD, TURN> getCurrentPlayer() {
        return currentPlayer;
    }

    protected void setCurrentPlayer(final Player<BOARD, TURN> currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    protected Writer getWriter() {
        return writer;
    }

    protected BOARD getBoard() {
        return board;
    }

    protected void setBoard(final BOARD board) {
        this.board = board;
    }

    protected TURN getTurn() {
        return turn;
    }

    protected void setTurn(final TURN turn) {
        this.turn = turn;
    }

    protected List<Player<BOARD, TURN>> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void addPlayer(Player<BOARD,TURN> player) {
        players.add(player);
    }

    public void removePlayer(Player<BOARD,TURN> player) {
        players.remove(player);
    }

    @Override
    public void play() {
        while( ! isGameOver()) playRounds();
    }

    private void playRounds() { // Integration
        players.forEach(this::setActivePlayerAndInitiateHisTurn);
    }

    private void setActivePlayerAndInitiateHisTurn(final Player<BOARD, TURN> player) {
        setCurrentPlayer(player);
        playSingleTurn();
    }

    private void playSingleTurn() {
        if(isGameOver()) return;
        executePlayersTurnUntilValid();
        terminateTurn();
    }


    private void executePlayersTurnUntilValid() {
        do {
            turn = getCurrentPlayer().doTurn(board);
        } while(turnIsInValid());
    }

    private void terminateTurn() {  // Integration
        updateBoard();
        printGameoverMessageIfGameIsOver();
    }

    private void printGameoverMessageIfGameIsOver() { // Opereration
        if(isGameOver()) write(getCurrentPlayer().getName() + " hat verloren");
    }

    boolean turnIsInValid() {
        if(isTurnValid()) return false;
        write("Ungueltiger zug");
        return true;
    }

    protected void write(String message) {
        writer.write(message);
    }
    //----- Sumpf

    protected abstract boolean isGameOver() ;
    protected abstract void updateBoard();

    protected abstract boolean isTurnValid();
}
