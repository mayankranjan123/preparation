package threading;

class Worker implements Runnable {

    private final java.util.concurrent.Semaphore semaphore;

    public Worker(java.util.concurrent.Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquireUninterruptibly();
            System.out.println("Worker Thread: " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}

public class Semaphore {
    public static void main(String[] args) {
        java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(2);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Worker(semaphore));
            thread.start();
        }
    }
}
