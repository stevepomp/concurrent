package chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadIsInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (true) {
                //loop
            }
        });
        thread1.setDaemon(true);
        thread1.start();

        TimeUnit.MILLISECONDS.sleep(10);
        System.out.printf("thread1 is interrupted? %s\n", thread1.isInterrupted());
        thread1.interrupt();
        System.out.printf("thread1 is interrupted? %s\n", thread1.isInterrupted());

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.printf("I am be interrupted? %s\n", isInterrupted());
                    }
                }
            }
        };
        thread2.setDaemon(true);
        thread2.start();

        TimeUnit.MILLISECONDS.sleep(10);
        System.out.printf("thread2 is interrupted? %s\n", thread2.isInterrupted());
        thread2.interrupt();
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.printf("thread2 is interrupted? %s\n", thread2.isInterrupted());
    }
}