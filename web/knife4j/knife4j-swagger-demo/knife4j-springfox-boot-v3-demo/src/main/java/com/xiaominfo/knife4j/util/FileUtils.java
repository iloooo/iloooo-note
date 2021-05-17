/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.knife4j.util;

import cn.hutool.core.io.FileUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2021/02/08 13:04
 * @since:knife4j-springfox-boot-v3-demo 1.0
 */
public class FileUtils {
    static Logger log= LoggerFactory.getLogger(FileUtils.class);

    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, File file,
                                    boolean deleteOnExit) {
        response.setCharacterEncoding(request.getCharacterEncoding());
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            response.addHeader("Content-Disposition", "attachment;filename=" + file.getName());
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    if (deleteOnExit) {
                        file.deleteOnExit();
                    }
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
}
