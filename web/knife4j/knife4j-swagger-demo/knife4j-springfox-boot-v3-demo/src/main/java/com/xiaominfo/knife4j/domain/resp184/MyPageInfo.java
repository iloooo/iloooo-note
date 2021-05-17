package com.xiaominfo.knife4j.domain.resp184;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songYu on 2018/6/26 17:31
 * DESC : 分页信息类
 */
public class MyPageInfo <T> {

    private int pages;
    private List<T> list=new ArrayList<>();



    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
