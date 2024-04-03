package concurrency.t01_thread_management.r06_unchecked_exception;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
