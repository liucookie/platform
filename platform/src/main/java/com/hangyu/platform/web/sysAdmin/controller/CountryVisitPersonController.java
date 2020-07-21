package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.GuoneivisitpointTbl;
import com.hangyu.platform.web.sysAdmin.service.CountryVisitPersonService;
import com.hangyu.platform.web.sysAdmin.service.NationSecretRemoveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 国内人员参观部位管理
 */
@RestController
@RequestMapping("v1/countryVisitPerson/")
@Api(tags = "国内人员参观部位管理")
public class CountryVisitPersonController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private CountryVisitPersonService service;

    /**
     * 查询国内人员参观部位
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有国内人员参观部位{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResponseEntity<Object> query(@RequestParam("pageNum") int pageNum,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam(value = "accessName",required = false) String accessName,
                                        @RequestParam(value = "orgName",required = false) String orgName) {
        Map<String,Object> type = service.query(pageNum, pageSize,accessName,orgName);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询国内人员参观部位
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个国内人员参观部位{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryById(@PathVariable("id") String id) {
        GuoneivisitpointTbl type = service.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加国内人员参观部位
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加国内人员参观部位{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody GuoneivisitpointTbl type) {
        service.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改国内人员参观部位
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改国内人员参观部位{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody GuoneivisitpointTbl type) {
        service.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除国内人员参观部位
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除国内人员参观部位{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        service.deleteType(id);
        return ResponseEntity.ok(result);
    }

    /**
     * 批量删除国内人员参观部位
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "批量删除国内人员参观部位{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteBatch", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBatch(@RequestBody List<String> list) {
        list.forEach(id ->{
            service.deleteType(id);
        });
        return ResponseEntity.ok(result);
    }

}
