package concurrency.t04_thread_executors.r07_cancelling_tasks;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task = new Task();
        System.out.printf("Main: Executing the Task\n");
        Future<String> result = executor.submit(task);
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.printf("Main: Canceling the Task\n");
        result.cancel(true);
        System.out.printf("Main: Canceled: %s\n", result.isCancelled());
        System.out.printf("Main: Done: %s\n", result.isDone());
        System.out.printf("Main: Sleep\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        executor.shutdown();
        System.out.printf("Main: The executor has finished\n");
    }
}
