package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.User;

public interface UserDAO {

	//用户注册
	public void addUser(User user);
	//登录
	public User selectUserPhoneAndPwd(User user);
	//查询显示用户个人信息
	public User selectUser(Integer userId);
	//查询已注册的用户（手机号）
	public List<User> selectUserPhone(String phone);
	//组合修改个人信息
	public void updateUser(User user);
	//上传头像
	public void updateUserHead(Integer userId,String userHead);
	//根据提供的Id拿密码
	public String selectPasswordByUserId(Integer userId);
	//修改密码	
	public int updatePassword(Integer userId, String userPassword);
		
	
}
