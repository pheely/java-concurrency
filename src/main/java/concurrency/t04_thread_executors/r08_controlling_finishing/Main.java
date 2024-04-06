package concurrency.t04_thread_executors.r08_controlling_finishing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
        ResultTask[] resultTasks = new ResultTask[5];
        for (int i = 0; i < resultTasks.length; i++) {
            ExecutableTask executableTask = new ExecutableTask("Task "+i);
            resultTasks[i] = new ResultTask(executableTask);
            executor.submit(resultTasks[i]);
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < resultTasks.length; i++) {
            resultTasks[i].cancel(true);
        }
        for (int i = 0; i < resultTasks.length; i++) {
            try {
                if (!resultTasks[i].isCancelled()) {
                    System.out.printf("%s\n", resultTasks[i].get());
                }
            }catch (InterruptedException| ExecutionException ex) {
                ex.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
