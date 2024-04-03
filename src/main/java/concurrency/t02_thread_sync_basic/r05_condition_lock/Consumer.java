package concurrency.t02_thread_sync_basic.r05_condition_lock;

import java.util.Random;

public class Consumer implements Runnable {
  private Buffer buffer;

  public Consumer(Buffer buffer) {
    this.buffer = buffer;
  }
  @Override
  public void run() {
    while (buffer.hasPendingLines()) {
      processLine(buffer.get());
    }
  }

  private void processLine(String line) {
    try {
      Random random = new Random();
      Thread.sleep(random.nextInt(100));
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}
