# Read/write Locks

`ReadWriteLock` interface provides two locks: one for read and one for write.
There can be more than one read thread performing read operations 
simultaneously, but only one thread for write operation. If a thread is 
performing a write operation, other threads can't write or read.

`ReentrantReadWriteLock` class implements this interface.