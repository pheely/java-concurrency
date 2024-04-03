package concurrency.t01_threadmanagement.r09_ThreadFactory;

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
