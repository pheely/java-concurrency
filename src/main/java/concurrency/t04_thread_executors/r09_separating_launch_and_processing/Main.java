package concurrency.t04_thread_executors.r09_separating_launch_and_processing;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
        CompletionService<String> service = new ExecutorCompletionService<>(executor);
        ReportRequest faceRequest = new ReportRequest("Face", service);
        ReportRequest onlineRequest = new ReportRequest("Online", service);
        Thread faceThread = new Thread(faceRequest);
        Thread onlineThread = new Thread(onlineRequest);
        ReportProcessor processor = new ReportProcessor(service);
        Thread senderThread = new Thread(processor);
        System.out.printf("Main: Starting the threads\n");
        faceThread.start();
        onlineThread.start();
        senderThread.start();
        try {
            System.out.printf("Main: Waiting for the report generator.\n");
            faceThread.join();
            onlineThread.join();
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.printf("Main: Shutting down the executor.\n");
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        processor.stopProcessing();
        System.out.printf("Main: Ends");
    }
}
