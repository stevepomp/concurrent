package chapter01;

public class TicketWindow extends Thread {
    //柜台名称
    private final String name;

    //最多受理50笔业务
    private static final int MAX = 50;

    private int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + "当前号码是" + (index++));
        }
    }

    public static void main(String[] args) {
        new TicketWindow("一号").start();
        new TicketWindow("二号").start();
        new TicketWindow("三号").start();
    }
}
