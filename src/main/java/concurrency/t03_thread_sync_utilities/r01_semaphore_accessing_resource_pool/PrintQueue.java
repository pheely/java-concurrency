package concurrency.t03_thread_sync_utilities.r01_semaphore_accessing_resource_pool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Date;

public class PrintQueue {
    private final Semaphore semaphore;
    private final boolean freePrinters[];
    private final Lock lockPrinters;

    public PrintQueue() {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        lockPrinters = new ReentrantLock();
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s - %s: PrintQueue: Printing a Job on Printer %d for %d seconds\n",
                    new Date(), Thread.currentThread().getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int getPrinter() {
        int ret = -1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < 3; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }

}
