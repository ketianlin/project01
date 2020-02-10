package demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTicketForLock {
    public static Integer num = 10;
    Lock lock = new ReentrantLock();
    public static Integer getNum() {
        return num;
    }

    public static void setNum(Integer num) {
        MyTicketForLock.num = num;
    }

    public void sale(){
        System.out.println(Thread.currentThread().getName() + "手动上锁");
        try {
            lock.lock();
            num--;
            System.out.println(Thread.currentThread().getName() + "买了一张票，剩余：" + num);
        } finally {
            System.out.println(Thread.currentThread().getName() + "，手动解锁");
            lock.unlock();
        }
    }
}
