/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: WebServiceImpl
 * Author:   wangjiang
 * Date:     2019/11/24 23:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.cmbc.yangwang.webservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.cmbc.yangwang.webservice.WebService;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.stereotype.Component;

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
@Component
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