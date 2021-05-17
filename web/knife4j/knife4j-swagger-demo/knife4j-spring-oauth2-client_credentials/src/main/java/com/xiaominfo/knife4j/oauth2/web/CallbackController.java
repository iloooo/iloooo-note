/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.oauth2.web;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @since:knife4j-spring-oauth2 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/15 9:41
 */
@RestController
@RequestMapping("/auth")
public class CallbackController {

    @GetMapping("/callback")
    public String get(@RequestParam(value = "code") String code){
        System.out.println("callback-code:"+code);
        HttpPost post=new HttpPost("http://localhost:18010/oauth/token");
        List<NameValuePair> params=new ArrayList<>();
        params.add(new BasicNameValuePair("code",code));
        try {
            post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            CloseableHttpResponse res=HttpClients.createDefault().execute(post);
            if (res.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                String content= EntityUtils.toString(res.getEntity(),"UTF-8");
                return content;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "err";

    }
}

