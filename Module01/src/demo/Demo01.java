package demo;

import java.lang.reflect.Method;

public class Demo01 {
    public static void main(String[] args) {
        String action = "regist";
        try {
            Method declaredMethod = Demo01.class.getDeclaredMethod(action);
            declaredMethod.invoke(new Demo01());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login(){
        System.out.println("现在是登录的方法");
    }

    public void regist(){
        System.out.println("现在是注册的方法");
    }

    public void updatePasswor(){
        System.out.println("现在是修改用户密码的方法");
    }
}
