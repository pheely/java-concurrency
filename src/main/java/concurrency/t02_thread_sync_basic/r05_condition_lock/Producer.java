package concurrency.t02_thread_sync_basic.r05_condition_lock;

public class Producer implements Runnable {
  private FileMock mock;
  private Buffer buffer;

  public Producer(FileMock mock, Buffer buffer) {
    this.buffer = buffer;
    this.mock = mock;
  }

  @Override
  public void run() {
    buffer.setPendingLines(true);
    while (mock.hasMoreLines()) {
      buffer.insert(mock.getLine());
    }
    buffer.setPendingLines(false);
  }
}
