package com.gpdi.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @Auther: Kevin Cui
 * @Date: 18/6/26 14:52
 * @Description:
 */
public class HttpClientHelper {

    public static String httpGet(String url) {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        String result = null;
        try {
            SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
            httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Content-type", "application/isIntersection-www-form-urlencoded; charset=UTF-8");
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            result = IOUtils.toString(inputStream);
            EntityUtils.consume(entity);
            response.close();
            httpclient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送 post请求
     */
    public static String httpPost(String url, String json) {
        String obj = null;
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-type", "application/json; charset=utf-8");
        httppost.setHeader("Accept", "application/json");
        try {
            StringEntity s = new StringEntity(json, Charset.forName("UTF-8"));  //对参数进行编码，防止中文乱码
            s.setContentEncoding("UTF-8");
            httppost.setEntity(s);
            try (CloseableHttpResponse response = httpclient.execute(httppost)) {
                //获取相应实体
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    obj = EntityUtils.toString(entity, "UTF-8");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }


    /**
     * 发送 http put 请求，参数以原生字符串进行提交
     * @param url,json
     * @return
     */
    public static String httpPut(String url, String json) {
        String encode = "utf-8";
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut(url);

        //设置header
        httpput.addHeader("Content-type", "application/json; charset=utf-8");
        httpput.setHeader("Accept", "application/json");

        //组织请求参数
        StringEntity stringEntity = new StringEntity(json, encode);
        httpput.setEntity(stringEntity);
        String content = null;
        CloseableHttpResponse httpResponse = null;
        try {
            //响应信息
            httpResponse = closeableHttpClient.execute(httpput);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert httpResponse != null;
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            closeableHttpClient.close();  //关闭连接、释放资源
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
