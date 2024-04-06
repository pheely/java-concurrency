package concurrency.t04_thread_executors.r08_controlling_finishing;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String> {
    private final String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String call() throws Exception {
        try {
            long duration = (long)(Math.random()*10);
            System.out.printf("%s: Waiting %d seconds for result\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "Hello, world. I'm " + name;
    }
}
