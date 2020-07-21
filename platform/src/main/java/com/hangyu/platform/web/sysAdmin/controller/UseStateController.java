package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Usestate;
import com.hangyu.platform.web.sysAdmin.service.UseStateService;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.UseStateVO;
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
 * 设备使用状态
 */
@RestController
@RequestMapping("v1/useState/")
@Api(tags = "设备状态接口")
public class UseStateController {


    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(),ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private UseStateService useStateService;

    /**
     * 查询设备使用状态管理
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有设备状态{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllUseState", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllUseState(@RequestParam("pageNum") int pageNum,
                                                   @RequestParam("pageSize") int pageSize) {

        UseStateVO vo = useStateService.queryUseState(pageNum, pageSize);
        return ResponseEntity.ok(vo);
    }

    /**
     * 查询设备使用状态管理
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个设备状态{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryUseStateById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryUseStateById(@PathVariable("id") String id) {

        Usestate state = useStateService.queryUseStateById(id);
        return ResponseEntity.ok(state);
    }

    /**
     * 增加设备状态
     *
     * @param useState
     * @return
     */
    @ApiOperation(value = "增加设备状态{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addUseState", method = RequestMethod.POST)
    public ResponseEntity<Object> addUseState(@RequestBody Usestate useState) {

        useStateService.addUseState(useState);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改设备状态
     *
     * @param useState
     * @return
     */
    @ApiOperation(value = "修改设备状态{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateUseState", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUseState(@RequestBody Usestate useState) {

        useStateService.updateUseState(useState);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除设备状态
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除设备状态{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteUseState/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUseState(@PathVariable("id") String id) {

        useStateService.deleteUseState(id);
        return ResponseEntity.ok(result);
    }

}
