/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/03/31 17:38
 */
public class Tss {

    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(10);
        while (true){
            try{
                for (int i=0;i<50;i++){
                    service.submit(new MyThread(i));
                }
                TimeUnit.SECONDS.sleep(200);
            }catch (Exception e){

            }
        }
    }
}
