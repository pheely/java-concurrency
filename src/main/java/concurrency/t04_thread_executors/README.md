# Executor Framework

## Issues related to creating and managing threads

How to create and execute concurrent applications:
- Create `Runnable` objects
- Create `Thread`s using these `Runnable`s 
- Call the `start` method of the `Thread`s

Disadvantages:
- We need to implement all the code that is required to manage Thread objects 
(creating, ending, and obtaining results).
- We need to create a `Thread` object per task. Executing a huge number of 
tasks can affect the throughput of the application. 
- We need to control and manage the resources of the computer efficiently. 
If too many threads are created, the system will be saturated.

## Executor 

The `Executor` interface extends the `ExecutorService` interface. The 
`ThreadPoolExecutor` class implements both interfaces. 

With an executor, developers only need to create either `Runnable` or 
`Callable` objects and pass them to the executor. The executor is 
responsible for their execution, running them with necessary threads. It 
utilizes a thread pool to reduce the overhead of creating threads. 

The `Callable` interface is similar to the `Runnable` interface but offers 
two features:
1. It has a method `call()` that may return a result, which the `run()` in the 
   `Runnable` can't provide.
2. When the executor receives a `Callable` object, it will return an object 
   that implements the `Future` interface. This object can be used to 
   control the status and the result of the `Callable` object.

