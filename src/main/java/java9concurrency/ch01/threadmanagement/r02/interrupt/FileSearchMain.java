package java9concurrency.ch01.threadmanagement.r02.interrupt;

import java.util.concurrent.TimeUnit;

public class FileSearchMain {
    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("/Users/pyang/Documents/github.com/docs", "README.md");
        Thread thread = new Thread(searcher);
        thread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        thread.interrupt();
//        System.out.printf("Main: timeout reached\n");
    }
}
