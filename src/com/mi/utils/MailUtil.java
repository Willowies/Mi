package com.mi.utils;

import org.apache.commons.mail.HtmlEmail;

public class MailUtil {
	public static boolean sendEmail(String emailaddress,String code){
		try {
			HtmlEmail email = new HtmlEmail();//���ø���
			email.setHostName("smtp.qq.com");//��Ҫ�޸ģ�126����Ϊsmtp.126.com,163����Ϊ163.smtp.com��QQΪsmtp.qq.com
			email.setCharset("UTF-8");
			email.setSmtpPort(587);
			email.addTo(emailaddress);// �ռ���ַ
 
			email.setFrom("793012567@qq.com", "wanghaowen");//�˴��������ַ���û���,�û�������������д
 
			email.setAuthentication("793012567@qq.com", "wagtmloronhzbdje");//�˴���д�����ַ�Ϳͻ�����Ȩ��
 
			email.setSubject("�ʼ�����");//�˴���д�ʼ������ʼ�����������д
			email.setMsg("�𾴵��û�����,������ע�����֤����:" + code);//�˴���д�ʼ�����
 
			email.send();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
