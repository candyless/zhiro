package com.less.zhiro.service;

import java.util.List;

import com.less.zhiro.entity.UserInfo;

/**
 * @ClassName: UserInfoSerive
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年3月23日 上午11:32:09
 */
public interface UserInfoService {
   List<UserInfo> select(UserInfo user);
}
