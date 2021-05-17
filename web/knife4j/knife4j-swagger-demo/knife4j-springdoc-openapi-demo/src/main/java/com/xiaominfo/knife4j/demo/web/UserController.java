/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.demo.web;

import com.xiaominfo.knife4j.demo.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 *
 * @since:knife4j-springdoc-openapi-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/15 20:38
 */
@Tag(name = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {


    @Operation(summary = "创建用户",description = "根据姓名创建用户")
    @GetMapping("/create")
    public ResponseEntity<String> create(String name){
        return ResponseEntity.ok(name);
    }

    @Operation(summary = "创建用户-createOne",description = "根据姓名创建用户1")
    @PostMapping("/createOne")
    public ResponseEntity<User> createOne(@RequestBody User user){
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "创建用户1",description = "根据姓名创建用户1")
    @PostMapping("/createOne1")
    public ResponseEntity<User> createOne1(User user){
        return ResponseEntity.ok(user);
    }
}
