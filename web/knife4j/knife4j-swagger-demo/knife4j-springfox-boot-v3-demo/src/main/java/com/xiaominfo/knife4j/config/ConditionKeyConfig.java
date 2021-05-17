/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.config;

import com.xiaominfo.knife4j.condition.ConditionKeyModel;
import com.xiaominfo.knife4j.condition.ConditionOnKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/23 14:20
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
@Configuration
public class ConditionKeyConfig {


    @Bean
    @ConditionOnKey(property = "key",targetValue = "test")
    public ConditionKeyModel conditionKeyModel(){
        return new ConditionKeyModel();
    }
}
