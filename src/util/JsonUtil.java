package util;

import com.google.gson.Gson;

public class JsonUtil {

    static Gson gson = new Gson() ;

    /**
     * json字符串转对象
     * @param json
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T>T fromJson(String json, Class<T> classOfT){
        return gson.fromJson(json,classOfT);
    }

    /**
     * 对象转json字符串
     * @param src
     * @return
     */
    public static String toJson(Object src){
       return gson.toJson(src);
    }

}
