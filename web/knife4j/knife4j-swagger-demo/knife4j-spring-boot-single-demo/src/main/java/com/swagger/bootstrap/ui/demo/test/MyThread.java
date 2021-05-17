/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.test;

import java.util.concurrent.TimeUnit;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/03/31 17:42
 */
public class MyThread implements Runnable {

    private int index;

    @Override
    public void run() {
        System.out.println("threadName:"+Thread.currentThread().getName()+" is Running..Index:"+index);
        try{
            TimeUnit.SECONDS.sleep(index);
        }catch (Exception e){

        }
        System.out.println("index:"+index+" is Finished.");
    }

    public MyThread(int index) {
        this.index = index;
    }
}
