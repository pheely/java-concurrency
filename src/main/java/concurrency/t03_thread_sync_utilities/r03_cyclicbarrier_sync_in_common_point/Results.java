package concurrency.t03_thread_sync_utilities.r03_cyclicbarrier_sync_in_common_point;

public class Results {
  private final int data[];

  public Results(int size) {
    data = new int[size];
  }

  public void setData(int position, int value) {
    data[position] = value;
  }

  public int[] getData() {
    return data;
  }
}
