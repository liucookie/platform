package com.hangyu.platform.web.backBusiness.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.List;

public class TblTest {
    private Integer id;
    @Excel(name = "题目", width = 80, orderNum = "2")
    private String testcontent;

    private String createtime;
    @Excel(name = "类型", width = 10, orderNum = "1")
    private String type;
    @Excel(name = "选项", width = 50, orderNum = "3")
    private String foranswers;
    @Excel(name = "答案", width = 50, orderNum = "4")
    private String rightanswer;

    private Integer usecount;

    private Integer isdelete;

    private Integer original;

    //选项
    private List<String> options;

    //正确答案
    private List<String> rightAnswer;

    //分数
    private int score;

    private boolean flag;

    //员工此题的答案
    private String userReplyAnswer;

    public String getUserReplyAnswer() {
        return userReplyAnswer;
    }

    public void setUserReplyAnswer(String userReplyAnswer) {
        this.userReplyAnswer = userReplyAnswer;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(List<String> rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestcontent() {
        return testcontent;
    }

    public void setTestcontent(String testcontent) {
        this.testcontent = testcontent == null ? null : testcontent.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getForanswers() {
        return foranswers;
    }

    public void setForanswers(String foranswers) {
        this.foranswers = foranswers == null ? null : foranswers.trim();
    }

    public String getRightanswer() {
        return rightanswer;
    }

    public void setRightanswer(String rightanswer) {
        this.rightanswer = rightanswer == null ? null : rightanswer.trim();
    }

    public Integer getUsecount() {
        return usecount;
    }

    public void setUsecount(Integer usecount) {
        this.usecount = usecount;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getOriginal() {
        return original;
    }

    public void setOriginal(Integer original) {
        this.original = original;
    }
}