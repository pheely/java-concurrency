# Creating a Thread Executor and Controlling Its Rejected Tasks

##  Creating a `ThreadPoolExecutor`

Two ways to create an `ThreadPoolExecutor`:
1. Four `ThreadPoolExecutor` constructors
2. Use the `Executors` factory class

## Shutting Down a `ThreadPoolExecutor`

To shut it down, call the `shutdown()` method on the `ThreadPoolExecutor`. 
It will wait for the completion of all tasks that are either running or 
waiting, then it finishes the execution.

If a task is sent to an executor that is already been shut down but still 
waiting to finish it execution, it will be rejected. The 
`ThreadPoolExecutor` has a mechanism to handle rejected tasks.