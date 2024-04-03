package concurrency.t03_thread_sync_utilities.r01_semaphore_accessing_resource_pool;

public class Main {
    public static void main(String args[]) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[12];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread" + i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
