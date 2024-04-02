# Waiting for another thread

## Use case

Run initialization tasks as threads, and wait for them before continuing the rest of the program.

## Implementation

Use `join()` method of the `Thread` class. The thread that calls the `join()` is suspended until the thread that is called completes.
