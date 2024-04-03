package concurrency.t01_thread_management.r02_interrupt;

public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }
            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been interrupted\n");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number > 0 && number <= 2) return true;
        for (long i = 2L; i < number; i++) {
            if ( number % i == 0) return false;
        }
        return true;
    }
}
