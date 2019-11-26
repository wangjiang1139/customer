package com.cn.cmbc.customer.request;

import com.cn.cmbc.yangwang.base.BaseBody;

import java.io.Serializable;

public class UserRequestBody extends BaseBody implements Serializable {

    private UserFindAllRequestBody body;

    public UserFindAllRequestBody getBody() {
        return body;
    }

    public void setBody(UserFindAllRequestBody body) {
        this.body = body;
    }
}
