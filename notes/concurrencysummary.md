Concurrency
===========

#### How should program functionality be decomposed?

**Threads** are the programming abstraction that allow programmers to implement concurrent software.

Programmatically, there are two ways to use threads in a program. The option we have discussed is to provide a class that implements the `Runnable` interface and provides a `run` method. Multiple instances of the `Runnable` class may be provided to individual threads, or to a thread pool, and the `run` methods will execute concurrently.

A thread scheduler determines which thread runs at any given time. The programmer may not make any assumptions about the order in which threads are scheduled. The statements inside the `run` method executed by a thread will interleave in unpredictable ways.

If a program performs the same task many times for different inputs it may be advantageous to create a new *job* for each input and use multiple threads to execute the jobs. A web crawler, for example, downloads and parses several web pages. It would be wise to split the job among multiple threads where each is responsible for downloading and parsing a single web page. The same is true for a program that processes several input files. 

#### Synchronization and Locks

It is often the case that concurrently executing threads access the same variables or data structures. Even a statement as simple as `a++` is not **atomic**. An increment operation is decomposed into multiple machine language instructions and those instructions may be interleaved unless the programmer takes care to ensure data is accessed safely.

A **thread-safe** data structure allows multiple threads to access data without any thread ever seeing the data in an inconsistent state. Further, the data structure must encapsulate any required synchronization (see: [Java Concurrency in Practice](http://jcip.net/)).

The keyword `synchronized` may be applied to methods or to a block. In a class, `synchronized` methods may not interleave. Similarly, two blocks synchronized on the same object may not interleave. This can effectively serialize access to shared data.

It is the case, however, that while two write operations conflict and may not interleave, and a read and write operation also conflict, two read operations do not conflict. 

**Locks** may be used to provided finer-grained lock control and can also allow two read operations to happen concurrently. 

Prior to reading data, a read lock is acquired. Prior to writing data, a write lock is acquired. Two read locks may be held simultaneously, however if a write lock is held then no other lock may be held by another thread.

A **reentrant** lock is one that allows a writer to also acquire a read lock. If the writer gives up the write lock it may still hold the read lock. 

