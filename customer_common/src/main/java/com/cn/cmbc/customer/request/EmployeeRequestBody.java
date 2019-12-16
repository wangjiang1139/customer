/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EmployeeRequestBody
 * Author:   wangjiang
 * Date:     2019/12/10 20:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.cmbc.customer.request;

import com.cn.cmbc.yangwang.base.BaseBody;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangjiang
 * @create 2019/12/10
 * @since 1.0.0
 */
@XmlRootElement(name = "body")
public class EmployeeRequestBody extends BaseBody implements Serializable {
     private  QueryEmployeeRequestBody body;

    public QueryEmployeeRequestBody getBody() {
        return body;
    }

    public void setBody(QueryEmployeeRequestBody body) {
        this.body = body;
    }
}
