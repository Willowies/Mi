package com.mi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mi.model.bean.ReceivingPoint;
import com.mi.model.service.ReceivingPointService;

@Controller
@RequestMapping("mi")
public class ReceivingPointController {

	@Autowired
	private ReceivingPointService receivingPointService;
	
    @RequestMapping("selectRP.action")
    
    public String selectRP(HttpSession session,HttpServletRequest request){
    	String city = (String)request.getParameter("city");
    	String province=(String)request.getParameter("province");
    	
    	List<ReceivingPoint> rps = receivingPointService.selectRP(city);
    	request.setAttribute("city", city);
    	request.setAttribute("province", province);
    	request.setAttribute("rps", rps);
    	return "forward:selectReceivingPoint.jsp";
		
    	
    }
	
	
}
