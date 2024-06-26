package concurrency.t01_thread_management.r04_wait;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements  Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning network connections loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.printf("Network connections loading has finished: %s\n", new Date());
    }
}
