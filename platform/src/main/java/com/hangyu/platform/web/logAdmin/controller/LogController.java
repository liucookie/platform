package com.hangyu.platform.web.logAdmin.controller;

import com.hangyu.platform.aop.SystemLog;
import com.hangyu.platform.global.Result;
import com.hangyu.platform.utils.MyExcelExportUtil;
import com.hangyu.platform.web.logAdmin.dto.Loginfo;
import com.hangyu.platform.web.logAdmin.service.LogService;
import com.hangyu.platform.web.logAdmin.vo.LogQueryVO;
import com.hangyu.platform.web.logAdmin.vo.LogVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 日志管理
 */
@RestController
@Api(tags = "日志管理")
@RequestMapping(value = "v1/log/")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 查看用户/系统日志
     * @return
     */
    @RequestMapping(value = "queryLog",method = RequestMethod.POST)
    @ApiOperation(value="查看日志{author:liuxuan}",response= Result.class)
    public ResponseEntity<Object> queryLog(@RequestBody LogQueryVO queryVO){
        LogVO vo = logService.queryLog(queryVO);
        return ResponseEntity.ok(vo);
    }

    /**
     * 导出日志
     * @param response
     * @param  queryVO
     * @return
     */
    @SystemLog(module="日志管理",methods="导出日志")
    @RequestMapping(value = "exportLog",method = RequestMethod.POST)
    @ApiOperation(value="导出日志{author:liuxuan}",response= Result.class)
    public ResponseEntity<Object> exportLog(HttpServletResponse response,@RequestBody LogQueryVO queryVO){
        List<Loginfo> logInfos = logService.exportExcel(queryVO);
        MyExcelExportUtil.exportExcel(logInfos, Loginfo.class,"操作日志记录表","操作日志记录",response);
        return ResponseEntity.ok("导出成功");
    }
}
