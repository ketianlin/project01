package top.ke1205.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Utils {
    public static <T> T copyParamToBean(Map map, T bean){
        try {
            System.out.println("注入之前：" + bean.toString());

            BeanUtils.populate(bean, map);

            System.out.println("注入之后：" + bean.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Integer parseInt(String strInt, Integer defaultValeu){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {

        }
        return defaultValeu;
    }
}
