package de.gothaer.games.nimgame.players;

import java.util.Scanner;

public class HumanPlayer extends AbstractNimGamePlayer{
    private final Scanner scanner = new Scanner(System.in);
    public HumanPlayer() {
    }

    public HumanPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer stones) {

        System.out.printf("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3\n", stones);
        return scanner.nextInt();
    }
}
