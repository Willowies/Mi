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
			email.setSubject("С���̳��ʼ�������ԣ�����ѧ������������������벻Ҫ���ҵ�����лл����");

			/*email.setMsg("�𾴵��û�����,�����ڽ���С���̳��������֤:\n����Ǳ��˲����뵥�����ӣ�������ӱ��ʼ���\n" + 
			"<a href=\" "+linkUrl+">����˴�������֤</a>");*/
			 StringBuffer sf=new StringBuffer();
		        sf.append("<a href=\"http://localhost:8099/Mi/mi/vertifyCodeWhetherCorrect.action?userId=");
	 	        sf.append(userId);
		        sf.append("&vertifyCode=");
		        sf.append(code);
		        sf.append("\">");
		        sf.append(" <FONT   face=\"MS   UI   Gothic\"   size=\"3\"><b>�������</b></FONT>");
		        sf.append("</a>");
		        sf.append("����С���̳��ʼ�������Լ����˺ţ�24Сʱ��Ч������������֤���뾡�켤�<br>");
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
