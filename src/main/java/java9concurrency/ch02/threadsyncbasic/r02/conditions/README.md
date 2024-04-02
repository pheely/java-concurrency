# Using conditions in synchronized code

## Producer-consumer problem

There are one or more data producers and one or more data consumers. They all share the same data buffer. The producers save the data in it while the consumers take the data from it.

A producer cannot save data when the buffer is full, and a consumer cannot take data when the buffer is empty.

We can implement the producer-consumer program using the `synchronized` keyword and the `wait()`, `notify()`, and notifyAll()` methods in the `Object` class.
