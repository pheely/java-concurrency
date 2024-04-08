# Creating a Fork/Join Pool

To use the basic elements of the fork/join framework,
- create a `ForkJoinPool`
- create a `ForkJoinTask` to be executed in the pool
- execute the tasks in a synchronized way. When a task executes two or more
subtasks, it waits for their finalization.

We can use the default constructor to create a `ForkJoinPoll`. The pool will 
have a number of threads equal to the number of processors of the computer. 
These threads are created when the `ForkJoinPool` is created and wait in the 
pool until some tasks arrive for their execution.

The `RecursiveAction` class is a subclass of the `ForkJoinTask` class. This kind 
of task does not return a result. To execute the subtasks that a task creates, it 
calls the `invokeAll()` method. This is a synchronous call and the task waits for
the finalization of the subtasks before continuing its execution. While the task 
is waiting for its subtasks, the worker thread that was executing it takes another
task waiting for execution and executes it. 

We can also ask the `ForkJoinPool` to execute a task by calling the `execute()` 
method. This will be an asynchronous call.

The `ForkJoinPool` can be used to execute a `Runnable` task as well by calling the
`execute(Runnable)` method. In this case, the work-stealing algorithm is not used.

The `ForkJoinPool` class has some methods to check the status and the evolution of
the tasks that are running.