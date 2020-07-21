package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.OaequiptypeTbl;
import com.hangyu.platform.web.sysAdmin.service.OATypeService;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.OATypeVO;
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

/**
 * 办公自动化类型配置
 */
@RestController
@RequestMapping("v1/OAType/")
@Api(tags = "办公自动化类型配置")
public class OATypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private OATypeService typeService;

    /**
     * 查询所有办公自动化类型
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有办公自动化类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllType(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        OATypeVO vo = typeService.queryType(pageNum, pageSize);
        return ResponseEntity.ok(vo);
    }

    /**
     * 查询办公自动化类型
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个办公自动化类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        OaequiptypeTbl type = typeService.queryById(id);
        return ResponseEntity.ok(type);
    }

    /**
     * 增加办公自动化类型
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加办公自动化类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody OaequiptypeTbl type) {
        typeService.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改办公自动化类型
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改办公自动化类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody OaequiptypeTbl type) {
        typeService.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除办公自动化类型
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除办公自动化类型{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        typeService.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
