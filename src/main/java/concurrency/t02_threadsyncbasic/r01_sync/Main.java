package concurrency.t02_threadsyncbasic.r01_sync;

public class Main {
    public static void main(String[] args) {
        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);

        System.out.printf("Parking Simulator\n");

        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread threads[] = new Thread[numberSensors];
        for (int i = 0; i < numberSensors; i++) {
            Thread thread = new Thread(new Sensor(stats));
            thread.start();
            threads[i] = thread;
        }

        for (int i = 0; i < numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        System.out.printf("Number of cars: %d\n", stats.getNumberCars());
        System.out.printf("Number of motocycles: %d\n", stats.getNumberMotocycles());
        cash.close();
    }
}
