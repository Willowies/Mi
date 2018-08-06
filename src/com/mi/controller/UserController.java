package com.mi.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mi.model.bean.User;
import com.mi.model.bean.UserInfo;
import com.mi.model.service.UserService;

public class UserController {
	private UserService userService;
	
	@RequestMapping("selectUser")
	public ModelAndView selectUser(Integer userId) {
		User user = userService.selectUsersById(userId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",user);
		mav.setViewName("selectUser");
		return mav;
	}
	
}