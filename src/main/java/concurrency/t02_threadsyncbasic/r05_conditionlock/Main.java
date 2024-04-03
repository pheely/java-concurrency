package concurrency.t02_threadsyncbasic.r05_conditionlock;

public class Main {
  public static void main(String args[]) {
    FileMock mock = new FileMock(100, 10);
    Buffer buffer = new Buffer(20);
    Thread producerThread = new Thread(new Producer(mock, buffer), "Producer");
    Consumer consumers[] = new Consumer[3];
    Thread consumerThreads[] = new Thread[3];

    for (int i = 0; i < 3; i++) {
      consumers[i] = new Consumer(buffer);
      consumerThreads[i] = new Thread(consumers[i], "Consumer");
    }

    producerThread.start();
    for (int i = 0; i < 3; i++) {
      consumerThreads[i].start();
    }
  }
}
