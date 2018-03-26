package com.less.zhiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: LoginController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年3月23日 上午9:57:58
 */
@Controller
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		  String username =  request.getParameter("username");
		  String password =  request.getParameter("password");
		  Subject currentUser = SecurityUtils.getSubject();
		  Session session = currentUser.getSession();
		  System.out.println(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
		  System.out.println("登录用户" + session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
		  if (!currentUser.isAuthenticated()) {
	            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	            token.setRememberMe(true);
	            try {
	                currentUser.login(token);
	            } catch (UnknownAccountException uae) {
	                log.info("There is no user with username of " + token.getPrincipal());
	            } catch (IncorrectCredentialsException ice) {
	                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
	            } catch (LockedAccountException lae) {
	                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
	                        "Please contact your administrator to unlock it.");
	            }
	            // ... catch more exceptions here (maybe custom ones specific to your application?
	            catch (AuthenticationException ae) {
	                //unexpected condition?  error?
	            }
	            System.out.println("1"+DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
	  		    System.out.println("1登录用户" + session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
	            return "success";
	            
	        }
		  return "error";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		 
		return "index";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		 
		return "home";
	}
}
