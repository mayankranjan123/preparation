package threading;

import java.util.concurrent.ArrayBlockingQueue;

class ProducerBlock implements Runnable {
    java.util.concurrent.BlockingQueue<Integer> queue;

    public ProducerBlock(java.util.concurrent.BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Produced: " + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ConsumerBlock implements Runnable {

    java.util.concurrent.BlockingQueue<Integer> queue;

    public ConsumerBlock(java.util.concurrent.BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Integer item = null;
            try {
                item = queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumed: " + item);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class BlockingQueue {
    public static void main(String[] args) {
        java.util.concurrent.BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
        Thread producer = new Thread(new ProducerBlock(queue));
        Thread consumer = new Thread(new ConsumerBlock(queue));

        producer.start();
        consumer.start();
    }
}
