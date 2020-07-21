package com.hangyu.platform.web.backBusiness.dto;

import com.hangyu.platform.web.backBusiness.vo.AddExamVO;


public class TblExam {
    private Integer id;

    private String name;

    private String applytime;

    private Integer classifyid;

    private String jsoncontent;

    private Integer usecount;

    private Integer score;

    private Integer isoriginal;

    private AddExamVO examVO;

    public Integer getIsoriginal() {
        return isoriginal;
    }

    public void setIsoriginal(Integer isoriginal) {
        this.isoriginal = isoriginal;
    }



    public AddExamVO getExamVO() {
        return examVO;
    }

    public void setExamVO(AddExamVO examVO) {
        this.examVO = examVO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public Integer getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(Integer classifyid) {
        this.classifyid = classifyid;
    }

    public String getJsoncontent() {
        return jsoncontent;
    }

    public void setJsoncontent(String jsoncontent) {
        this.jsoncontent = jsoncontent == null ? null : jsoncontent.trim();
    }

    public Integer getUsecount() {
        return usecount;
    }

    public void setUsecount(Integer usecount) {
        this.usecount = usecount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}