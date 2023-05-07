import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        FizzBuzz fizzBuzz = new FizzBuzz();
        service.submit(fizzBuzz::fizz);
        service.submit(fizzBuzz::buzz);
        service.submit(fizzBuzz::fizzbuzz);
        service.submit(fizzBuzz::number);
        service.submit(() -> output(fizzBuzz));
        Thread.sleep(2000);
        service.shutdown();

    }

    public static void output(FizzBuzz fizzBuzz) {
        while (true) {
            if (fizzBuzz.queue.isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            while (!fizzBuzz.queue.isEmpty()) {
                System.out.println(fizzBuzz.queue.poll());
            }
        }
    }
}

