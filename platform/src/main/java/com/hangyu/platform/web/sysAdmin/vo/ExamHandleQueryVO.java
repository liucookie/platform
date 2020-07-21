package com.hangyu.platform.web.sysAdmin.vo;

public class ExamHandleQueryVO {

    private int pageNum;
    private int pageSize;
    private String type;
    private String handleContent;
    private double scoreStart;
    private double scoreBegin;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHandleContent() {
        return handleContent;
    }

    public void setHandleContent(String handleContent) {
        this.handleContent = handleContent;
    }

    public double getScoreStart() {
        return scoreStart;
    }

    public void setScoreStart(double scoreStart) {
        this.scoreStart = scoreStart;
    }

    public double getScoreBegin() {
        return scoreBegin;
    }

    public void setScoreBegin(double scoreBegin) {
        this.scoreBegin = scoreBegin;
    }
}
