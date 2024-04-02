package java9concurrency.ch01.threadmanagement.r06.uncheckedexception;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
