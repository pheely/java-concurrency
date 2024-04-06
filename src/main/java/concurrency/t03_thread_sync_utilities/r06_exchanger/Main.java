package concurrency.t03_thread_sync_utilities.r06_exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
  public static void main(String[] args) {
    List<String> buffer1 = new ArrayList<>();
    List<String> buffer2 = new ArrayList<>();
    Exchanger<List<String>> exchanger = new Exchanger<>();
    new Thread(new Producer(buffer1, exchanger)).start();
    new Thread(new Consumer(buffer2, exchanger)).start();
  }
}
