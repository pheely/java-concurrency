package concurrency.t03_thread_sync_utilities.r04_phaser_concurrent_phased_tasks;

import java.util.concurrent.Phaser;

public class Main {
  public static void main(String[] args) {
    Phaser phaser = new Phaser(3);
    FileSearch system = new FileSearch("/System", "log", phaser);
    FileSearch apps = new FileSearch("/Application", "log", phaser);
    FileSearch users = new FileSearch("/Users", "log", phaser);
    Thread systemThread = new Thread(system);
    systemThread.start();
    Thread appsThead = new Thread(apps);
    appsThead.start();
    Thread usersThread = new Thread(users);
    usersThread.start();

    try {
      systemThread.join();
      appsThead.join();
      usersThread.join();
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    System.out.println("Terminated: " + phaser.isTerminated());
  }
}
