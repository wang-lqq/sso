package com.bingguo.sso.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingguo.sso.domain.User;
import com.bingguo.sso.service.UserService;
import com.bingguo.sso.util.MD5;
import com.bingguo.sso.util.RedisComponent;
/**
 * 用户统一登录接口
 * @author v001
 *
 */
@Controller
@RequestMapping("sso")
public class LoginController {
	@Autowired
	RedisComponent redisComponent;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response) {
		try {
			String sign="wzw_123";
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if(username==null || "".equals(username) || password==null || "".equals(password)) {
				return "用户名和密码不能为空";
			}
			User user=userService.selectByUsername(username.trim());
			if(user==null) {
				return "用户名或密码错误";
			}
			if(!user.getPassword().equals(password.trim())) {
				return "用户名或密码错误";
			}else {
				//登录成功
				//生成token,并返回给客户端
				String key=MD5.getMd5(user.getPassword()+user.getUsername()+sign);
				redisComponent.set("wl", "l");
				return key;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
