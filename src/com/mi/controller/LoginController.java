package com.mi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.User;

@Controller
@RequestMapping("mi")
public class LoginController {
	
	@RequestMapping("checkLoginState")
	public @ResponseBody String checkLoginState(HttpSession session){
		String loginState = "false";
		User user = (User) session.getAttribute("user");
		if(user != null){
			if(user.getUserId() != 0){
				loginState = "true";
			}
		}
		return loginState;
	}
	@RequestMapping("checkLoginState2")
	public @ResponseBody User checkLoginState2(HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user != null){
			if(user.getUserId() != 0){
				return user;
			}
		}
		User userTemp = new User();
		userTemp.setUserId(0);
		return userTemp;
	}

}
