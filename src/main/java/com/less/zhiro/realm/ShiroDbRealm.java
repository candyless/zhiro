package com.less.zhiro.realm;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.less.zhiro.entity.JurisdictionInfo;
import com.less.zhiro.entity.UserInfo;
import com.less.zhiro.service.JurisdictionInfoService;
import com.less.zhiro.service.UserInfoService;

public class ShiroDbRealm extends AuthorizingRealm  {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShiroDbRealm.class);
	
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private JurisdictionInfoService jurisdictionInfoService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		AuthenticationInfo authcInfo = null;
		try {
			//获取基于用户名和密码的令牌  
			//实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的  
			//两个token的引用都是一样的
			UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(token.getUsername());
			userInfo.setDelflage(0);
		    List<UserInfo> userInfoList = userInfoService.select(userInfo);
			if(userInfoList.size() > 0){
				String userName = userInfoList.get(0).getUsername();
				
				//处理session
		        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
		        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
//		        单用户登录
		        for(Session session : sessions){
		            //清除该用户以前登录时保存的session
		            if(userName.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
		                sessionManager.getSessionDAO().delete(session);
		            }
		        }
				authcInfo = new SimpleAuthenticationInfo(userInfoList.get(0).getUsername(), userInfoList.get(0).getPassword(), userName);  
				setSession("userid", userInfoList.get(0).getUserid());
			}
		} catch (Exception e) {
			LOG.error("Exception:",e);
		}
		return authcInfo;  
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName = principals.toString();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (userName != null) {
			String sql = "";
			if ("admin".equals(userName)) {
				sql = "SELECT jurisdictionid,menuid,auth,`comment`,parent FROM jurisdiction_info;";
			} else {
				sql = "SELECT jurisdictionid,menuid,auth,`comment`,parent FROM jurisdiction_info WHERE jurisdictionid IN (SELECT parent FROM jurisdiction_info WHERE jurisdictionid IN (SELECT jurisdictionid FROM role_jurisdiction WHERE roleid IN (SELECT roleid FROM user_role WHERE userid = (SELECT userid FROM user_info WHERE username = '"+userName+"' AND delflage = 0)))) OR jurisdictionid IN (SELECT jurisdictionid FROM jurisdiction_info WHERE jurisdictionid IN (SELECT jurisdictionid FROM role_jurisdiction WHERE roleid IN (SELECT roleid FROM user_role WHERE userid = (SELECT userid FROM user_info WHERE username = '"+userName+"' AND delflage = 0))) AND parent != 0);";
			}
			List<JurisdictionInfo> jurisdictionInfos = jurisdictionInfoService.getJurisdictionInfo(sql);
			for (int i = 0; i < jurisdictionInfos.size(); i++) {
				String auth = jurisdictionInfos.get(i).getAuth().substring(1).replace("/", ":");
				info.addStringPermission(auth);
			}
		}
		return info;
	}
	
	/** 
	 * 将一些数据放到ShiroSession中,以便于其它地方使用 
	 * @see  比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
	 */
	private void setSession(Object key, Object value){  
		Subject currentUser = SecurityUtils.getSubject();  
		if(null != currentUser){  
			Session session = currentUser.getSession();  
			if(null != session){  
				session.setAttribute(key, value);  
			}  
		}  
	}
}
