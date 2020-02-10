package demo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Double> {
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double jisuan() throws Exception{
        Double cb = 0d;
        if (productName.equals("人工")){
            Thread.sleep(2000);
            System.out.println("正在计算人工成本");//调用资源类
            cb = 13d;
        }else if (productName.equals("材料")){
            Thread.sleep(3000);
            System.out.println("正在计算材料成本");//调用资源类
            cb = 12d;
        }
        return cb;
    }

    @Override
    public Double call() throws Exception {
        return this.jisuan();
    }
}
