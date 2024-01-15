package threading;

import java.util.Random;
import java.util.concurrent.*;

public class CallableExample implements Callable<Integer> {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = service.submit(new CallableExample());
            System.out.println(future.get(10, TimeUnit.SECONDS));
        }
    }

    @Override
    public Integer call() throws Exception {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        System.out.println("Executing: " + Thread.currentThread().getName());
        Thread.sleep(2000);
        return new Random().nextInt();

    }
}
