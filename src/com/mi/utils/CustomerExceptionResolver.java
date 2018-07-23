package com.mi.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomerExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception ex) {
		CustomerException customerException;
		if (ex instanceof CustomerException) {
			customerException = (CustomerException) ex;
		}else {
			customerException = new CustomerException("Õ¯¬Á“Ï≥£");
		}
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("errorMessage",customerException.getMessage());
		mav.setViewName("forward:/error.jsp");
		return mav;
	}
	
	
	
}
