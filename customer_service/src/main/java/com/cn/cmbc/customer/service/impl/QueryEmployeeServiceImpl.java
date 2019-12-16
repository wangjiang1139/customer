/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QueryEmployeeServiceImpl
 * Author:   wangjiang
 * Date:     2019/12/10 20:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.cmbc.customer.service.impl;

import com.cn.cmbc.customer.mapper.EmployeeMapper;
import com.cn.cmbc.customer.po.Employee;
import com.cn.cmbc.customer.request.EmployeeRequestBody;
import com.cn.cmbc.customer.service.QueryCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangjiang
 * @create 2019/12/10
 * @since 1.0.0
 */
@Service
public class QueryEmployeeServiceImpl implements QueryCustomerService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryEmployee(EmployeeRequestBody body) {
        return employeeMapper.selectByExample(null);
    }
}
