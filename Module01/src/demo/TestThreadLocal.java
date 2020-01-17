package demo;

import java.util.Random;

public class TestThreadLocal {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }

    static Random random = new Random();
    static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    static class Task implements Runnable{

        @Override
        public void run() {
            Integer num = random.nextInt(100);
            String name = Thread.currentThread().getName();
            threadLocal.set(num);
            System.out.println("线程【" + name + "】 生成的随机数是：" + num);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = threadLocal.get();
            System.out.println("线程【" + name + "】 生成的随机数是：" + result);
        }
    }
}
