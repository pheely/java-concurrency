# Running a Task Periodically in an Executor

The `ScheduledThreadPoolExecutor` class can be used to execute periodic tasks. 
To send the task to the executor, call the `scheduledAtFixedRate()` method. 

This method accepts four parameters:
1. The task to be executed periodically.
2. The delay of time until the first execution
3. The period between two executions
4. The time unit of the second and third parameters

The method returns a `ScheduledFuture` object, which extends the `Future` interface.
`ScheduledFuture` is a parameterized interface. If the task is a `Runnable` rather 
than a `Callable`, we have to parameterize `ScheduledFuture` with the `?` symbol as
a parameter.

The `getDelay()` method of the `ScheduledFuture` returns the time until the next execution
of the tasks.
