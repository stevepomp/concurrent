package chapter01;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {

    public static void main(String[] args) {
//        browserNews();
        //通过匿名内部类的方式创建线程，并重写run方法
        Thread thread = new Thread(TryConcurrency::browserNews);//调用start方法才会开启线程，否则只是new一个新对象
        thread.start();
        enjoyMusic();
    }

    private static void browserNews(){
        for (int i = 0; i < 100; i++) {
            System.out.println("news");
            sleep(1);
        }
    }

    private static void enjoyMusic(){
        for (int i = 0; i < 100; i++) {
            System.out.println("music");
            sleep(1);
        }
    }

    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
