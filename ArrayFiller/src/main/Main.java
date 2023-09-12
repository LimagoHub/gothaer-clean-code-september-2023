package main;

import de.gothaer.LongRunner;
import de.gothaer.LongRunnerImpl;
import de.gothaer.time.TimeMesuareDecortor;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private final int [] feld = new int [Integer.MAX_VALUE / 2];

    private final Random random = new Random();
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        LongRunner longRunner = new LongRunnerImpl();

        longRunner = (LongRunner) TimeMesuareDecortor.newInstance(longRunner);

        longRunner.doIt();


//        Stream<Integer> s;
//        IntStream is;
//
//        var availableProcessors = Runtime.getRuntime().availableProcessors();
//        for (int threadCount = 1; threadCount <= availableProcessors + 1 ; threadCount++) {
//            var start = Instant.now();
//            for (int i = 0; i < feld.length; i++) {
//                feld[i] = random.nextInt();
//            }
//            var end = Instant.now();
//            var duration = Duration.between(start, end);
//            System.out.println(String.format("Dauer = %s ms", duration.toMillis()));
//        }

    }
}