package concurrency.t04_thread_executors.r01_creation;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
  private final ThreadPoolExecutor executor;
  public Server() {
    executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime()
        .availableProcessors());
    RejectedTaskController controller = new RejectedTaskController();
    executor.setRejectedExecutionHandler(controller);
  }

  public void executeTask(Task task) {
    System.out.printf("Server: A new task has arrived\n");
    executor.execute(task);
    System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
    System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
    System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
    System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
  }

  public void endServer() {
    executor.shutdown();
  }
}
