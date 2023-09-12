package de.gothaer;

public class LongRunnerImpl implements LongRunner{
    @Override
    public void doIt() {
        try {
            Thread.sleep(1000);
            System.out.println("ferdisch");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
