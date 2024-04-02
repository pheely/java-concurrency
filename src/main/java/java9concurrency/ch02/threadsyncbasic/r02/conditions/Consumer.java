package java9concurrency.ch02.threadsyncbasic.r02.conditions;

import org.checkerframework.checker.units.qual.C;

public class Consumer implements Runnable {
    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
