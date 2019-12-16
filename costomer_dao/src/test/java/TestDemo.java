/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestDemo
 * Author:   wangjiang
 * Date:     2019/12/12 19:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangjiang
 * @create 2019/12/12
 * @since 1.0.0
 */
public class TestDemo {
    public static void main(String[] args) {
        Map<String,Object> body = new HashMap<String,Object>();
        Map<String,Object> input = new HashMap<String,Object>();
        Map<String,Object> reqBody = new HashMap<String,Object>();
        reqBody.put("flag","A");
        reqBody.put("batchId","123123123");
        Map<String,Object> baseBody = new HashMap<String,Object>();
        Map<String,Object> header = new HashMap<String,Object>();
        header.put("message","nihao");
        header.put("status","S");
        baseBody.put("header",header);
        input.put("reqBody",reqBody);
        input.put("baseBody",baseBody);
        body.put("body",input);
        String json = JSONObject.toJSONString(body);
        System.out.println(json);
        String string = WebClient.create("http://localhost:7003/customer_web/ws/cust/findAllEmployeeService").type(MediaType.APPLICATION_JSON).post(json).readEntity(String.class);
        System.out.println(string);
        Map map = JSONObject.parseObject(string, Map.class);
        System.out.println(map);
        List<JSONObject> result = (List<JSONObject>) map.get("result");
        for (JSONObject object : result){
            Map beanMap = JSONObject.parseObject(object.toJSONString(), Map.class);
            Set set = beanMap.keySet();
            for (Object oi : set){
                System.out.println(oi);
            }
            System.out.println("==================================================");
            Collection values = beanMap.values();
            for (Object o : values){
                System.out.println(o.toString());
            }
        }
    }

}
