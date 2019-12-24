package top.ke1205.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HelloWorld {

    private static final int INIT_SIZE = 10;
    public static void main(String[] args) {
        System.out.println("helloworld");
        System.out.println("helloworld");
        Date date = new Date();
        /*System.out.println("helloworld");
        System.out.println("helloworld233");*/


        System.out.println("helloworld");
        System.out.println("helloworld");
        System.out.println("helloworld");


        List<String> list = new ArrayList<>();
        if (list != null) {
            
        }
        list.add(0,"ddd");
    }



    public void method01(){
        try {
            FileInputStream fileInputStream = new FileInputStream("a.log");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void method02(){
        
    }


}
