package com.cn.cmbc.customer.service.impl;

import com.cn.cmbc.customer.mapper.UserMapper;
import com.cn.cmbc.customer.po.User;
import com.cn.cmbc.customer.service.FindAllUserService;
import com.cn.cmbc.yangwang.annotation.ExistOutService;
import com.cn.cmbc.yangwang.exception.MyException;
import com.cn.cmbc.yangwang.webservice.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@ExistOutService
public class FindAllUserServiceImpl implements FindAllUserService{

    @Autowired
    private UserMapper userMapper;

    @Resource(name = "batch.getMyBean.ws.getMyBean")
    private WebService service;

    @Override
    public List<User> findAllUser() {
        Map<String,Object> input = new HashMap<String,Object>();
        Map<String,Object> bean = new HashMap<String,Object>();
        bean.put("data", "A");
        bean.put("header", "123123");
        bean.put("id", 13);
        input.put("myBean", bean);
        String jsonString = null;
        try {
            jsonString = service.execute(input);
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException("A00909","调用batch报错");
        }
        System.out.println(jsonString);
        List<User> users = userMapper.selectByExample(null);
        User user = users.get(0);
        user.setName(jsonString);
        return users;
    }
}
