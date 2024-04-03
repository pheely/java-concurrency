package concurrency.t02_threadsyncbasic.r06_stampedlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import jdk.jfr.internal.settings.StackTraceSetting;

public class OptimisticReader implements Runnable {
  private final Position position;
  private final StampedLock lock;

  public OptimisticReader(Position position, StampedLock lock) {
    this.position = position;
    this.lock = lock;
  }

  @Override
  public void run() {
    long stamp;
    for (int i = 0; i < 100; i++) {
      try {
        stamp = lock.tryOptimisticRead();
        int x = position.getX();
        int y = position.getY();
        if (lock.validate(stamp)) {
          System.out.printf("OptimisticReader: %d - (%d,%d)\n", stamp, x, y);
        } else {
          System.out.printf("OptimisticReader: %d - Not Free\n", stamp);
        }
        TimeUnit.MILLISECONDS.sleep(200);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }
}
