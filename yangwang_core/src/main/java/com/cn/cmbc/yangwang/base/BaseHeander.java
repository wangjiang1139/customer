/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseHeander
 * Author:   wangjiang
 * Date:     2019/11/19 22:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.cmbc.yangwang.base;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseHeander {

    private String message;

    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
