package com.less.zhiro;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.less.zhiro.entity.UserInfo;
import com.less.zhiro.service.UserInfoService;

/**
 * @ClassName: App
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年3月26日 下午2:20:22
 */
public class App {
    public static void main(String[] args) {
    	ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        cxa.start();
        UserInfoService userInfoService = (UserInfoService)cxa.getBean("userInfoService");
       /* List<UserInfo> list = userInfoService.select(null);
        for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getUsername());
		}*/
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(1);
        userInfo.setNickname("nnn");
        userInfoService.updateByPrimaryKey(userInfo);
	}
}
