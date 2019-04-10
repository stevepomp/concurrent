package chapter03;

public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(() -> {
            Long startTime = System.currentTimeMillis();
            sleep(2_000L);
            Long endTime = System.currentTimeMillis();
            System.out.println(String.format("Total spend %d ms", endTime - startTime));
        }).start();

        Long startTime = System.currentTimeMillis();
        sleep(3_000L);
        Long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread total spend %d ms", endTime - startTime));
    }

    private static void sleep(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
