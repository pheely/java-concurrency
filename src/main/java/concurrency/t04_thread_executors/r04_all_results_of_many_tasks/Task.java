package concurrency.t04_thread_executors.r04_all_results_of_many_tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
  private final String name;

  public Task(String name) {
    this.name = name;
  }

  @Override
  public Result call() throws Exception {
    System.out.printf("%s: Starting\n", name);
    try {
      long duration = (long)(Math.random()*10);
      System.out.printf("%s: Waiting %d seconds for results.\n", name, duration);
      TimeUnit.SECONDS.sleep(duration);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    int value = 0;
    for (int i = 0; i < 5; i++) {
      value += (int)(Math.random()*100);
    }
    Result result = new Result();
    result.setName(this.name);
    result.setValue(value);
    System.out.printf("%s: Ends\n", name);

    return result;
  }
}
