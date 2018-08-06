package com.mi.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.User;
import com.mi.model.bean.UserInfo;
import com.mi.model.dao.UserDAO;
import com.mi.model.dao.UserInfoDAO;



@Service
public class UserService {
			
	@Autowired
	private UserDAO userDAO;
		
	//注册用户
	public void addUser(User user) {		
		userDAO.addUser(user);
	}
	
	//登录
	public User login(User user) {
		return userDAO.selectUserPhoneAndPwd(user);
	}
		
	//查询显示用户个人信息
	public User selectUser(Integer userId) {
		return userDAO.selectUser(userId);		
	}
	
	//查询已注册的用户（手机号）
	public boolean selectUserPhone(String phone) {
		List<User> users = userDAO.selectUserPhone(phone);
		if (users==null || users.size()==0 || users.get(0).getUserId()==0) {
			return true;
		}else {
			return false;
		}		
	}
		
	//组合修改个人信息
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	//上传头像
	public void updateUserHead(Integer userId,String userHead) {
		userDAO.updateUserHead(userId,userHead);
	}
	
	//根据提供的Id拿密码
	public String selectPasswordByUserId(Integer userId) {
		return userDAO.selectPasswordByUserId(userId);
	}
			
	//修改用户的密码
	public void updatePassword(Integer userId, String userPassword) {
		
		userDAO.updatePassword(userId, userPassword);		
	}
	
	
	
}
