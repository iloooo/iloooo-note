/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.new2;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ImageUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.xiaominfo.knife4j.common.Rest;
import com.xiaominfo.knife4j.domain.resp192.Result;
import com.xiaominfo.knife4j.domain.resp209.ModelApiResponse;
import com.xiaominfo.knife4j.domain.resp209.ModelInteger;
import com.xiaominfo.knife4j.util.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/19 14:47
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
@Api(tags = "2.0.9版本-20210208")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 279)
@RestController
@RequestMapping("/api/nxew209")
public class Api209Controller {
    Logger logger= LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/download/{tableName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @Operation(summary = "按表下载生成的代码模板信息",description = "参考https://gitee.com/xiaoym/knife4j/issues/I374SP")
    @ApiOperationSupport(order = 9900203)
    public void download(@PathVariable String tableName, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File file = new File("C:\\Users\\xiaoymin\\Desktop\\"+tableName);
        String zipPath = file.getPath() + ".zip";
        ZipUtil.zip(file.getPath(), zipPath);
        FileUtils.downloadFile(req, resp, new File(zipPath), false);
    }

    @Operation(summary = "uploads an image", security = {
            @SecurityRequirement(name = "petstore_auth",
                    scopes = {
                            "write:pets",
                            "read:pets"})})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "successful operation",
                    content = @Content(schema = @Schema(implementation =
                            ModelApiResponse.class)))})
    @PostMapping(value = "/pet/{petId}/uploadImage", produces = {"application/json"}, consumes = {
            "application/octet-stream"})
    public ResponseEntity<ModelApiResponse> uploadFile(
            @Parameter(description = "ID of pet to update", required = true) @PathVariable("petId") Long petId,
            @Parameter(description = "Additional Metadata") @RequestParam(value = "additionalMetadata",
                    required = false) String additionalMetadata,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = "application/octet-stream",
                            schema =
                            @Schema(
                                    type = "string",
                                    format = "binary"))) @Valid @RequestPart(
                    "file") MultipartFile file) {
        ModelApiResponse modelApiResponse=new ModelApiResponse();
        modelApiResponse.setUrl("ddd");
        return ResponseEntity.ok(modelApiResponse);
    }


    @RequestMapping("/hi")
    @ApiOperation(value = "你好",notes = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    public Rest<String> hi(){
        return Rest.data(RandomUtil.randomString(13));
    }


    @ApiOperation(value = "Long类型format")
    @PostMapping("/model")
    public Rest<ModelInteger> model(@RequestBody ModelInteger modelInteger){
        return Rest.data(modelInteger);
    }

    /**
     * https://gitee.com/xiaoym/knife4j/issues/I3IUUQ
     * @param request
     * @param response
     * @throws Exception
     */
    @ApiOperation(value = "获取验证码", produces = "image/gif")
    @GetMapping(value = "/captcha", produces = "image/gif")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        LineCaptcha lineCaptcha=CaptchaUtil.createLineCaptcha(100,50);
        Image image=lineCaptcha.createImage(RandomUtil.randomNumbers(5));
        ImageUtil.write(image,"gif",response.getOutputStream());
    }

    /**
     * https://gitee.com/xiaoym/knife4j/issues/I3BRWT
     * @param file
     * @return
     */
    @PostMapping(value = "/upload")
    @ApiOperation(value = "上传文件")
    public Rest<String> upload(@RequestPart(value = "file") MultipartFile file) {
        return Rest.data("fileName:"+file.getName());
    }
}
