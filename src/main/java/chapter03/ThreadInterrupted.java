package chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupted {
//    ClearInterrupted == true, 擦除interrupt标识
//    public static boolean interrupted() {
//        return currentThread().isInterrupted(true);
//    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i <= 1_000) {
                i++;
                System.out.println(Thread.interrupted());
            }
        });
//        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
