package concurrency.t02_threadsyncbasic.r04_readwritelocks;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Writer implements Runnable{

  private PricesInfo pricesInfo;

  public Writer(PricesInfo pricesInfo) {
    this.pricesInfo = pricesInfo;
  }

  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.printf("%s: Writer: Attempt to modify the prices.\n", new Date());
      pricesInfo.setPrices(Math.random()*10, Math.random()*8);
      System.out.printf("%s: Writer: Prices have been modified.\n", new Date());
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }
}
