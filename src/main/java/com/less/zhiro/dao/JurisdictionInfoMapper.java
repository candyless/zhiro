package com.less.zhiro.dao;

import com.less.zhiro.entity.JurisdictionInfo;
import java.util.List;

public interface JurisdictionInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jurisdiction_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer jurisdictionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jurisdiction_info
     *
     * @mbggenerated
     */
    int insert(JurisdictionInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jurisdiction_info
     *
     * @mbggenerated
     */
    JurisdictionInfo selectByPrimaryKey(Integer jurisdictionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jurisdiction_info
     *
     * @mbggenerated
     */
    List<JurisdictionInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jurisdiction_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(JurisdictionInfo record);
}