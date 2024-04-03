package concurrency.t01_threadmanagement.r08_threadgroup;

import java.util.Random;

public class Task implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 100 / ((int) (random.nextDouble()*1000000000));
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
                return;
            }
        }
    }
}
