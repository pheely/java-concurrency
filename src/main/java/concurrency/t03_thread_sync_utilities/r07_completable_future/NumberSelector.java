package concurrency.t03_thread_sync_utilities.r07_completable_future;

import java.util.List;
import java.util.function.Function;

public class NumberSelector implements Function<List<Long>, Long> {

  @Override
  public Long apply(List<Long> longs) {
    System.out.printf("%s: Step 3: Start \n", Thread.currentThread().getName());
    long max = longs.stream().max(Long::compare).get();
    long min = longs.stream().min(Long::compare).get();
    long result = max/2 + min/2;
    System.out.printf("%s: Step 3: Result - %d\n",
        Thread.currentThread().getName(), result);
    return result;
  }
}
