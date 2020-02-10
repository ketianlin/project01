package demo;

import org.junit.Test;

public class TestTicket {
    @Test
    public void test01(){
        MyTicket myTicket = new MyTicket();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                myTicket.sale();
            },"消费者线程：" + i).start();
        }
    }

    @Test
    public void test02(){
        MyTicketForLock myTicketForLock = new MyTicketForLock();
        for (int i = 0; i < MyTicketForLock.getNum(); i++) {
            new Thread(()->{
                myTicketForLock.sale();
            }, "消费者lock读写锁线程：" + i).start();
        }
    }
}
