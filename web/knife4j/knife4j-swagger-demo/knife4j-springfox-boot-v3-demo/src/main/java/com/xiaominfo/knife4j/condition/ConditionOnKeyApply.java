/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.condition;

import cn.hutool.core.util.StrUtil;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/23 14:09
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
public class ConditionOnKeyApply implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> multiValueMap=annotatedTypeMetadata.getAnnotationAttributes(ConditionOnKey.class.getName());
        //获取property
        String propertyValue=Objects.toString(multiValueMap.get("property"),"");
        //获取目标值
        String targetValue=Objects.toString(multiValueMap.get("targetValue"),"");
        if (StrUtil.isNotBlank(propertyValue)&&StrUtil.isNotBlank(targetValue)){
            //都不为空的情况下
            Environment environment=conditionContext.getEnvironment();
            //从配置环境中获取值
            String sourceValue=environment.getProperty(propertyValue);
            System.out.println("环境值:"+sourceValue+",目标值:"+targetValue);
            // 进行比对
            return StrUtil.equalsIgnoreCase(sourceValue,targetValue);
        }
        return false;
    }
}
