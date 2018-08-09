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
	/*insertÿ���û�ע�ᶼĬ�ϵ���һ�Σ�ȷ���������11��Ӧ*/
	public void insertEmailVertifyCode(int userId){
		mailVertifyDAO.insertEmailVertifyCode(userId);
	}
	
	/*�����ɵ���֤�뱣�棬���ڰ�ȫ����֤*/
	public int generateEmailVertifyCode(int userId){
		int vertifyCode = new Random().nextInt(99999);
		EmailVertifyCode emailVertifyCode = new EmailVertifyCode();
		emailVertifyCode.setUserId(userId);
		emailVertifyCode.setVertifyCode(vertifyCode);
		mailVertifyDAO.updateEmailVertifyCode(emailVertifyCode);
		return vertifyCode;
	}
	/*У�������ȷ�ԣ������ȷ���޸��û���У��״̬*/
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
