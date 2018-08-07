package com.mi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mi.model.bean.ServiceProduct;
import com.mi.model.service.ServiceNetworkService;
@Controller
@RequestMapping("mi")
public class ServiceNetworkController {

	@Autowired
	private ServiceNetworkService ServiceNetworkService;
	
	/* @RequestMapping("selectSN.action")
	    public String selectSN(HttpSession session,HttpServletRequest request){
		 String city = request.getAttribute("snCity").toString();
		 String product = request.getAttribute("snProduct").toString();
		 city="…Ú—Ù –";
		 product=" ÷ª˙";
         List<ServiceNetwork> sns= ServiceNetworkService.selectSN(city,product);
		 sn.setSnAddress("dfdsafd");
		 sn.setSnName("afdsaf");
		 System.out.println(city);
		 sns.add(sn);
		 request.setAttribute("sns", sns);
	     return "forward:selectServiceNetwork.jsp";

	 
	 }
	 */
	 
	 @RequestMapping("selectSP.action")
	 public String selectSP(HttpServletRequest request){
		 List<ServiceProduct> sps =ServiceNetworkService.selectAllServiceProducts();
		 request.setAttribute("sps", sps);
         return"forward:selectServiceNetwork.jsp";
	 }
}
