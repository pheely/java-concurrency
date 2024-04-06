# Running Multiple Tasks and Processing the First Result

There are various concurrent tasks available to solve a problem, but we are 
only interested in the first result (the fastest).

This can be achieved by calling the `invokeAny()` method on the 
`ExecutorService` interface. It receives a list of `Callable`s and returns 
the result of the first finished task. The type of the result is the same as 
that the `call()` method.