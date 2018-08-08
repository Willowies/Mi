package com.mi.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mi.model.bean.User;
import com.mi.model.bean.UserInfo;
import com.mi.model.service.UserService;
import com.mi.utils.BaseController;




@Controller
@RequestMapping("mi")
public class UserController extends BaseController {
		
	@Autowired	
	private UserService userService;
	
	//ע���û�
	@RequestMapping("addUser.action")	
	public String addUser(@Valid User user,BindingResult errorResult,HttpSession session) {//@ValidУ��    ������Ϣ��װ��errorResult��        BindingResult������ڱ�У��ʵ������棬������ʵ����		
		Map<String, Object> errorMap = null;
	        boolean flag = errorResult.hasErrors();
	        if (flag) {// �����д�
	            errorMap = new HashMap<String, Object>();
	            List<FieldError> errorList = errorResult.getFieldErrors();
	            for (FieldError fieldError : errorList) {
	                // 1����ȡʵ�����е�������
	                String fieldName = fieldError.getField();
	                // 2�������ݲ�����ƥ�����ʱ����ȡ������ʾ��Ϣ
	                String errorMessage = fieldError.getDefaultMessage();
	                System.out.println(fieldName + "=" + errorMessage);
	                errorMap.put(fieldName, errorMessage);
	            }
	            //��Ҫ��������Ϣ����ȷ��Ϣ���ݹ�ȥ  errorMapֻ��װ������ʾ��Ϣ
	            session.setAttribute("errorMap", errorMap);
	            //user����������Ϣ����ȷ������
	            session.setAttribute("user", user);
	            return "addUser";
	        }else {//������ȷ
				userService.addUser(user);
				User user1=userService.login(user);
				
				return "forward:selectUser.action?userId="+user1.getUserId();
	        }				
	}
				
    //��¼
	@RequestMapping("login.action")
	public String login(User user, HttpSession session,HttpServletRequest request) {
		String userPhone=user.getUserPhone();
		String userPassword=user.getUserPassword();
		User user1=userService.login(user);
		if(user1!=null&&user1.getUserPhone().equals(userPhone)&&user1.getUserPassword().equals(userPassword)) {
			session.setAttribute("user", user1);
			return "homepage";
		}else {
			request.setAttribute("loginError", "�û��������벻��ȷ,����������");
			return "login";
		}					
	}
		
	//��ѯ��ʾ������Ϣ
	@RequestMapping("selectUser.action")
	public String selectUser(Integer userId,HttpSession session) {
		User user=userService.selectUser(userId);
		session.setAttribute("user", user);
		User  u = (User) session.getAttribute("user");
		System.out.println(u.getUserName());
		return "selectUser";	
	}
		
	//��ѯ�ֻ����Ƿ��Ѵ���
	@RequestMapping("selectUserPhone.action")
	public @ResponseBody boolean  selectUserPhone(String userPhone) {
		if (userPhone==null || userPhone.equals("")) {
			return false;
		}
		if(userService.selectUserPhone(userPhone)) {
			return true;
		}else {
			return false;
		}			
	}
	
	//�޸ĸ�����Ϣ
	@RequestMapping("updateUser.action")
	public String updateUser(@Valid User user,BindingResult errorResult,HttpSession session,HttpServletRequest request) {
		Map<String, Object> errorMap = null;
        boolean flag = errorResult.hasErrors();
        if (flag) {// �����д�
            errorMap = new HashMap<String, Object>();
            List<FieldError> errorList = errorResult.getFieldErrors();
            for (FieldError fieldError : errorList) {
                // 1����ȡʵ�����е�������
                String fieldName = fieldError.getField();
                // 2�������ݲ�����ƥ�����ʱ����ȡ������ʾ��Ϣ
                String errorMessage = fieldError.getDefaultMessage();
                System.out.println(fieldName + "=" + errorMessage);
                errorMap.put(fieldName, errorMessage);
            }
            //��Ҫ��������Ϣ����ȷ��Ϣ���ݹ�ȥ  errorMapֻ��װ������ʾ��Ϣ
            request.setAttribute("errorMap", errorMap);
            //user����������Ϣ����ȷ������
            session.setAttribute("user", user);
            return "updateUser";
        }else {//������ȷ
        	
        	userService.updateUser(user);
        	return "forward:selectUser.action?userId="+user.getUserId();	
        }					
	} 
	
	//�ϴ�ͷ��
	@RequestMapping("updateUserHead.action")
	public String headImageUpload(Integer userId,HttpSession session,MultipartFile userHeadImage){
		
		//��ȡԭ�ļ���
		String oldName = userHeadImage.getOriginalFilename();
		//�����µ��ļ���
		String newName = System.currentTimeMillis() + oldName.substring(oldName.indexOf("."));
		
		File file = new File("d:/data/userpic/",newName);
		//�ϴ�
		try {
			userHeadImage.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
		String userHead="userpic/"+newName;
		userService.updateUserHead(userId,userHead);
		return "forward:selectUser.action";
	}
			
    //�޸�����
	@RequestMapping("updatePassword.action")
	public String updatePassword(Integer userId,String userPassword,String oldPassword,String reUserPassword,HttpSession session,HttpServletRequest request) {	
		if(oldPassword.equals(userService.selectPasswordByUserId(userId))&&userPassword.equals(reUserPassword)) {
			userService.updatePassword(userId, userPassword);
			return "login";
		}else {
			if(!oldPassword.equals(userService.selectPasswordByUserId(userId))) {
				request.setAttribute("oldPasswordMsg", "ԭʼ��������");	
			}if(!userPassword.equals(reUserPassword)) {
				request.setAttribute("rePasswordMsg", "�������벻һ��");	
			}
			return "updatePassword";
		}			
	}
				
	//�˳���¼
	@RequestMapping("outLogin.action")
	public String outLogin(HttpSession session) {
		session.removeAttribute("user");
		return "login";	
	}
	
				
}
