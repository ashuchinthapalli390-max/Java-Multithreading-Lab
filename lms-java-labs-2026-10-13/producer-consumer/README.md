# Producer–Consumer problem

```bash
javac ProducerConsumer.java
java ProducerConsumer
```

Runs indefinitely. Stop with Ctrl+C. The LinkedList buffer capacity is 2.
Both threads check conditions in while loops under the same monitor.
wait releases the monitor; notifyAll wakes waiting threads. Sleep occurs outside
the synchronized block, allowing the other thread to use the buffer.

The included outputs/execution.txt is an actual short local run terminated after capture.
