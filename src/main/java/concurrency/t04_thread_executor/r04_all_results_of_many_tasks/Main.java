package concurrency.t04_thread_executor.r04_all_results_of_many_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
  public static void main(String[] args) {
    ExecutorService executor =
        (ExecutorService) Executors.newCachedThreadPool();
    List<Task> taskList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Task task = new Task("Task-" + i);
      taskList.add(task);
    }
    List<Future<Result>> resultList = null;
    try {
      resultList = executor.invokeAll(taskList);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    executor.shutdown();
    System.out.printf("Main: Printing the results\n");
    for (int i = 0; i < resultList.size(); i++) {
      Future<Result> future = resultList.get(i);
      try {
        Result result = future.get();
        System.out.printf("%s: %d\n", result.getName(), result.getValue());
      } catch (InterruptedException | ExecutionException ex) {
        ex.printStackTrace();
      }
    }
  }

}
