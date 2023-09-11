package de.gothaer.games.nimgame;

import de.gothaer.games.Game;

import java.util.Scanner;

public class NimGameImpl implements Game {
    private final Scanner scanner = new Scanner(System.in);
    private int stones;


    public NimGameImpl() {
        stones = 23;

    }

    @Override
    public void play() {
        while( ! isGameOver()) {
            playRounds();
        }
    }

    private void playRounds() {
        spielerzug();
        computerzug();
    }

    private void spielerzug() {
        int zug;

        while(true) {
            System.out.printf("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3\n", stones);
            zug = scanner.nextInt();
            if(zug >=1 && zug <= 3) break;
            System.out.println("Ungueltiger zug");
        }
        stones -= zug;
    }
    private void computerzug() {
        final int zuege[] = {3,1,1,2};
        int zug;

        if(stones == 1) {
            System.out.println("Du hast nur Glueck gehabt!");

            return;
        }

        if(stones < 1) {
            System.out.println("Du Loser!");

            return;
        }

        zug = zuege[stones % 4];
        System.out.printf("Computer nimmt %s Steine.", zug);
        stones -= zug;
    }

    private boolean isGameOver() {
        return stones < 1;
    }
}
