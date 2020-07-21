package com.hangyu.platform.web.sysAdmin.dto;

import java.util.Date;

public class AfficheTbl {
    private Integer id;

    private String uniqueid;

    private String affichetitle;

    private String affichetime;

    private String editor;

    private String affichesource;

    private String userid;

    private Integer isdelete;

    private Integer ispublish;

    private Integer openmode;

    private Integer width;

    private Integer height;

    private String affichecontent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public String getAffichetitle() {
        return affichetitle;
    }

    public void setAffichetitle(String affichetitle) {
        this.affichetitle = affichetitle == null ? null : affichetitle.trim();
    }

    public String getAffichetime() {
        return affichetime;
    }

    public void setAffichetime(String affichetime) {
        this.affichetime = affichetime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public String getAffichesource() {
        return affichesource;
    }

    public void setAffichesource(String affichesource) {
        this.affichesource = affichesource == null ? null : affichesource.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getIspublish() {
        return ispublish;
    }

    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }

    public Integer getOpenmode() {
        return openmode;
    }

    public void setOpenmode(Integer openmode) {
        this.openmode = openmode;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAffichecontent() {
        return affichecontent;
    }

    public void setAffichecontent(String affichecontent) {
        this.affichecontent = affichecontent == null ? null : affichecontent.trim();
    }
}