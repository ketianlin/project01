package demo;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class TestThread {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
    static Random random = new Random();
    static Map<String, Object> map = new Hashtable<>();
    static class Task implements Runnable{

        @Override
        public void run() {
            // 随机生成一个数字
            Integer num = random.nextInt(100);
            String name = Thread.currentThread().getName();
            map.put(name, num);
            System.out.println("线程【" + name + "】 生成的随机数是：" + num);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(name);
            System.out.println("线程【" + name + "】 生成的随机数是：" + result);
        }
    }
}
