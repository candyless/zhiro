package com.less.zhiro.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    @Id
    private Integer userid;

    private String username;

    private String password;

    private String nickname;

    private String phone;

    private Integer photoid;

    private Date createdatetime;

    private Integer delflage;

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return photoid
     */
    public Integer getPhotoid() {
        return photoid;
    }

    /**
     * @param photoid
     */
    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
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