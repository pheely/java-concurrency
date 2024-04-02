# How to handle unchecked exceptions in a thread

- Checked exceptions must be handled inside the `run()` method. You can't rethrow them as `run()` does not accept `throws`.
- The default behavior for unchecked exceptions is to write the stacktrace in the console and exit the program.
- It's possible to catch and handle unchecked exceptions to avoid ending the program

Here is how.

1. Instantiate a class that implements the `UncaughtExceptionHandler` interface. Override the `uncaughtException()` method.
2. For the thread that could throw an uncaught exception, install the exception handler created in step 1.
