import java.util.LinkedList;

/** A bounded-buffer producer and consumer using intrinsic monitor coordination. */
public class ProducerConsumer {
    static class PC {
        private final LinkedList<Integer> buffer = new LinkedList<>();
        private final int capacity = 2;

        void produce() throws InterruptedException {
            int value = 0;
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    while (buffer.size() == capacity) wait();
                    buffer.add(value);
                    System.out.println("Producer produced-" + value++);
                    notifyAll();
                }
                Thread.sleep(1000);
            }
        }

        void consume() throws InterruptedException {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    while (buffer.isEmpty()) wait();
                    int value = buffer.removeFirst();
                    System.out.println("Consumer consumed-" + value);
                    notifyAll();
                }
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PC pc = new PC();
        Thread producer = new Thread(() -> {
            try { pc.produce(); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }, "producer");
        Thread consumer = new Thread(() -> {
            try { pc.consume(); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }, "consumer");
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
