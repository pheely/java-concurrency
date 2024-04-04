package concurrency.t03_thread_sync_utilities.r03_cyclicbarrier_sync_in_common_point;

public class Grouper implements Runnable {
  private final Results results;

  public Grouper(Results results) {
    this.results = results;
  }

  @Override
  public void run() {
    int finalResults = 0;
    System.out.printf("Grouper: Processing results...\n");
    int data[] = results.getData();
    for (int number:data) {
      finalResults += number;
    }
    System.out.printf("Grouper: Total result: %d\n", finalResults);
  }
}
