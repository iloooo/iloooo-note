/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/11/20 10:54
 */
public class DeamThread extends Thread {
    @Override
    public void run() {
        while (true){
            try{
                System.out.println("i am alive");
                Thread.sleep(900);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        DeamThread d=new DeamThread();
        d.setDaemon(true);
        d.start();
    }
}
