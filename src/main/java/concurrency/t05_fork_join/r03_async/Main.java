package concurrency.t05_fork_join.r03_async;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor java = new FolderProcessor("/Users/pyang/Documents/github.com/docs/java", "md");
        FolderProcessor go = new FolderProcessor("/Users/pyang/Documents/github.com/docs/go", "md");
        FolderProcessor docker = new FolderProcessor("/Users/pyang/Documents/github.com/docs/docker", "md");
        pool.execute(java);
        pool.execute(go);
        pool.execute(docker);
        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n",pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n",pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n",pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n",pool.getStealCount());
            System.out.printf("Main: %b - %b - %b\n",java.isDone(), go.isDone(), docker.isDone());
            System.out.printf("Main: %d - %d - %d\n",java.getPendingCount(), go.getPendingCount(), docker.getPendingCount());
            System.out.printf("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!java.isDone() || !go.isDone() || !docker.isDone());
        pool.shutdown();

        List<String> results;
        results = java.getResultList();
        System.out.printf("java: %d files found.\n", results.size());
        results = go.getResultList();
        System.out.printf("go: %d files found.\n", results.size());
        results = docker.getResultList();
        System.out.printf("docker: %d files found.\n", results.size());
    }
}
