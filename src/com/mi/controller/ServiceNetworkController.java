package com.mi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mi.model.bean.ServiceNetwork;
import com.mi.model.bean.ServiceProduct;
import com.mi.model.service.ServiceNetworkService;
@Controller
@RequestMapping("mi")
public class ServiceNetworkController {

	@Autowired
	private ServiceNetworkService ServiceNetworkService;
	
    @RequestMapping("selectSN.action")
	    public String selectSN(HttpSession session,HttpServletRequest request,Integer spId){
		 String city = request.getParameter("city").toString();
		 String province = request.getParameter("province").toString();
		 int product=0;
		 if (spId == null || spId == 0) {
			product =0;
		}else{
			product = spId;
		}
		 
		 request.setAttribute("city", city);
		 request.setAttribute("province", province);
		 
         List<ServiceNetwork> sns= ServiceNetworkService.selectSN(city,product);
         int ServiceNetworkcount= sns.size();
         request.setAttribute("ServiceNetworkcount", ServiceNetworkcount);
         request.setAttribute("sns", sns);
         
         List<ServiceProduct> sps =ServiceNetworkService.selectAllServiceProducts();
		 request.setAttribute("sps", sps);
		 
	     return "forward:selectServiceNetwork.jsp";

	 
	 }
	 
	 
	 @RequestMapping("selectSP.action")
	 public String selectSP(HttpServletRequest request){
		 String city ="…Ú—Ù –";
		 String province="¡…ƒ˛ °";
		 int product=0;
		 
		 request.setAttribute("city", city);
		 request.setAttribute("province", province);
		 
         List<ServiceNetwork> sns= ServiceNetworkService.selectSN(city,product);
         request.setAttribute("sns", sns);
		 
		 List<ServiceProduct> sps =ServiceNetworkService.selectAllServiceProducts();
		 request.setAttribute("sps", sps);
         return"forward:selectServiceNetwork.jsp";
	 }
}
