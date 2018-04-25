package com.less.zhiro.entity;

import javax.persistence.*;

@Table(name = "jurisdiction_info")
public class JurisdictionInfo {
    @Id
    private Integer jurisdictionid;

    private Integer menuid;

    private String auth;

    private String comment;

    private Integer parent;

    /**
     * @return jurisdictionid
     */
    public Integer getJurisdictionid() {
        return jurisdictionid;
    }

    /**
     * @param jurisdictionid
     */
    public void setJurisdictionid(Integer jurisdictionid) {
        this.jurisdictionid = jurisdictionid;
    }

    /**
     * @return menuid
     */
    public Integer getMenuid() {
        return menuid;
    }

    /**
     * @param menuid
     */
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    /**
     * @return auth
     */
    public String getAuth() {
        return auth;
    }

    /**
     * @param auth
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return parent
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * @param parent
     */
    public void setParent(Integer parent) {
        this.parent = parent;
    }
}