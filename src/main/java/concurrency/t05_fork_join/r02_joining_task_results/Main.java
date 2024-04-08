package concurrency.t05_fork_join.r02_joining_task_results;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        DocumentMock mock = new DocumentMock();
        String[][] document = mock.generateDocument(100, 100, "java");

        DocumentTask task = new DocumentTask(document, 0, 100, "java");
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        commonPool.execute(task);
        do {
            System.out.printf("*******************************\n");
            System.out.printf("Main: Parallelism: %d\n", commonPool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", commonPool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", commonPool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", commonPool.getStealCount());
            System.out.printf("*******************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } while (!task.isDone());
        commonPool.shutdown();

        try {
            commonPool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        try {
            System.out.printf("Main: The word appears %d times in the document.\n", task.get());
        }catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
