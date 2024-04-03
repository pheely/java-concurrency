package concurrency.t02_threadsyncbasic.r05_conditionlock;

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
