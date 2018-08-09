package com.mi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mi.model.service.MailVertifyService;
import com.mi.utils.MailUtil;

@Controller
@RequestMapping("mi")
public class MailVerificationController {
	@Autowired
	MailVertifyService mailVertifyService;
	
	@RequestMapping("sendVerificationCode")
	public String sendVerificationCode(Integer userId,String emailAddress){
		String vertifyCode = mailVertifyService.generateEmailVertifyCode(userId)+"";//±äÎª×Ö·û´®
		boolean f =  MailUtil.sendEmail(emailAddress,userId,vertifyCode);
		if(f==true) return "forward:sendEmailSuccess.jsp";
		return "forward:sendEmailFail.jsp";
	}
	@RequestMapping("vertifyCodeWhetherCorrect")
	public String vertifyInputCode(Integer userId,@RequestParam(value="vertifyCode",defaultValue="0")int  vertifyCode){
		System.out.println(vertifyCode);
		boolean vertifyFlag = mailVertifyService.vertifyCodeWhetherCorrect(userId,vertifyCode);
		if(vertifyFlag==true){
			return "forward:vertifySuccess.jsp";
		}
		return "forward:vertifyFail.jsp";
	}
}
