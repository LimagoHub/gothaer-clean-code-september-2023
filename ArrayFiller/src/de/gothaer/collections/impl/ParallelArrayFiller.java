package de.gothaer.collections.impl;

import de.gothaer.collections.IntArrayFiller;
import de.gothaer.generator.IntGenerator;
import de.gothaer.generator.IntGeneratorBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelArrayFiller implements IntArrayFiller {

    private int [] feld;
    private final IntGeneratorBuilder generatorBuilder;
    private final int threadCount;

    private int segmentSize;

    private ExecutorService service;


    public ParallelArrayFiller(final IntGeneratorBuilder generatorBuilder, final int threadCount) {
        this.generatorBuilder = generatorBuilder;
        this.threadCount = threadCount;
    }

    @Override
    public int[] fill(final int[] fieldToPopulate) {
        this.feld = fieldToPopulate;
        fillArraySegmentsParallel();
        return fieldToPopulate;
    }

    private void fillArraySegmentsParallel() {
        calculateSegmentSize();
        tryStartExecuterServiceToFillSegments();
    }

    private void tryStartExecuterServiceToFillSegments() {
        try {
            startExecuterServiceToFillSegments();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void startExecuterServiceToFillSegments() throws InterruptedException {
        service = Executors.newFixedThreadPool(threadCount);
        startSegmentWorkers();
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startSegmentWorkers() {
        for (int actThreadNumber = 0; actThreadNumber < threadCount ; actThreadNumber++) {
            startSingleWorker(actThreadNumber);
        }
    }

    private void startSingleWorker(final int actThreadNumber) {
        final int start = actThreadNumber * segmentSize;
        final int end = start + segmentSize;
        service.execute(new MyFillSegmentWorker(start, end));
    }

    private void calculateSegmentSize() {
        segmentSize = feld.length / threadCount;
    }


    class MyFillSegmentWorker implements Runnable {
        private final IntGenerator generator;
        private final int segmentStart;
        private final int segmentEnd;

        public MyFillSegmentWorker(final int segmentStart, final int segmentEnd) {
            generator = generatorBuilder.create();
            this.segmentStart = segmentStart;
            this.segmentEnd = segmentEnd;
        }

        @Override
        public void run() {
            for (int i = segmentStart; i < segmentEnd; i++) {
                feld[i] = generator.next();
            }
        }
    }
}
