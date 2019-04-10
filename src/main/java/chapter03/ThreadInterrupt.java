package chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("I am be interrupted.");
            }
        });
        thread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
