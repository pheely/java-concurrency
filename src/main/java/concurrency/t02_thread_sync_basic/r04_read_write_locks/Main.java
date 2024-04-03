package concurrency.t02_thread_sync_basic.r04_read_write_locks;

public class Main {
  public static void main(String[] args) {
    PricesInfo pricesInfo = new PricesInfo();
    Reader readers[] = new Reader[5];
    Thread threads[] = new Thread[5];
    for (int i = 0; i < 5; i++) {
      readers[i] = new Reader(pricesInfo);
      threads[i] = new Thread(readers[i]);
    }
    Writer writer = new Writer(pricesInfo);
    Thread writerThread = new Thread(writer);

    for (int i = 0; i < 5; i++) {
      threads[i].start();
    }
    writerThread.start();
  }

}
