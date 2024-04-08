# Joining the Results of the Tasks

The `RecursiveTask` returns a result. It extends the `ForkJoinTask` and implements
the `Future` interface.

If the task has to resolve a problem bigger than a predefined size, we divide the
problem into more subtasks and execute these subtasks using the fork/join framework.
When they finish their execution, the initiating task obtains the results generated
by all subtasks, groups them, and returns the final result/