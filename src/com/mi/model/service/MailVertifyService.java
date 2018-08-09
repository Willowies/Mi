package com.mi.model.service;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.EmailVertifyCode;
import com.mi.model.dao.MailVertifyDAO;



@Service
public class MailVertifyService {
	@Autowired
	private MailVertifyDAO mailVertifyDAO;
	/*insert每次用户注册都默认调用一次，确保两个表格11对应*/
	public void insertEmailVertifyCode(int userId){
		mailVertifyDAO.insertEmailVertifyCode(userId);
	}
	
	/*将生成的验证码保存，用于安全性验证*/
	public int generateEmailVertifyCode(int userId){
		int vertifyCode = new Random().nextInt(99999);
		EmailVertifyCode emailVertifyCode = new EmailVertifyCode();
		emailVertifyCode.setUserId(userId);
		emailVertifyCode.setVertifyCode(vertifyCode);
		mailVertifyDAO.updateEmailVertifyCode(emailVertifyCode);
		return vertifyCode;
	}
	/*校验代码正确性，如果正确就修改用户的校验状态*/
	public boolean vertifyCodeWhetherCorrect(int userId,int vertifyCode){
		EmailVertifyCode emailVertifyCode = mailVertifyDAO.selectVertifyCode(userId);
		int userVertifyCode = emailVertifyCode.getVertifyCode();
		if(userVertifyCode!=0&&vertifyCode==userVertifyCode) {
			emailVertifyCode.setUserId(userId);
			emailVertifyCode.setVertifyState(1);
		
			mailVertifyDAO.updateEmailVertifyCode(emailVertifyCode);
			return true;
		}
		return false; 
	}
	public int selectVertifyState(int userId){
		return mailVertifyDAO.selectVertifyCode(userId).getVertifyState();
	}
}
