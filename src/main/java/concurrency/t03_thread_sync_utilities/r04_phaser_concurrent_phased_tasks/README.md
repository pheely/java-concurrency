# Running Concurrent-Phased Tasks - `Phaser`

When we have some concurrent tasks divided into steps, and we don't want to 
continue with the second step until all the threads have finished the first 
one, we can use the `Phaser` class. The `Phaser` class provides a mechanism 
to synchronize threads at the end of each step.

The `Phaser` is instantiated with the number of tasks that participate in 
the synchronization operation, which can be dynamically modified.

Every thread starts with a call to the `arriveAndAwaitAdvance()` method of the `Phaser` object. Upon being called, 
`Phaser` decreases the number of threads that have to finalize the actual phase and puts this thread to sleep until all 
remaining threads finish this phase. Calling this method at the beginning of the `run()` method ensures that none of 
the threads begin their job until all the threads are created.

At the end of each phase, each thread will call the `arriveAndAwaitAdvance()` method again. If for any reason, a thread
cannot participate the rest of phases, it can call the `arriveAndDeregister()` method of the `Phaser` object to notify
the `phaser` which will not have to wait for it to continue.

At the end of the task, all remaining threads will call the `arriveAndDeregister()` method of `Phaser`. This will 
deregister the threads of `phaser`. When all the threads finish, `phaser` will have zero participants.

A `Phaser` object can be in two states:
- **Active**: `Phaser` enters this state when it accepts the registration of new participants and the synchronization at
the end of each phase. 
- **Termination**: By default, `Phaser` enters this state when all the participants have been deregistered. `Phaser` is 
in this state when the method `onAdvance()` returns `true`. When `Phaser` is in this state, the synchronization method 
`arriveAndAwaitAdvance()` returns immediately without doing any synchronization operation. Also, the method `isTerminated()`
returns `true`. A `Phaser` can also enter the termination state when the `forceTermination()` method is called regardless 
of the number of participants registered. This method is useful when one of the participants has an error situation, where 
the best thing to do would be to terminate the `Phaser`.

The `Phaser` class has two additional methods to increment the number of participants: `register()` and 
`bulkRegister(int Parties)`. The new participant(s) registered in such way will be considered unarrived to the actual phase.

Other than the `arriveAndAwaitAdance()`, the `Phaser` class provide three more methods related to phase change:
- `arrive()` notifies the `Phaser` that one participant has finished the actual phase, but it should not wait for the rest
of the participants to continue with their execution.
- `awaitAdance(int phase)` puts current thread to sleep until all participants have finished the current phase, if the 
parameter is equal to the actual phase. If the parameter is not equal to the actual phase, the methods ends its execution.
- `awaitAdvanceInterruptibly(int phase)` is similar to the previous method, but throws an `InterruptedException` if the 
thread that is sleeping in this method is interrupted.
