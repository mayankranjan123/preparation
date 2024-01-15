package threading;

public class BasicThread extends Thread {

    @Override
    public void run() {
        System.out.println("Executing: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        BasicThread basicThread = new BasicThread();
        basicThread.run();
    }
}
