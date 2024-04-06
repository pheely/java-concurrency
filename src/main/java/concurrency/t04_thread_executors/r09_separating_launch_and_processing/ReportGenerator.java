package concurrency.t04_thread_executors.r09_separating_launch_and_processing;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String> {
    private final String sender;
    private final String title;

    public ReportGenerator(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String call() throws Exception {
        try {
            Long duration = (long) (Math.random()*10);
            System.out.printf("%s_%s: ReportGenerator: Generating a report during %d second\n", sender, title, duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return sender + ": " + title;
    }
}
