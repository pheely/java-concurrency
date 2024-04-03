package concurrency.t02_thread_sync_basic.r06_stamped_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class Writer implements Runnable {

  private final Position position;
  private final StampedLock lock;

  public Writer(Position position, StampedLock lock) {
    this.position = position;
    this.lock = lock;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      long stamp = lock.writeLock();
      try {
        System.out.printf("Writer: Lock acquired %d\n", stamp);
        position.setX(position.getX() + 1);
        position.setY(position.getY() + 1);
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      } finally {
        lock.unlockWrite(stamp);
      }

      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }
}
