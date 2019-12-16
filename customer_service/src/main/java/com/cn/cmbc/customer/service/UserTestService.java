package com.cn.cmbc.customer.service;

import com.cn.cmbc.customer.po.User;
import com.cn.cmbc.yangwang.base.WebServiceBase;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

public interface UserTestService extends WebServiceBase{

    @POST
    @Path("/findAllUserTestService")
    List<User> queryEmployee(User user);
}
