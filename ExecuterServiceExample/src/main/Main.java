package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try {
            ExecutorService service = Executors.newFixedThreadPool(2);
            for (int i = 0; i < 4; i++) {
                service.execute(new MyRunner());
            }
            service.execute(this::doit);
            service.shutdown();
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            System.out.println("Ende");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void doit() {
        try {
            Thread.sleep((long)(Math.random() * 1000));
            System.out.println(Thread.currentThread().getId() + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    class MyRunner implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep((long)(Math.random() * 1000));
                System.out.println(Thread.currentThread().getId() + " finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}