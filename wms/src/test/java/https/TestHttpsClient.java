package https;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import util.https.HttpsUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/1/12
 * Time: 17:20
 */
public class TestHttpsClient {

    private String url = "https://2sc.sohu.com/";
    private String charset = "utf-8";
    private String sysId = "106605";

    /**
     * 测试为知笔记的https的json登陆
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws KeyManagementException
     */
    @Test
    public void testHttpsPost() throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("accept", "*/*");
        headerMap.put("connection", "Keep-Alive");
        headerMap.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        headerMap.put("content-type", "application/json; charset=utf-8");
        headerMap.put("Accept","*/*");
        Map<String, String> params = new HashMap<String, String>();
        url = "https://note.wiz.cn/as/user/login?clientType=web&clientVersion=3.0.0&apiVersion=10&lang=zh-cn";
        params.put("userId", "");
        params.put("password", "");

        String data = JSON.toJSONString(params);
        String result = HttpsUtils.doHttpsPost(url,data,headerMap);
        System.out.println(result);


    }

    /**
     * 测试北邮人https的form登陆
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws KeyManagementException
     */
    @Test
    public void testHttpsPostV2() throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("accept", "*/*");
        headerMap.put("connection", "Keep-Alive");
        headerMap.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        headerMap.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        headerMap.put("origin","https://bbs.byr.cn");
        headerMap.put("referer","https://bbs.byr.cn/");
        headerMap.put("Accept","*/*");
        headerMap.put("x-requested-with","XMLHttpRequest");

        Map<String, String> params = new HashMap<String, String>();
        url = "https://bbs.byr.cn/user/ajax_login.json";
        params.put("id", "weiandedidi");
        params.put("passwd", "maqidi4915338");
        String data = HttpsUtils.contactGetString(params);

        String result = HttpsUtils.doHttpsPost(url,data,headerMap);
        System.out.println(result);

    }

    @Test
    public void testHttpsGet() throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("accept", "*/*");
        headerMap.put("connection", "Keep-Alive");
        headerMap.put("Accept","*/*");
        headerMap.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        String result = HttpsUtils.doHttpsGet(url,null,headerMap);
        System.out.println(result);
    }
}
