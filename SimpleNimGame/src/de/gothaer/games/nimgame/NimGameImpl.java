package de.gothaer.games.nimgame;

import de.gothaer.games.Game;

import java.util.Scanner;

public class NimGameImpl implements Game {
    private final Scanner scanner = new Scanner(System.in);
    private int stones;

    private int zug;

    public NimGameImpl() {
        stones = 23;

    }

    @Override
    public void play() {
        while( ! isGameOver()) {
            playRounds();
        }
    }

    private void playRounds() { // Integration
        spielerzug();
        computerzug();
    }

    private void spielerzug() {
        if(isGameOver()) return;


        while(true) {
            System.out.printf("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3\n", stones);
            zug = scanner.nextInt();
            if(zug >=1 && zug <= 3) break;
            System.out.println("Ungueltiger zug");
        }
       terminateTurn("Spieler");
    }
    private void computerzug() {
        if(isGameOver()) return;
        final int zuege[] = {3,1,1,2};


        zug = zuege[stones % 4];
        System.out.printf("Computer nimmt %s Steine.", zug);
        terminateTurn("Computer");
    }

    private void terminateTurn(String player) {  // Integration
        updateBoard();
        printGameoverMessageIfGameIsOver(player);
    }

    private void printGameoverMessageIfGameIsOver(final String player) { // Opereration
        if(isGameOver())
            System.out.println(player + " hat verloren");
    }


    // Implemtierungssumpf ------------------------------------------
    private void updateBoard() {
        stones -= zug;
    }

    private boolean isGameOver() {
        return stones < 1;
    }
}
