# Synchronizing Tasks in a Common Point - `CyclicBarrier`

The `CyclicBarrier` class allows the synchronization of two or more threads 
at a determined point. It is similar to the `CountDownLatch` class, but 
presents some powerful features.

It is initialized with an integer which is the number of threads that will 
be synchronized at a determined point. When one of the threads arrives at 
the determined point, it calls the `await()` method on the `CyclicBarrier` 
object to wait for the other threads. When the thread calls this method, 
`CyclicBarrier` blocks the thread that is sleeping until the other threads 
arrive. When the last thread calls the `await()`, it wakes up all the 
threads that were waiting and continues with its job.

`CyclicBarrier` can take an additional `Runnable` object as an 
initialization parameter. This object will be executed as a thread when all 
the threads arrive at the common point. This characteristic makes 
`CyclicBarrier` adequate for parallelization of tasks using the divide and 
conquer technique.

`CyclicBarrier` has a `reset()` method. When it is called, all the threads 
that were waiting receives a `BrokenBarrierException`. When catching this 
exception, the developer can decide how to handle it, such as restarting the 
execution or recovering the operation at the point it was interrupted.

When there are various threads waiting and one of them is interrupted, the 
interrupted one receives an `InterruptedException`, others receive a 
`BrokenBarrierException`, and the `CyclicBarrier` object is placed in the 
broken state. The `isBroken` method returns if the object is in the broken 
state.