package chapter03;

public class ThreadPriority {

    private static int t1 = 0;
    private static int t2 = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (t1 < 10000) {
                t1++;
                System.out.println("t1:" + t1);
            }
        });
        thread1.setPriority(1);

        Thread thread2 = new Thread(() -> {
            while (t2 < 10000) {
                t2++;
                System.out.println("t2:" + t2);
            }
        });
        thread2.setPriority(10);

        thread1.start();
        thread2.start();
        System.out.println(thread2.getId());
    }
//    线程优先级介于1-10,子线程默认与父线程优先级相同,main线程优先级为5; 子线程优先级不大于ThreadGroup;
//    public final static int MIN_PRIORITY = 1;
//    public final static int NORM_PRIORITY = 5;
//    public final static int MAX_PRIORITY = 10;
//    public final void setPriority(int newPriority) {
//        ThreadGroup g;
//        checkAccess();
//        if (newPriority > MAX_PRIORITY || newPriority < MIN_PRIORITY) {
//            throw new IllegalArgumentException();
//        }
//        if((g = getThreadGroup()) != null) {
//            if (newPriority > g.getMaxPriority()) {
//                newPriority = g.getMaxPriority();
//            }
//            setPriority0(priority = newPriority);
//        }
//    }
}
