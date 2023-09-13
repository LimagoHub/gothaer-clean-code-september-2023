package de.gothaer.bootstrap;

import de.gothaer.client.ArrayClient;
import de.gothaer.collections.IntArrayFiller;
import de.gothaer.collections.impl.ParallelArrayFiller;
import de.gothaer.collections.impl.SequentialArrayFiller;
import de.gothaer.generator.IntGenerator;
import de.gothaer.generator.IntGeneratorBuilder;
import de.gothaer.generator.impl.RandomGenerator;
import de.gothaer.generator.impl.RandomGeneratorBuilder;
import de.gothaer.time.TimeMeasureDecorator;

public class Bootstrap {

    public void startApplication() {
        final var availableProcessors = Runtime.getRuntime().availableProcessors();
        for(int threadCount = 1; threadCount<=availableProcessors+1; threadCount++){
            createAndRunClient(threadCount);
        }
    }

    private void createAndRunClient(final int threadCount) {
        System.out.print("Messung mit " + threadCount + " Threads: ");
        if(threadCount == 1)
            createAndRunClientSequential();
        else
            createAndRunClientWithThreads(threadCount);
    }
    private static void createAndRunClientSequential() {
        final IntArrayFiller arrayFiller = createSequentialArrayFiller();
        final ArrayClient client = new ArrayClient(arrayFiller);
        client.go();
    }

    private static void createAndRunClientWithThreads(final int threadCount) {
       final IntGeneratorBuilder builder = new RandomGeneratorBuilder();
       IntArrayFiller arrayFiller = new ParallelArrayFiller(builder,threadCount);
       arrayFiller = (IntArrayFiller) TimeMeasureDecorator.newInstance(arrayFiller);
        final ArrayClient client = new ArrayClient(arrayFiller);
        client.go();
    }

    private static IntArrayFiller createSequentialArrayFiller() {
        final IntGenerator generator = new RandomGenerator();
        IntArrayFiller arrayFiller = new SequentialArrayFiller(generator);
        arrayFiller = (IntArrayFiller) TimeMeasureDecorator.newInstance(arrayFiller);
        return arrayFiller;
    }
}

