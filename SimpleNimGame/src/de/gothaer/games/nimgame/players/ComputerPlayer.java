package de.gothaer.games.nimgame.players;

public class ComputerPlayer extends AbstractNimGamePlayer{

    private static final int []ZUEGE = {3,1,1,2};
    public ComputerPlayer() {
    }

    public ComputerPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer stones) {
        int zug = ZUEGE[stones % 4];
        System.out.printf("Computer nimmt %s Steine.%n", zug);
        return zug;
    }
}
