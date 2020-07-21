package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.Bm2MemorycardtypeTbl;
import com.hangyu.platform.web.sysAdmin.service.MemoryCardService;
import com.hangyu.platform.web.sysAdmin.vo.dictVO.MemoryCardVO;
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
 * 存储卡类型配置
 */
@RestController
@RequestMapping("v1/memoryCard/")
@Api(tags = "存储卡类型配置")
public class MemoryCardTypeController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());

    @Autowired
    private MemoryCardService cardService;

    /**
     * 查询存储卡类型配置
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有存储卡类型配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAllType", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAllType(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        MemoryCardVO vo = cardService.queryType(pageNum, pageSize);
        return ResponseEntity.ok(vo);
    }

    /**
     * 查询存储卡类型配置
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个存储卡类型配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryTypeId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        Bm2MemorycardtypeTbl cardType = cardService.queryUseStateById(id);
        return ResponseEntity.ok(cardType);
    }

    /**
     * 增加存储卡类型配置
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "增加存储卡类型配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public ResponseEntity<Object> addType(@RequestBody Bm2MemorycardtypeTbl type) {
        cardService.addType(type);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改存储卡类型配置
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "修改存储卡类型配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateType", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateType(@RequestBody Bm2MemorycardtypeTbl type) {
        cardService.updateType(type);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除设备状态
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除存储卡类型配置{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@PathVariable("id") String id) {
        cardService.deleteType(id);
        return ResponseEntity.ok(result);
    }

}
