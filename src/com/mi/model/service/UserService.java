package com.mi.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.UserInfo;
import com.mi.model.dao.UserInfoDAO;



@Service
public class UserService {
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	public List<UserInfo> selectUsers(){
		return userInfoDAO.selectUsers();
	}
}
