package com.mi.model.dao;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.EmailVertifyCode;

public interface MailVertifyDAO {
	public EmailVertifyCode selectVertifyCode(@Param(value="userId")int userId);
	public void updateEmailVertifyCode(EmailVertifyCode emailVertifyCode);
	public void insertEmailVertifyCode(@Param(value="userId")int userId);
}
