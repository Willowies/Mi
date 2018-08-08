package com.mi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mi.utils.MailUtil;

@Controller
@RequestMapping("mi")
public class MailVerificationController {
	@RequestMapping("sendVerificationCode")
	public void sendVerificationCode(){
		boolean f =  MailUtil.sendEmail("654714845@qq.com", "123456");
		System.out.println(f);
		System.out.println("·¢ËÍ³É¹¦");
	}
}
