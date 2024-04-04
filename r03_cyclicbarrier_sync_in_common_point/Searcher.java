package concurrency.t03_thread_sync_utilities.r03_cyclicbarrier_sync_in_common_point;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
  private final int firstRow;
  private final int lastRow;
  private final MatrixMock mock;
  private final Results results;
  private final int number;
  private CyclicBarrier barrier;

  public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results,
      int number, CyclicBarrier barrier) {
    this.firstRow = firstRow;
    this.lastRow = lastRow;
    this.mock = mock;
    this.results = results;
    this.number = number;
    this.barrier = barrier;
  }

  @Override
  public void run() {
    int counter;
    System.out.printf("%s: Processing lines from %d to %d.\n",
        Thread.currentThread().getName(), firstRow, lastRow);
    for (int i = firstRow; i < lastRow; i++) {
      int row[] = mock.getRow(i);
      if (null == row) {
        System.out.printf("Error: %s: row %d is null",
            Thread.currentThread().getName(), i);
      }
      counter = 0;
      for (int j = 0; j < row.length; j++) {
        if (row[j] == number) {
          counter++;
        }
      }
      results.setData(i, counter);
    }
    System.out.printf("%s: Lines processed. \n",
        Thread.currentThread().getName());

    // wait for other threads
    try {
      barrier.await();
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    } catch (BrokenBarrierException ex) {
      ex.printStackTrace();
    }
  }
}
