/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RequestWrapper
 * Author:   wangjiang
 * Date:     2019/11/20 19:02
 * Description: 重写HttpServletRequestWrapper方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.cmbc.yangwang.request;
import com.cn.cmbc.yangwang.exception.MyException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 〈一句话功能简述〉<br> 
 * 〈重写HttpServletRequestWrapper方法〉
 *
 * @author wangjiang
 * @create 2019/11/20
 * @since 1.0.0
 */
public class RequestWrapper extends HttpServletRequestWrapper{

    private String body = null;
    public RequestWrapper(HttpServletRequest request) {
        super(request);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            ServletInputStream inputStream = request.getInputStream();
            if(inputStream != null){
                br = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = br.read(charBuffer)) > 0) {
                    sb.append(charBuffer, 0, bytesRead);
                }
            }else {
                sb.append("");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw  new MyException("A00987","重新定义request对象出现异常");
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        body = sb.toString();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
        ServletInputStream servletInputStream = new ServletInputStream() {
            public boolean isFinished() {
                return false;
            }
            public boolean isReady() {
                return false;
            }
            public void setReadListener(ReadListener readListener) {}
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
        return servletInputStream;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    public String getBody() {
        return this.body;
    }
}
