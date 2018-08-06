package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.User;

public interface UserDAO {

	//�û�ע��
	public void addUser(User user);
	//��¼
	public User selectUserPhoneAndPwd(User user);
	//��ѯ��ʾ�û�������Ϣ
	public User selectUser(Integer userId);
	//��ѯ��ע����û����ֻ��ţ�
	public List<User> selectUserPhone(String phone);
	//����޸ĸ�����Ϣ
	public void updateUser(User user);
	//�ϴ�ͷ��
	public void updateUserHead(Integer userId,String userHead);
	//�����ṩ��Id������
	public String selectPasswordByUserId(Integer userId);
	//�޸�����	
	public int updatePassword(Integer userId, String userPassword);
		
	
}
