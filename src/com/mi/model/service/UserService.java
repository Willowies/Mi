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
		
	//ע���û�
	public void addUser(User user) {		
		userDAO.addUser(user);
	}
	
	//��¼
	public User login(User user) {
		return userDAO.selectUserPhoneAndPwd(user);
	}
		
	//��ѯ��ʾ�û�������Ϣ
	public User selectUser(Integer userId) {
		return userDAO.selectUser(userId);		
	}
	
	//��ѯ��ע����û����ֻ��ţ�
	public boolean selectUserPhone(String phone) {
		List<User> users = userDAO.selectUserPhone(phone);
		if (users==null || users.size()==0 || users.get(0).getUserId()==0) {
			return true;
		}else {
			return false;
		}		
	}
		
	//����޸ĸ�����Ϣ
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	//�ϴ�ͷ��
	public void updateUserHead(Integer userId,String userHead) {
		userDAO.updateUserHead(userId,userHead);
	}
	
	//�����ṩ��Id������
	public String selectPasswordByUserId(Integer userId) {
		return userDAO.selectPasswordByUserId(userId);
	}
			
	//�޸��û�������
	public void updatePassword(Integer userId, String userPassword) {
		
		userDAO.updatePassword(userId, userPassword);		
	}
	
	
	
}
