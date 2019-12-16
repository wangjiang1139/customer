/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserTestServiceImpl
 * Author:   wangjiang
 * Date:     2019/12/16 21:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.cmbc.customer.service.impl;

import com.cn.cmbc.customer.mapper.UserMapper;
import com.cn.cmbc.customer.po.User;
import com.cn.cmbc.customer.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangjiang
 * @create 2019/12/16
 * @since 1.0.0
 */
@Service
public class UserTestServiceImpl implements UserTestService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryEmployee(User user) {
        System.out.println(user.getName());
        return userMapper.selectByExample(null);
    }
}
