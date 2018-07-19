package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.UserInfo;


public interface UserInfoDAO {
	
	public List<UserInfo> selectUsers();
}
