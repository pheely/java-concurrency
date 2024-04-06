# Controlling a Task Finishing in an Executor

The `FutureTask` class encapsulates a cancelable asynchronous computation. It implements 
the `Runnable` and `Future` interfaces and provides the basic implementation of the
`Future` interface. 

We can create a `FutureTask` using a `Callable` or `Runnable` object. The following methods
are useful:
- `cancel()` to cancel the execution 
- `get()` to obtain the result
- `done()` to execute some code after the finalization of the task. It is called after the result
of the task is set and the status is changed to `isDone`. The default implementation is empty. It 
can be overridden