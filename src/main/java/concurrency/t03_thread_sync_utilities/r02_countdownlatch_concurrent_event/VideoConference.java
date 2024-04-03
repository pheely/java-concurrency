package concurrency.t03_thread_sync_utilities.r02_countdownlatch_concurrent_event;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {
    private CountDownLatch controller;

    public VideoConference(int number) {
        controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
        try {
            controller.await();
            System.out.printf("VideoConference: All the participants come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
