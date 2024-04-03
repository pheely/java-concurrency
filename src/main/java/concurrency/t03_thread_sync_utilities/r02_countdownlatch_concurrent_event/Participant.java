package concurrency.t03_thread_sync_utilities.r02_countdownlatch_concurrent_event;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
    private VideoConference conference;
    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        conference.arrive(name);
    }
}
