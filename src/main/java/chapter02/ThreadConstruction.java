package chapter02;

public class ThreadConstruction {

    public static void main(String[] args) {
        Thread thread1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("testGroup");
        Thread thread2 = new Thread(group, "t2");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(thread1.getThreadGroup());
        System.out.println(thread2.getThreadGroup());
        System.out.println(mainGroup);
    }
}
