package concurrency.t04_thread_executors.r08_controlling_finishing;

import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {
    private final String name;

    public ResultTask(ExecutableTask callable) {
        super(callable);
        name = callable.getName();
    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been canceled\n", name);
        } else {
            System.out.printf("%s: Has finished\n", name);
        }
    }
}
