package com.mi.utils;

import org.apache.commons.mail.HtmlEmail;

public class MailUtil {
	public static boolean sendEmail(String emailaddress,int userId,String code){
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName("smtp.sina.com");
			email.setCharset("UTF-8");
			email.addTo(emailaddress);
			email.setFrom("zhouneuedu@sina.com", "zhouneuedu@sina.com");
			email.setAuthentication("zhouneuedu@sina.com", "asdzxc321");
			email.setSubject("小米商城邮件激活测试（本人学生，开发测试软件，请不要封我的邮箱谢谢！）");

			/*email.setMsg("尊敬的用户您好,您正在进行小米商城邮箱绑定验证:\n如果是本人操作请单击链接，否则忽视本邮件。\n" + 
			"<a href=\" "+linkUrl+">点击此处进行验证</a>");*/
			 StringBuffer sf=new StringBuffer();
		        sf.append("<a href=\"http://localhost:8099/Mi/mi/vertifyCodeWhetherCorrect.action?userId=");
	 	        sf.append(userId);
		        sf.append("&vertifyCode=");
		        sf.append(code);
		        sf.append("\">");
		        sf.append(" <FONT   face=\"MS   UI   Gothic\"   size=\"3\"><b>点击这里</b></FONT>");
		        sf.append("</a>");
		        sf.append("这是小米商城邮件激活测试激活账号，24小时生效，否则重新验证，请尽快激活！<br>");
		        email.setMsg(sf.toString());
			System.out.println(emailaddress);
			email.send();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
