package concurrency.t04_thread_executors.r02_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    List<Future<Integer>> resultList = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      Integer number = random.nextInt(10);
      System.out.printf("Main: random number %d: %d\n", i, number);
      FactorialCalculator calculator = new FactorialCalculator(number);
      Future<Integer> result = executor.submit(calculator);
      resultList.add(result);
    }
    do {
      System.out.printf("Main: Number of Completed Tasks: %d\n",
          executor.getCompletedTaskCount());
      for (int i = 0; i < resultList.size(); i++) {
        Future<Integer> result = resultList.get(i);
        System.out.printf("Main: Task %d: %s\n", i, result.isDone());
      }
      try {
        TimeUnit.MICROSECONDS.sleep(50);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    } while (executor.getCompletedTaskCount() < resultList.size());

    System.out.printf("Main: Results\n");
    for (int i = 0; i < resultList.size(); i++) {
      Future<Integer> result = resultList.get(i);
      Integer number = null;
      try {
        number = result.get();
      } catch (InterruptedException | ExecutionException ex) {
        ex.printStackTrace();
      }
      System.out.printf("Main: Task %d: %d\n", i, number);
    }
    executor.shutdown();
  }

}
