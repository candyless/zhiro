package com.less.zhiro.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "role_info")
public class RoleInfo {
    @Id
    private Integer roleid;

    private String role;

    private Date createdatetime;

    private Integer delflage;

    /**
     * @return roleid
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return createdatetime
     */
    public Date getCreatedatetime() {
        return createdatetime;
    }

    /**
     * @param createdatetime
     */
    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    /**
     * @return delflage
     */
    public Integer getDelflage() {
        return delflage;
    }

    /**
     * @param delflage
     */
    public void setDelflage(Integer delflage) {
        this.delflage = delflage;
    }
}