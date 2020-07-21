package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Secretlevel;
import com.hangyu.platform.web.sysAdmin.service.SecretLevelService;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.SecretLevelVO;
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

import java.util.List;

/**
 * 密级管理
 */
@RestController
@RequestMapping("v1/secretLevel/")
@Api(tags = "密级管理")
public class SecretlevelController {


    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private SecretLevelService secretService;

    /**
     * 查询所有密级
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllSecret", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllSecret(@RequestParam(value = "pageNum",required = false) int pageNum,
                                                   @RequestParam(value = "pageSize",required = false) int pageSize) {

        SecretLevelVO vo = secretService.querySecretLevel(pageNum, pageSize);
        return ResponseEntity.ok(vo);
    }

    /**
     * 查询所有密级
     *
     * @return
     */
    @ApiOperation(value = "查询所有密级不分页{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "querySecret", method = RequestMethod.GET)
    public ResponseEntity<Object> querySecret() {

        List<Secretlevel> list = secretService.querySecret();
        return ResponseEntity.ok(list);
    }

    /**
     * 查询单个密级
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "querySecretById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> querySecretById(@PathVariable("id") String id) {

        Secretlevel secret = secretService.querySecretById(id);
        return ResponseEntity.ok(secret);
    }

    /**
     * 增加密级
     *
     * @param secretlevel
     * @return
     */
    @ApiOperation(value = "增加密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addSecretLevel", method = RequestMethod.POST)
    public ResponseEntity<Object> addSecretLevel(@RequestBody Secretlevel secretlevel) {

        secretService.addSecret(secretlevel);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改密级
     *
     * @param secretlevel
     * @return
     */
    @ApiOperation(value = "修改密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateSecretLevel", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSecretLevel(@RequestBody Secretlevel secretlevel) {

        secretService.updateSecret(secretlevel);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除密级
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除密级{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteSecretLevel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSecretLevel(@PathVariable("id") String id) {

        secretService.deleteSecret(id);
        return ResponseEntity.ok(result);
    }

}
