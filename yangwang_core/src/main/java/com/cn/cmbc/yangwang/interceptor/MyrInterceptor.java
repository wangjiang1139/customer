package com.cn.cmbc.yangwang.interceptor;

import com.alibaba.fastjson.JSON;
import com.cn.cmbc.yangwang.base.BaseHeander;
import com.cn.cmbc.yangwang.exception.MyException;
import com.cn.cmbc.yangwang.request.RequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈拦截器定义〉
 *
 * @author wangjiang
 * @create 2019/11/19
 * @since 1.0.0
 */
public class MyrInterceptor implements HandlerInterceptor{

    private  static HashMap<String,BaseHeander> headerMap;

    private static final Logger LOGGER = LoggerFactory.getLogger(MyrInterceptor.class);
    //拦截之前做的事
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        RequestWrapper myRequestWrapper = new RequestWrapper(request);
        HashMap map = JSON.parseObject(myRequestWrapper.getBody(), HashMap.class);
        String header = map.get("header").toString();
        String body = map.get("body").toString();
        LOGGER.info("请求头："+header);
        LOGGER.info("请求报文："+body);
        //获取请求头
        initHeaderMap(JSON.parseObject(header, BaseHeander.class));
        return true;
    }

    public static void initHeaderMap(BaseHeander header){
                    headerMap = new HashMap<String, BaseHeander>();
                    headerMap.put("header",header);
    }

    public static HashMap<String,BaseHeander> getHeaderMap(){
        if(headerMap != null && headerMap.size()==1){
            return headerMap;
        }else {
            throw new MyException("A0090","线程不安全");
        }

    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }
}
