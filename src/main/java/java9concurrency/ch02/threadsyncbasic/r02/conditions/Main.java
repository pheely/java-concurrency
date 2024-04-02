package java9concurrency.ch02.threadsyncbasic.r02.conditions;

import org.checkerframework.checker.units.qual.C;

public class Main {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Thread producer = new Thread(new Producer(storage));
        Thread consumer = new Thread(new Consumer(storage));
        producer.start();
        consumer.start();
    }
}
