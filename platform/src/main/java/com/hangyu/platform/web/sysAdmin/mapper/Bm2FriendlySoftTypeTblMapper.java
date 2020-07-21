package com.hangyu.platform.web.sysAdmin.mapper;

import java.util.List;

import com.hangyu.platform.web.sysAdmin.dto.Bm2FriendlySoftTypeTbl;

public interface Bm2FriendlySoftTypeTblMapper {

    //总数据量
    int selectTotal();

    //软件白名单类型管理批量查询
    List<Bm2FriendlySoftTypeTbl> selectAll(int start, int pageSize);

    //软件白名单管理添加
    void  insert(Bm2FriendlySoftTypeTbl bm2FriendlysofttypeTbl);

    //软件白名单管理删除
    void  delete(List<String> list);

    //软件白名单单条查询
    List<Bm2FriendlySoftTypeTbl> select(String typeid);

    //软件白名单管理修改
    void  update(Bm2FriendlySoftTypeTbl bm2FriendlysofttypeTbl);

}