package com.mi.model.bean;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
public class User {
	private int userId;
	@Size(min=2, max=20,message="����Ϊ2-10�����ȵ��ǳ�")
	private String userName;//�ǳ�
	private Date userBirth;
	private String userSex;
	@Pattern(regexp="1[3578]\\d{9}",message="*�ֻ��Ÿ�ʽ����ȷ")
	private String userPhone;	
	@Email(message="*�����ʽ����")
	private String userEmail;	
	@Pattern(regexp="\\w{3,16}",message="*����Ϊ3-16λ���֡���ĸ���»������")    //@Pattern ������ʽ    ֻ������String����
	private String userPassword;
	private String userCard;
	private String userHead;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserCard() {
		return userCard;
	}
	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}
	public String getUserHead() {
		return userHead;
	}
	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}
	
	
	
}
