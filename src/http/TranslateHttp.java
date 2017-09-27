package http;

import moudle.TranslateBean;
import util.HttpManager;
import util.JsonUtil;
import util.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TranslateHttp {

    ExecutorService executors = Executors.newFixedThreadPool(5);

    /**
     * 调用翻译，并且解析翻译结果
     *
     * @param query
     */
    public void translate(String query, CallBack callBack) {
        executors.execute(new Runnable() {
            @Override
            public void run() {
                //调用有道API
                String result = request(query);

                Logger.info("request result:" + result);

                //Json 解析
                TranslateBean translateBean = JsonUtil.fromJson(result, TranslateBean.class);

                callBack.callback(translateBean);
            }
        });
    }

    /**
     * 发起翻译请求，并且返回翻译结果
     *
     * @param query
     * @return
     */
    private String request(String query) {
        String appKey = "08e46a6bb8402dd9";
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "EN";
        String to = "zh-CHS";
        String sign = md5(appKey + query + salt + "70GVWg2u8KNjF7aRUvz1pw7gI8r5qPR1");
        Map params = new HashMap();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("sign", sign);
        params.put("salt", salt);
        params.put("appKey", appKey);

        String result = null;

        try {
            result = HttpManager.getInstance().post("https://openapi.youdao.com/api", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 生成32位MD5摘要
     *
     * @param string
     * @return
     */
    private String md5(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = string.getBytes("utf-8");
            /** 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /** 获得密文 */
            byte[] md = mdInst.digest();
            /** 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }


    public interface CallBack {
        void callback(TranslateBean translateBean);
    }


}
