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
	
	//注册用户
	@RequestMapping("addUser.action")	
	public String addUser(@Valid User user,BindingResult errorResult,HttpSession session) {//@Valid校验    错误信息封装到errorResult中        BindingResult必须放在被校验实体类后面，紧挨着实体类		
		Map<String, Object> errorMap = null;
	        boolean flag = errorResult.hasErrors();
	        if (flag) {// 数据有错
	            errorMap = new HashMap<String, Object>();
	            List<FieldError> errorList = errorResult.getFieldErrors();
	            for (FieldError fieldError : errorList) {
	                // 1、获取实体类中的属性名
	                String fieldName = fieldError.getField();
	                // 2、当数据不满足匹配规则时，获取错误提示信息
	                String errorMessage = fieldError.getDefaultMessage();
	                System.out.println(fieldName + "=" + errorMessage);
	                errorMap.put(fieldName, errorMessage);
	            }
	            //需要将错误信息和正确信息传递过去  errorMap只封装错误提示信息
	            session.setAttribute("errorMap", errorMap);
	            //user包含错误信息和正确的数据
	            session.setAttribute("user", user);
	            return "addUser";
	        }else {//数据正确
				userService.addUser(user);
				User user1=userService.login(user);
				
				return "forward:selectUser.action?userId="+user1.getUserId();
	        }				
	}
				
    //登录
	@RequestMapping("login.action")
	public String login(User user, HttpSession session,HttpServletRequest request) {
		String userPhone=user.getUserPhone();
		String userPassword=user.getUserPassword();
		User user1=userService.login(user);
		if(user1!=null&&user1.getUserPhone().equals(userPhone)&&user1.getUserPassword().equals(userPassword)) {
			session.setAttribute("user", user1);
			return "homepage";
		}else {
			request.setAttribute("loginError", "用户名或密码不正确,请重新输入");
			return "login";
		}					
	}
		
	//查询显示个人信息
	@RequestMapping("selectUser.action")
	public String selectUser(Integer userId,HttpSession session) {
		User user=userService.selectUser(userId);
		session.setAttribute("user", user);
		User  u = (User) session.getAttribute("user");
		System.out.println(u.getUserName());
		return "selectUser";	
	}
		
	//查询手机号是否已存在
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
	
	//修改个人信息
	@RequestMapping("updateUser.action")
	public String updateUser(@Valid User user,BindingResult errorResult,HttpSession session,HttpServletRequest request) {
		Map<String, Object> errorMap = null;
        boolean flag = errorResult.hasErrors();
        if (flag) {// 数据有错
            errorMap = new HashMap<String, Object>();
            List<FieldError> errorList = errorResult.getFieldErrors();
            for (FieldError fieldError : errorList) {
                // 1、获取实体类中的属性名
                String fieldName = fieldError.getField();
                // 2、当数据不满足匹配规则时，获取错误提示信息
                String errorMessage = fieldError.getDefaultMessage();
                System.out.println(fieldName + "=" + errorMessage);
                errorMap.put(fieldName, errorMessage);
            }
            //需要将错误信息和正确信息传递过去  errorMap只封装错误提示信息
            request.setAttribute("errorMap", errorMap);
            //user包含错误信息和正确的数据
            session.setAttribute("user", user);
            return "updateUser";
        }else {//数据正确
        	
        	userService.updateUser(user);
        	return "forward:selectUser.action?userId="+user.getUserId();	
        }					
	} 
	
	//上传头像
	@RequestMapping("updateUserHead.action")
	public String headImageUpload(Integer userId,HttpSession session,MultipartFile userHeadImage){
		
		//获取原文件名
		String oldName = userHeadImage.getOriginalFilename();
		//构建新的文件名
		String newName = System.currentTimeMillis() + oldName.substring(oldName.indexOf("."));
		
		File file = new File("d:/data/userpic/",newName);
		//上传
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
			
    //修改密码
	@RequestMapping("updatePassword.action")
	public String updatePassword(Integer userId,String userPassword,String oldPassword,String reUserPassword,HttpSession session,HttpServletRequest request) {	
		if(oldPassword.equals(userService.selectPasswordByUserId(userId))&&userPassword.equals(reUserPassword)) {
			userService.updatePassword(userId, userPassword);
			return "login";
		}else {
			if(!oldPassword.equals(userService.selectPasswordByUserId(userId))) {
				request.setAttribute("oldPasswordMsg", "原始密码有误");	
			}if(!userPassword.equals(reUserPassword)) {
				request.setAttribute("rePasswordMsg", "两次密码不一致");	
			}
			return "updatePassword";
		}			
	}
				
	//退出登录
	@RequestMapping("outLogin.action")
	public String outLogin(HttpSession session) {
		session.removeAttribute("user");
		return "login";	
	}
	
				
}
