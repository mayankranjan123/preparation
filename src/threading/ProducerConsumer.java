package threading;

import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable {
    private final ProducerConsumer producerConsumer;

    public Producer(ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                producerConsumer.produce(i);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {

    private final ProducerConsumer producerConsumer;

    public Consumer(ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                producerConsumer.consume();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ProducerConsumer {
    private final int capacity;

    private final Queue<Integer> queue;

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer(2);

        Thread producer = new Thread(new Producer(producerConsumer));
        Thread consumer = new Thread(new Consumer(producerConsumer));

        producer.start();
        consumer.start();
    }

    public synchronized void consume() throws InterruptedException {
        if (queue.isEmpty()) {
            wait();
        }

        Integer item = queue.poll();
        System.out.println("Consumed: " + item);

        notifyAll();
    }

    public synchronized void produce(int item) throws InterruptedException {
        if (queue.size() == capacity) {
            wait();
        }

        queue.add(item);
        System.out.println("Produced: " + item);

        notifyAll();
    }
}
