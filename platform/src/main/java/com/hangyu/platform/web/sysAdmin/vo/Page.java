package com.hangyu.platform.web.sysAdmin.vo;

public class Page {

    //总页数
    private int totalPage;
    //总条数
    private int totalSize;

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
