package top.ke1205.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
    /**
     * 将Json字符串信息转换成对应的Java对象
     * @param json  json字符串对象
     * @param c     对应的类型
     * @param <T>
     * @return
     */
    public static <T> T parseJsonToObj(String json, Class<T> c){
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            return JSON.toJavaObject(jsonObject, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
