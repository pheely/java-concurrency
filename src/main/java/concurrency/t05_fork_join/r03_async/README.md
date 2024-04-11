# Running Jobs Asynchronously

`ForkJoinTask`s can be executed in `ForkJoinPool` synchronously or asynchronously.

Methods like `invokeAll()` send tasks to the pool are suspended until all the tasks finish their execution.
The `ForkJoinPool` can use the work-stealing algorithm to assign a new task to the worker thread that 
executed the sleeping task.

When we use the asynchronous methods like `fork()`, the method that sends the task to the executor returns
immediately, and the task continues with its execution. The `ForkJoinPool` cannot use the work-stealing 
algorithm to increase the performance of the application.

`CountedCompleter` class is another `ForkJoinTask`. With this kind of tasks, we can include a completion action 
that will be executed when it is launched and there is no pending child task. This mechanism is based on a 
method included in the class (the `onCompletion()` method) and a counter of pending tasks.

This counter is initialized to zero by default and we can increment it when we need in an atomic way. 
Normally, we increment this counter one by one when we launch a child task. Finally, when a task has finished 
its execution, we can try to complete the execution of the task and consequently execute the `onCompletion()` 
method. If the pending count is greater than zero, it is decremented by one. If it's zero, the `onCompletion()` 
method is executed and then the parent task is tried to be completed.
