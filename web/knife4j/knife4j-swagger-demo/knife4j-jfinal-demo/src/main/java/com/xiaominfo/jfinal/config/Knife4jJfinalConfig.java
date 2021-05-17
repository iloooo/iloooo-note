/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.jfinal.config;

import com.github.xiaoymin.knife4j.jfinal.JFinalDocument;
import com.github.xiaoymin.knife4j.jfinal.JFinalSwagger;
import com.github.xiaoymin.knife4j.jfinal.controller.JFinalSwaggerController;
import com.github.xiaoymin.knife4j.jfinal.controller.JFinalSwaggerRoute;
import com.jfinal.config.*;
import com.jfinal.template.Engine;
import com.xiaominfo.jfinal.controller.HelloController;
import com.xiaominfo.jfinal.controller.SwaggerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/01 20:05
 * @since:knife4j-jfinal-demo 1.0
 */
public class Knife4jJfinalConfig extends JFinalConfig {
    Logger logger= LoggerFactory.getLogger(Knife4jJfinalConfig.class);
    @Override
    public void configConstant(Constants constants) {

    }

    @Override
    public void configRoute(Routes routes) {
        //创建JFinalSwaggerDocument
        JFinalDocument jFinalDocument=new JFinalDocument.Builder().basePath("/")
                .name("测试").description("JFinal整合Knife4j文档")
                .title("JFinal整合Knife4j文档")
                .order(1).contact("xiaoymin@foxmail.com")
                .build();

        //添加路由
        //routes.add(new JFinalSwaggerRoute());
        routes.add("/jf-swagger", JFinalSwaggerController.class);
        routes.add("/ab", HelloController.class);
        routes.getRouteItemList().forEach(route -> {
            jFinalDocument.addController(route.getControllerKey(),route.getControllerClass());
        });

        JFinalSwagger.me.addDocs(jFinalDocument);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {
        //handlers.add(new WebJarHandler());

    }

    @Override
    public void onStart() {
        logger.info("启动回调");
       /* JFinalSwagger.me.addDocs(new JFinalDocument.Builder().basePath("/")
                .name("测试").description("JFinal整合Knife4j文档")
                .title("JFinal整合Knife4j文档")
                .paths("com.xiaominfo.jfinal.controller")
                .order(1).contact("xiaoymin@foxmail.com")
                .build());*/
        JFinalSwagger.me.start();
    }
}
