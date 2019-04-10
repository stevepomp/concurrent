package chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private static final int MAX = 50;

    @Override
    public void run() {

        while (index <= MAX) {
            System.out.println(Thread.currentThread() + "的号码是：" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();
        List<String> list = new ArrayList<>(Arrays.asList("一号","二号","三号"));
        list.stream().map(i -> new Thread(task, i)).forEach(Thread::start);
    }
}
