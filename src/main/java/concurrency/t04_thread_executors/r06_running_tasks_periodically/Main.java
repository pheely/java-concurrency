package concurrency.t04_thread_executors.r06_running_tasks_periodically;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor =
                (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s\n", new Date());
        Task task = new Task("Task");
        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            System.out.printf("Main: Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            }catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.printf("Main: No more tasks at: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.printf("Main: Finished at: %s\n", new Date());
    }
}
