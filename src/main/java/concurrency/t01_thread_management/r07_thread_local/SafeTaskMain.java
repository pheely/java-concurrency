package concurrency.t01_thread_management.r07_thread_local;

import java.util.concurrent.TimeUnit;

public class SafeTaskMain {
    public static void main(String args[]) {
        SafeTask task = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
