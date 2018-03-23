package com.less.zhiro.service;

import java.util.List;

import com.less.zhiro.entity.JurisdictionInfo;

/**
 * @ClassName: JurisdictionInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年3月23日 上午11:35:58
 */
public interface JurisdictionInfoService {
    List<JurisdictionInfo> getJurisdictionInfo(String sql);
}
