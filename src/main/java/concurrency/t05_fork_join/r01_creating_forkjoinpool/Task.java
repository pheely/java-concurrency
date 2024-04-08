package concurrency.t05_fork_join.r01_creating_forkjoinpool;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {
    private List<Product> products;
    private int first;
    private int last;
    private  double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (last - first < 10) {
            updatePrice();
        } else {
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks: %s\n", getQueuedTaskCount());
            Task task1 = new Task(products, first, middle+1, increment);
            Task task2 = new Task(products, middle+1, last, increment);
            invokeAll(task1, task2);
        }
    }

    private void updatePrice() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() * (1 + increment));
        }
    }
}
