# Running Concurrent-Phased Tasks - `Phaser`

When we have some concurrent tasks divided into steps, and we don't want to 
continue with the second step until all the threads have finished the first 
one, we can use the `Phaser` class. The `Phaser` class provides a mechanism 
to synchronize threads at the end of each step.

The `Phaser` is instantiated with the number of tasks that participate in 
the synchronization operation, which can be dynamically modified.


