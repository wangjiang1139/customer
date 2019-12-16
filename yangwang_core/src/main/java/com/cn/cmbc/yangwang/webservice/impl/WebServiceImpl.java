package com.cn.cmbc.yangwang.webservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.cmbc.yangwang.webservice.WebService;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangjiang
 * @create 2019/11/24
 * @since 1.0.0
 */
public class WebServiceImpl implements WebService{

   private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String execute(Map<String,Object> input) {
        return WebClient.create(URL).type(MediaType.APPLICATION_JSON).post(JSONObject.toJSONString(input)).readEntity(String.class);
    }
}