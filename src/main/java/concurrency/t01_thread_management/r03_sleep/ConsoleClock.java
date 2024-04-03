package concurrency.t01_thread_management.r03_sleep;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConsoleClock implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                System.out.printf("The ConsoleClock has been interrupted\n");
            }
        }
    }
}
