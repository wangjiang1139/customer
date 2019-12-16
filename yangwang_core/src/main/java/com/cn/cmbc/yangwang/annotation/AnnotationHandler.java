package com.cn.cmbc.yangwang.annotation;

import com.cn.cmbc.yangwang.common.Contexts;
import com.cn.cmbc.yangwang.exception.MyException;
import com.cn.cmbc.yangwang.webservice.impl.WebServiceImpl;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用于调用外部服务时，注入对应的请求地址〉
 *
 * @author wangjiang
 * @create 2019/11/25
 * @since 1.0.0
 */
@Service
public class AnnotationHandler implements InitializingBean ,ApplicationContextAware{

    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationHandler.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext=applicationContext;
    }

    public static Map<String,String> urlMap = new ConcurrentHashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
            //读取配置文件
            initConfid();
            //扫描com.cn.cmbc.customer.service.impl下的有@ExistOutService注解的类
            Reflections reflections = new Reflections(Contexts.CONTEXTSCAN);
            Set<Class<?>> set = reflections.getTypesAnnotatedWith(ExistOutService.class);
            if(urlMap.size() != 0 && set != null && set.size()>0 && urlMap.size() != set.size()){
                LOGGER.error("请求外部服务配置文件未配齐");
                throw new MyException("A99099009","请求外部服务配置文件未配齐");
            }else {
                for (Class<?> bean : set){
                    Field[] fields = bean.getDeclaredFields();
                    for (Field field : fields){
                        if (field.isAnnotationPresent(Resource.class)){
                            String value = field.getAnnotation(Resource.class).name();
                            WebServiceImpl service = applicationContext.getBean(value, WebServiceImpl.class);
                            service.setURL(urlMap.get(value));
                            LOGGER.info("请求外部服务地址："+urlMap.get(value));
                        }
                    }
                }
            }
    }

    /**
     * 读取配置文件，获取key值以及对应的url地址，并封装到urlMap中
     * 1.它只能用于读取properties文件，别的文件不行
     * 2.它只能用于读取，不能用于写入
     * 3.它只能读取类路径下的properties文件
     */
    private void initConfid() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("properties.config");
            Enumeration<String> keys = bundle.getKeys();
            while (keys.hasMoreElements()){
                String key = keys.nextElement();//获取key值
                String url = bundle.getString(key);
                if(urlMap.containsKey(key)){
                    LOGGER.error("访问外部服务配置文件key值不能重复"+key);
                    throw new MyException("A090900","访问外部服务配置文件key值不能重复"+key);
                }
                urlMap.put(key,url);
            }
        }catch (Exception e){
            throw new  MyException("A00909","初始化调用外部服务配置文件报错");
        }

    }
}
