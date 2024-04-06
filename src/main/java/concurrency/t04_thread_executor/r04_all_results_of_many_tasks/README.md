# Running Multiple Tasks and Processing All the Results

Use the following two methods to wait for the finalization of a task:
1. Call the `isDone()` method on the `Future` interface
2. Call the `shutdown()` and then the `awaitTermination()` method on the 
   `ThreadPoolExecutor`. This will out the calling thread to sleep until all 
   the tasks have completed.

The `ThreadPoolExecutor` class also provides the `invokeAll()` method that 
allows us to send a list of tasks and wait for the finalization of all the 
tasks. This method returns a list of `Future` object with the same order of the 
tasks order. The data type used for the parameterization of the `Future` 
interface must be compatible with the one used to parameterize `Callable` 
objects.