package com.hangyu.platform.web.sysAdmin.controller;

import com.hangyu.platform.global.Result;
import com.hangyu.platform.global.ResultStatusEnum;
import com.hangyu.platform.web.sysAdmin.dto.AfficheTbl;
import com.hangyu.platform.web.sysAdmin.service.AfficheService;
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
import java.util.Map;

/**
 * 公告管理
 */
@RestController
@RequestMapping("v1/affiche/")
@Api(tags = "公告管理")
public class AfficheController {

    Result result = new Result(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());


    @Autowired
    private AfficheService service;

    /**
     * 查询所有公告
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有公告{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAffiche", method = RequestMethod.GET)
    public ResponseEntity<Object> queryAffiche(@RequestParam("pageNum") int pageNum,
                                               @RequestParam("pageSize") int pageSize) {
        Map<String,Object> type = service.queryAffiche(pageNum, pageSize);
        return ResponseEntity.ok(type);
    }

    /**
     * 查询单个公告
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个公告{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "queryAfficheById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> queryTypeId(@PathVariable("id") String id) {
        AfficheTbl affiche = service.queryAfficheById(id);
        return ResponseEntity.ok(affiche);
    }

    /**
     * 发布公告
     *
     * @param list
     *  @param type 0,插销发布，1发布
     * @return
     */
    @ApiOperation(value = "发布/撤销公告{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "isPublish/{type}", method = RequestMethod.POST)
    public ResponseEntity<Object> publish(@PathVariable("type") int type,@RequestBody List<String> list) {
        list.forEach(id->{
            service.publish(id,type);
        });
        return ResponseEntity.ok(result);
    }


    /**
     * 保存公告
     *
     * @param affiche
     * @return
     */
    @ApiOperation(value = "增加公告{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addAffiche", method = RequestMethod.POST)
    public ResponseEntity<Object> addAffiche(@RequestBody AfficheTbl affiche) {
        service.addType(affiche,false);
        return ResponseEntity.ok(result);
    }

    /**
     * 保存公告
     *
     * @param affiche
     * @return
     */
    @ApiOperation(value = "增加并发布公告{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "addAffichePublish", method = RequestMethod.POST)
    public ResponseEntity<Object> addAffichePublish(@RequestBody AfficheTbl affiche) {
        service.addType(affiche,true);
        return ResponseEntity.ok(result);
    }


    /**
     * 修改公告
     *
     * @param afficheTbl
     * @return
     */
    @ApiOperation(value = "修改公告{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateAffiche", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAffiche(@RequestBody AfficheTbl afficheTbl) {
        service.updateType(afficheTbl,false);
        return ResponseEntity.ok(result);
    }



    /**
     * 修改并发布公告
     *
     * @param afficheTbl
     * @return
     */
    @ApiOperation(value = "修改并发布公告{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "updateAffichePublish", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAffichePublish(@RequestBody AfficheTbl afficheTbl) {
        service.updateType(afficheTbl,true);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除公告
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "删除公告{author:liuxuan}", response = Result.class)
    @RequestMapping(value = "deleteType", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteType(@RequestBody List<String> list ) {
        list.forEach(id->{
            service.deleteType(id);
        });
        return ResponseEntity.ok(result);
    }

}
