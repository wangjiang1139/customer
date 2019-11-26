/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyException
 * Author:   wangjiang
 * Date:     2019/11/19 20:28
 * Description: 自定义异常类的处理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.cmbc.yangwang.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyException extends RuntimeException{

   private static final Logger logger = LoggerFactory.getLogger(MyException.class);

   private String code;

   private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
