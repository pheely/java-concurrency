package concurrency.t03_thread_sync_utilities.r02_countdownlatch_concurrent_event;

public class Main {
    public static void main(String[] args) {
        VideoConference conference = new VideoConference(10);
        new Thread(conference).start();

        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(conference, "Participant " + i);
            new Thread(participant).start();
        }
    }
}
