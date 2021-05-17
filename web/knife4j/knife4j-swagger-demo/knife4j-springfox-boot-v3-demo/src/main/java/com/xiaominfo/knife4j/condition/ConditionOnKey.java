/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.xiaominfo.knife4j.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author xiaoymin
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Conditional(value = ConditionOnKeyApply.class)
public @interface ConditionOnKey {
    /**
     * 获取某个属性的值
     * @return
     */
    String property();

    /**
     * 目标值
     * @return
     */
    String targetValue() default "true";
}
