package java9concurrency.ch02.threadsyncbasic.r03.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private Lock queueLock;

    public PrintQueue(boolean fairMode) {
        queueLock = new ReentrantLock(fairMode);
    }

    public void printJob(Object document) {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random()*10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration/1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally {
            queueLock.unlock();
        }

        queueLock.lock();
        try {
            Long duration = (long) (Math.random()*10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration/1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally {
            queueLock.unlock();
        }
    }
}
