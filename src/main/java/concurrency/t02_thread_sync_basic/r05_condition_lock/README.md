# Multiple Conditions in a Lock

A lock can be associated with one or more conditions that are of `Condition` 
interface.

Conditions allow threads to have control of a lock and check whether a 
condition is `true` or `false`. If it is `false`, the thread will be 
suspended until another thread wakes it up.

The classic producer-consumer problem can also be implemented using locks 
and conditions.

All the `Condition` objects are associated with a lock and are created using 
the `newCondition()` method:

```java
Lock aLock = new ReentrantLock();
Condition aCond = aLock.newCondition();
```

Before using a `Condition` object, we must have control of the lock 
associated with the condition. That means it can only be used by a thread 
that holds the lock with a `lock()` call and then frees it with an `unlock()`.

When a thread calls the `await()` on a condition, it will free the control 
of the lock and be suspended until another thread that calls the `signal()` 
on the same condition wakes it up. When the thread frees the control of the 
lock, another thread can get the lock.

When a thread calls the `signal()` or `signalAll()` on a condition, one or 
all of the threads that were waiting for that condition are waken up, but 
that does not guarantee that the condition that made them sleep is now true. 
So we must put the `await()` calls inside a `while` loop.

Be careful when using `await()` and `signal()`. Never call them on the same 
condition in the same thread. Otherwise, the thread will sleep forever.