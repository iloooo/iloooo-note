/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/02/18 21:30
 */
@Component
public class AppArgsSmartLifecycle implements SmartLifecycle{

    private boolean isRunning=false;

    private final ApplicationArguments applicationArguments;

    public AppArgsSmartLifecycle(ApplicationArguments applicationArguments) {
        this.applicationArguments = applicationArguments;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable runnable) {
        runnable.run();
    }

    @Override
    public void start() {
        System.out.println("--------------------AppArgsSmartLifecycle--Start()------------------------------");

        System.out.println(applicationArguments);
        if (applicationArguments!=null){
            System.out.println(applicationArguments.getNonOptionArgs());
        }

        isRunning=true;
    }

    @Override
    public void stop() {
        isRunning=false;

    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }
}
