package java9concurrency.ch01.threadmanagement.r09.ThreadFactory;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
