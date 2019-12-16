package com.cn.cmbc.customer.service;

import com.cn.cmbc.customer.po.Employee;
import com.cn.cmbc.customer.request.EmployeeRequestBody;
import com.cn.cmbc.yangwang.base.WebServiceBase;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

public interface QueryCustomerService extends WebServiceBase{

    @POST
    @Path("/findAllEmployeeService")
    List<Employee> queryEmployee(EmployeeRequestBody body);
}
