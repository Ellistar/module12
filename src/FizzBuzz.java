import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz {
    private final int n = 51;
    public static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    public static volatile AtomicInteger number = new AtomicInteger(1);

    public synchronized void number() {
        while (number.get() < n) {
            if (number.get() % 3 != 0 && number.get() % 5 != 0) {
                queue.add(String.valueOf(number));
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizz() {
        while (number.get() < n) {
            if (number.get() % 3 == 0 && number.get() % 5 != 0) {
                queue.add("fizz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz() {
        while (number.get() < n) {
            if (number.get() % 3 != 0 && number.get() % 5 == 0) {
                queue.add("buzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (number.get() < n) {
            if (number.get() % 3 == 0 && number.get() % 5 == 0) {
                queue.add("fizzbuzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
