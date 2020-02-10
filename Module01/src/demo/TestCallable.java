package demo;

import org.junit.Test;

import java.util.concurrent.FutureTask;

public class TestCallable {
    @Test
    public void test01() throws Exception{
        // 工程成本核算问题
        System.out.println("开始核算工程成本");

        MyCallable myCallable1 = new MyCallable();
        myCallable1.setProductName("人工");
        FutureTask<Double> futureTask1 = new FutureTask<>(myCallable1);
        new Thread(futureTask1).start();

        MyCallable myCallable2 = new MyCallable();
        myCallable2.setProductName("材料");
        FutureTask<Double> futureTask2 = new FutureTask<>(myCallable2);
        new Thread(futureTask2).start();

        MyCallable myCallable3 = new MyCallable();
        myCallable3.setProductName("材料");
        FutureTask<Double> futureTask3 = new FutureTask<>(myCallable3);
        new Thread(futureTask3).start();

        MyCallable myCallable4 = new MyCallable();
        myCallable4.setProductName("材料");
        FutureTask<Double> futureTask4 = new FutureTask<>(myCallable4);
        new Thread(futureTask4).start();

        Double rengong = futureTask1.get();
        Double cailiao = futureTask2.get();
        System.out.println("人工：\t" + rengong);
        System.out.println("材料：\t" + cailiao);
        System.out.println("总成本：\t" + (cailiao + rengong));
    }
}
