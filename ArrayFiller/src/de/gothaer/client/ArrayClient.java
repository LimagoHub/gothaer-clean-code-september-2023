package de.gothaer.client;

import de.gothaer.collections.IntArrayFiller;

public class ArrayClient {

    private int feld[] = new int[Integer.MAX_VALUE/2];
    private final IntArrayFiller arrayFiller;

    public ArrayClient(final IntArrayFiller arrayFiller) {
        this.arrayFiller = arrayFiller;
    }

    public void go() {
        arrayFiller.fill(feld);
        // Do something with array
        for (int i = 0; i < 10; i++) {
            System.out.println(feld[i]);
        }
    }
}
