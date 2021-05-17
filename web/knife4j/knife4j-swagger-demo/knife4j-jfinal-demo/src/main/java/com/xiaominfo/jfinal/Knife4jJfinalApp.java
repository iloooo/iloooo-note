/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.jfinal;

import com.jfinal.server.undertow.UndertowServer;
import com.xiaominfo.jfinal.config.Knife4jJfinalConfig;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/01 20:13
 * @since:knife4j-jfinal-demo 1.0
 */
public class Knife4jJfinalApp {

    public static void main(String[] args) {
        UndertowServer.start(Knife4jJfinalConfig.class,18011,true);
    }
}
