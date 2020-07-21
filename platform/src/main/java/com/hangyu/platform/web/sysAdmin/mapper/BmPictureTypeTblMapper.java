package com.hangyu.platform.web.sysAdmin.mapper;
import java.util.List;

import com.hangyu.platform.web.sysAdmin.dto.BmPicturetypeTbl;

//图片资源类别管理
public interface BmPictureTypeTblMapper {

    //总数据量
    int selectTotal();

    //图片资源类别管理批量查询
    List<BmPicturetypeTbl> selectAll(int start, int pageSize);

    //图片资源类别管理单条查询
    List<BmPicturetypeTbl> select(String uniqueid);

    //图片资源类别管理添加
    void  insert(BmPicturetypeTbl bmPicturetypeTbl);

    //图片资源类别管理删除
    void  delete(List<String> list);

    //图片资源类别管理删修改
    void  update(BmPicturetypeTbl bmPicturetypeTbl);

}