# Separating the Launching of Tasks and the Processing of Their Results in an Executor

If we want to send tasks to the executor in one object and process the results in
another one, we can choose to use the `CompletionService` class.

The `CompletionService` class has a method `submit()` to send tasks to an executor, and
a method `poll()` to get the `Future` object for the next task that has finished its 
execution.