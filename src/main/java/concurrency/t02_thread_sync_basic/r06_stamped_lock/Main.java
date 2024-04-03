package concurrency.t02_thread_sync_basic.r06_stamped_lock;

import java.util.concurrent.locks.StampedLock;

public class Main {
  public static void main(String args[]) {
    Position position = new Position();
    StampedLock lock = new StampedLock();

    Thread writer = new Thread(new Writer(position, lock));
    Thread reader = new Thread(new Reader(position, lock));
    Thread optimisticReader = new Thread(new OptimisticReader(position, lock));
    writer.start();
    reader.start();
    optimisticReader.start();

    try {
      writer.join();
      reader.join();
      optimisticReader.join();
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }

}
