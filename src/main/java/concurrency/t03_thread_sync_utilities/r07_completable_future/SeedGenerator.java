package concurrency.t03_thread_sync_utilities.r07_completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SeedGenerator implements Runnable {
  private CompletableFuture<Integer> resultCommunicator;

  public SeedGenerator(CompletableFuture<Integer> resultCommunicator) {
    this.resultCommunicator = resultCommunicator;
  }

  @Override
  public void run() {
    System.out.printf("SeedGenerator: Generating seed...\n");
    try {
      TimeUnit.SECONDS.sleep(5);
    }catch(InterruptedException ex) {
      ex.printStackTrace();
    }
    int seed = (int) (Math.rint(Math.random()*10));
    System.out.printf("SeedGenerator: Seed generated: %d\n", seed);
    resultCommunicator.complete(seed);
  }
}
