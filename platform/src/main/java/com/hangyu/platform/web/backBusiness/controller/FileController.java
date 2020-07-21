package com.hangyu.platform.web.backBusiness.controller;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * 文件管理管理
 *
 * @author lx
 * @ClassName FileController
 * @date 2020-3-4
 */
@RestController
@RequestMapping(value = "v1/file")
@Api(tags = "文件管理相关接口")
public class FileController {
    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Value("${file.upload.path}")
    private String filePath;


    @ApiOperation(value = "文件下载{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "/download/{filename}", method = RequestMethod.GET)
    public ResponseEntity<Object> downLoad(HttpServletResponse response, @PathVariable("filename") String filename) throws UnsupportedEncodingException, IOException {
        FileUtils.download(response, CommonFields.getFilePath(), filename);
        return ResponseEntity.ok(result);
    }


}