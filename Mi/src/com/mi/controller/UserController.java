package com.mi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mi.model.bean.UserInfo;
import com.mi.model.service.UserService;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("selectUser")
	public ModelAndView selectUser() {
		List<UserInfo> list = userService.selectUsers();
		ModelAndView mav = new ModelAndView();
		mav.addObject("resultList",list);
		mav.setViewName("selectUser");
		return mav;
	}
	
}
