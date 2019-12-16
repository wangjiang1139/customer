package com.cn.cmbc.customer.function;

import com.cn.cmbc.customer.po.Employee;
import com.cn.cmbc.customer.request.EmployeeRequestBody;
import com.cn.cmbc.customer.service.QueryCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangjiang
 * @create 2019/12/10
 * @since 1.0.0
 */
@Controller
@RequestMapping("cust")
public class QueryCustomerFunction {

    @Autowired
    private QueryCustomerService queryCustomerService;

    @RequestMapping("/queryEmployeeService")
    @ResponseBody
    public List<Employee> queryEmployee(@RequestBody EmployeeRequestBody body){
        return queryCustomerService.queryEmployee(body);
    }

}
