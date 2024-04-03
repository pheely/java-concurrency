package concurrency.t01_threadmanagement.r04_wait;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LongRunningInitialization implements  Runnable{
    @Override
    public void run() {
        System.out.printf("Beginning long running initialization: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.printf("Long running initialization has finished: %s\n", new Date());
    }
}
