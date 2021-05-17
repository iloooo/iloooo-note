/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.xiaominfo.knife4j.domain.resp205;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/10/13 16:59
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
public enum CommonPay {

    WxPay("Wxpay","微信支付"),
    AliPay("AliPay","支付宝支付");

    private String value;
    private String label;

    CommonPay(String value, String label) {
        this.value=value;
        this.label=label;
    }

    CommonPay(String text){
        System.out.println(text);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.value+":"+this.label;
    }
}
