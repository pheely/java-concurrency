package java9concurrency.ch01.threadmanagement.r09.ThreadFactory;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private String name;
    private List<String> stats;
    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s", t.getId(), t.getName(), new Date()));
        return t;
    }

    public String getStats() {
        StringBuffer buffer = new StringBuffer();
        for (String stat : stats) {
            buffer.append(stat).append("\n");
        }
        return buffer.toString();
    }
}
