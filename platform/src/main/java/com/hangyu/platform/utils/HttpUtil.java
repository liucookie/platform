package com.hangyu.platform.utils;

import com.alibaba.fastjson.JSONObject;
import com.hangyu.platform.global.PlatException;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.Map;

@Service
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    @Autowired
    private CloseableHttpClient httpClient;
    @Autowired
    private RequestConfig requestConfig;

    /**
     * 通过给的url地址，获取服务器数据
     *
     * @param url    服务器地址
     * @param params 封装用户参数
     * @return
     */
    public String get(String url, Map<String, String> params, String token) {
        //构造请求头
        BasicHeader header1 = new BasicHeader("Content-Type", "application/json");
        BasicHeader header2 = new BasicHeader("Authorization", token);
        Header[] headers = new Header[]{header1, header2};

        //判断是否有参数
        if (params != null) {
            url += "?";
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                url += key + "=" + value + "&";
            }
            url = url.substring(0, url.length() - 1);
        }
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        httpGet.setHeaders(headers);
        String result;
        logger.info("********url*******:{}", url);
        logger.info("********token*******:{}", token);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            } else {
                throw new PlatException("调用流程失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }


    /**
     * 通过给的url地址，获取服务器数据
     *
     * @param url    服务器地址
     * @param params 封装用户参数
     * @return
     */
    public String post(String url, String token, JSONObject params) {

        //post请求返回结果
        HttpPost httpPost = new HttpPost(url);
        //构造请求头
        BasicHeader header1 = new BasicHeader("Content-Type", "application/json");
        BasicHeader header2 = new BasicHeader("Authorization", token);
        Header[] headers = new Header[]{header1, header2};

        httpPost.setHeaders(headers);
        logger.info("********request body*******:{}", params.toString());
        logger.info("********url*******:{}", url);
        logger.info("********token*******:{}", token);
        //解决中文乱码问题，设置body
        StringEntity entity = new StringEntity(params.toString(), "utf-8");
        httpPost.setEntity(entity);
        String result;
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
                logger.info("********success connect eip service*******");
            } else {
                throw new PlatException("调用流程失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }


}
