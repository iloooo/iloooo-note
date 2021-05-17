/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2018/10/16 15:53
 */
@Aspect
@Configuration
public class AspectDemo {

    private ThreadLocal<Long> time = new ThreadLocal<>();

    /* 定义一个切入点 */
    @Pointcut("execution(* com.swagger.bootstrap.ui.demo.aop.*Service.*(..))")
    public void doPointCut() {
        System.out.println("pointCut");
    }

    /* 通过连接点切入 */
    @Before("execution(* com.swagger.bootstrap.ui.demo.aop.*Service.*(..))")
    public void doBefore() {
        time.set(System.currentTimeMillis());
    }

    @AfterReturning("execution(* com.swagger.bootstrap.ui.demo.aop.*Service.*(..))")
    public void doAfterReturning(JoinPoint joinPoint) {
        System.out.println("doAfterReturning(joinPoint) {}, time used={}"+joinPoint.getSignature()+
                (System.currentTimeMillis() - time.get()));
    }

    @Around("execution(* com.swagger.bootstrap.ui.demo.aop.*Service.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        System.out.println("AOP @Around start");
        try {
            Object obj = joinPoint.proceed();
            System.out.println("AOP @Around end");
            return obj;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
