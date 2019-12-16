/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QueryEmployeeRequestBody
 * Author:   wangjiang
 * Date:     2019/12/10 20:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.cmbc.customer.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wangjiang
 * @create 2019/12/10
 * @since 1.0.0
 */
@XmlRootElement(name = "reqBody")
public class QueryEmployeeRequestBody {

    private String flag;

    private String batchId;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
}
