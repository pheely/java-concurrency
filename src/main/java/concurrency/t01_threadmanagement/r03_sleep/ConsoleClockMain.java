package concurrency.t01_threadmanagement.r03_sleep;

import java.util.concurrent.TimeUnit;

public class ConsoleClockMain {
    public static void main(String[] args) {
        ConsoleClock clock = new ConsoleClock();
        Thread task = new Thread(new ConsoleClock());
        task.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        task.interrupt();
    }
}
