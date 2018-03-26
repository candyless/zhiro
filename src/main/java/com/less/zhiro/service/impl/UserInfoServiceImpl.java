package com.less.zhiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.less.zhiro.dao.UserInfoMapper;
import com.less.zhiro.entity.UserInfo;
import com.less.zhiro.service.UserInfoService;

/**
 * @ClassName: UserInfoServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年3月23日 上午11:33:30
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
    private UserInfoMapper userInfoMapper;
   
	public List<UserInfo> select(UserInfo user) {
		List<UserInfo> userInfo = userInfoMapper.select(user);
		return userInfo;
	}

	/* (non-Javadoc)
	 * @see com.less.zhiro.service.UserInfoService#updateByPrimaryKey(com.less.zhiro.entity.UserInfo)
	 */
	public int updateByPrimaryKey(UserInfo record) {
		return userInfoMapper.updateByPrimaryKey(record);
	}

}
