package demo;

public class MyTicket {
    public static Integer num = 10;

    public static Integer getNum() {
        return num;
    }

    public static void setNum(Integer num) {
        MyTicket.num = num;
    }

    public synchronized void sale(){
        num--;
        System.out.println(Thread.currentThread().getName() + "买了一张票，剩余票数：" + num);
    }

}
