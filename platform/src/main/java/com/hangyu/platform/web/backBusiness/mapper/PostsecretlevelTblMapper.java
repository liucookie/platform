package com.hangyu.platform.web.backBusiness.mapper;

import com.hangyu.platform.web.backBusiness.dto.AvidmLevelintegrate;
import com.hangyu.platform.web.backBusiness.dto.PostsecretlevelTbl;
import com.hangyu.platform.web.backBusiness.vo.AvidmQueryVO;
import com.hangyu.platform.web.backBusiness.vo.PostLevelQueryVO;

import java.util.List;


public interface PostsecretlevelTblMapper {


    int deleteByPrimaryKey(String id);

    int insert(PostsecretlevelTbl record);

    PostsecretlevelTbl selectByPrimaryKey(String id);

    List<PostsecretlevelTbl> select(PostLevelQueryVO vo);

    List<PostsecretlevelTbl> selectByUserId(String userId);

    List<PostsecretlevelTbl> queryName(String orgId);

    int selectTotal(PostLevelQueryVO vo);

    int updateByPrimaryKey(PostsecretlevelTbl record);
}