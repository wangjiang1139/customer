/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FindAllUserFunction
 * Author:   wangjiang
 * Date:     2019/11/24 17:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.cmbc.customer.function;

import com.cn.cmbc.customer.po.User;
import com.cn.cmbc.customer.request.UserRequestBody;
import com.cn.cmbc.customer.service.FindAllUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class FindAllUserFunction {

    @Autowired
    private FindAllUserService findAllUserService;

    @RequestMapping("/findAllUserService")
    @ResponseBody
    public List<User> findAllUserFunction(@RequestBody UserRequestBody body){
        System.out.println(body);
       return findAllUserService.findAllUser();
    }
}
