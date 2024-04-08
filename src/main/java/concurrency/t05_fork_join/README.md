# Fork/Join Framework

## Intro

The fork/join framework is designed to solve problems that can be broken into
smaller tasks using the divide and conquer technique. Inside a task, we check
the size of the problem and if it is bigger than the established size, we divide
it into smaller tasks that are executed using the framework. If the size of the
problem is smaller than the established size, we solve the problem directly in 
the task.

There are two operations:
- **Fork**: to divide a task into smaller tasks and execute them using the framework
- **Join**: to combine the results of small tasks

## Work-stealing algorithm

The fork/join framework uses the work-stealing algorithm. When a task is waiting for the 
finalization of subtasks that it has created using the join operation, the thread that is
executing that task (called **working thread**) looks for other tasks that have not 
been executed yet and begin their execution.

## Limitations

Tasks can only use the `fork()` and `join()` operations as synchronization mechanisms. Otherwise,
the worker thread can't execute other tasks when they are in the synchronization operation. 
For example, if a task is put to sleep in the fork/join framework, the worker thread that is
executing that task won't execute another one during the sleeping time.

Tasks should not perform I/O operations.

Tasks can't throw checked exceptions. They have to include the code to handle them.

## Core Classes

- `ForkJoinPool` class implements the `ExecutorService` interface and the work-stealing algorithm. 
It manages the worker threads and offers information about the status of the tasks and their 
execution.
- `ForkJoinTask` is the base class of the tasks that will execute in the `ForkJoinPool`. It provides
the mechanism to execute the `fork()` and `join()` operations inside a task and methods to control
the status of the tasks. Usually, to implement the fork/join tasks, we will create a subclass of three 
subclasses of `ForkJoinTask`: `RecursiveAction`, `RecursiveTask`, and `CountedCompleter`.