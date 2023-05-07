import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Task1 test = new Task1();
        test.methodMain();

    }
    public void methodMain() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println("5 second marker"),
                5,
                5,
                TimeUnit.SECONDS
        );
        scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println("Current time is " + System.currentTimeMillis()),
                0,
                1,
                TimeUnit.SECONDS
        );
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();
        System.out.println("Shutdown");
        }
    }

