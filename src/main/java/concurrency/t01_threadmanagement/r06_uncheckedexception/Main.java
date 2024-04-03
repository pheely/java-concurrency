package concurrency.t01_threadmanagement.r06_uncheckedexception;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
