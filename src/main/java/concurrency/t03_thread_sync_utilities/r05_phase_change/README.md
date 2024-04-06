# Controlling Phase Change in Concurrent-Phased Tasks

The `Phaser` class provides a method - `onAdvance()` that is executed each time 
it changes the phase. It returns `false` if `Phaser` continues its execution 
or `true` if `Phaser` has finished and has to enter the termination state.

By default, this method returns `true` if the number of registered 
participants is zero, and `false` otherwise. We can modify this behavior by 
extending the `Phaser` class and override this method. This will enable us 
to execute some actions when advancing from one phase to the next.

This method is called by `Phaser` before making a phase change and waking up all
the threads that were sleeping in the `arriveAndAwaitAdvance()` method. This 
method is triggered by the last thread that finishes a phase as part of the code
of the `arriveAndAwaitAdvance()` method. It receives two parameters: the 
number of the actual phase, and the number of registered participants. We can
make decisions based on the actual phase number. The return value of this method
controls the next action of the `Phaser`. If it is false, it indicates that the
phase has not terminated yet, the threads will be woken up and continue with 
the execution of other phases. If it is true, the `phaser` still wakes up 
the threads and move to the terminated state. With this, all future calls to 
any `phaser` method will return immediately, and the `isTerminated()` will 
return true.