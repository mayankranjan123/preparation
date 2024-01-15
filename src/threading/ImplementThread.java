package threading;

public class ImplementThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing: " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ImplementThread());
        Thread t2 = new Thread(new ImplementThread());

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
