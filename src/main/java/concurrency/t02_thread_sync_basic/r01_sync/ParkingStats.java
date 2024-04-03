package concurrency.t02_thread_sync_basic.r01_sync;

public class ParkingStats {
    private long numberCars;
    private long numberMotocycles;
    private ParkingCash cash;
    private final Object controlCars;
    private final Object controlMotorcycles;

    public ParkingStats(ParkingCash cash) {
        this.cash = cash;
        numberCars = 0;
        numberMotocycles = 0;
        controlCars = new Object();
        controlMotorcycles = new Object();
    }

    public synchronized long getNumberCars() {
        return numberCars;
    }

    public synchronized long getNumberMotocycles() {
        return numberMotocycles;
    }

    public void carComeIn() {
        synchronized (controlCars) {
            numberCars++;
        }
    }

    public void carGoOut() {
        synchronized (controlCars) {
            numberCars--;
        }
        cash.vehiclePay();
    }

    public void motoComeIn() {
        synchronized (controlMotorcycles) {
            numberMotocycles++;
        }
    }

    public void motoGoOut() {
        synchronized (controlMotorcycles) {
            numberMotocycles--;
        }
        cash.vehiclePay();
    }
}
