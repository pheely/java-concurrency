# Fork/Join Framework

The fork/join framework is designed to solve problems that can be broken into
smaller tasks using the divide and conquer technique. Inside a task, we check
the size of the problem and if it is bigger than the established size, we divide
it into smaller tasks that are executed using the framework. If the size of the
problem is smaller than the established size, we solve the problem directly in 
the task.

