package com.mi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.GroupProduct;
import com.mi.model.bean.Product;
import com.mi.model.bean.ProductFirstClass;
import com.mi.model.bean.ProductSecondClass;
import com.mi.model.bean.SpikeProduct;
import com.mi.model.bean.User;
import com.mi.model.service.BackgroundManageService;
import com.mi.model.service.SearchService;
import com.mi.utils.BaseController;

@Controller
@RequestMapping("mi")
public class BackgroundManageController extends BaseController{
	@Autowired
	private BackgroundManageService backgroundManageService;
	
	@RequestMapping("getSpikeProductByTime")
	public String getSpikeProductByTime(HttpSession session, HttpServletRequest request,Date date,String time) {
		
		long t = Integer.parseInt(time)*1000*60*60;
		Date d = new Date(date.getTime()+t);
		
		Map<String, Object> map = backgroundManageService.getSpikeProductByTime(d);
		List<SpikeProduct> products = (List<SpikeProduct>) map.get("list");
		
		for (SpikeProduct p : products) {
			p.setProductName(p.getProductName() + (p.getSize()==null?"":" "+p.getSize()) + (p.getVersion()==null?"":" "+p.getVersion())+" "+p.getColor());
		}
		
		request.setAttribute("state", d.after(new Date())?"ableChange":"unableChange");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		request.setAttribute("date", format.format(date));
		request.setAttribute("time", time);
		request.setAttribute("productList", products);
		return "forward:setSpikeProduct.jsp";
	}
	
	@RequestMapping("getGroupProduct")
	public String getGroupProduct(HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = backgroundManageService.getGroupProduct();
		List<GroupProduct> products = (List<GroupProduct>) map.get("list");
		
		for (GroupProduct p : products) {
			p.getProduct().setExtremeName(p.getProduct().getProductName() + (p.getProduct().getSize()==null?"":" "+p.getProduct().getSize()) + (p.getProduct().getVersion()==null?"":" "+p.getProduct().getVersion())+" "+p.getProduct().getColor());
		}
		
		request.setAttribute("productList", products);
		return "forward:setSpikeProduct.jsp";
	}
	
	@RequestMapping("getProductFirstClassInManage")
	public @ResponseBody List<ProductFirstClass> getProductFirstClassInManage(HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = backgroundManageService.getProductFirstClass();
		List<ProductFirstClass> list = (List<ProductFirstClass>) map.get("list");
		
		return list;
	}
	
	@RequestMapping("getProductSecondClassInManage")
	public @ResponseBody List<ProductSecondClass> getProductSecondClassInManage(HttpSession session, HttpServletRequest request,Integer id) {
		
		if (id==null || id==0) {
			return null;
		}
		
		Map<String, Object> map = backgroundManageService.getProductSecondClass(id);
		List<ProductSecondClass> list = (List<ProductSecondClass>) map.get("list");
		
		return list;
	}
	
	@RequestMapping("getProductInManage")
	public @ResponseBody List<Product> getProductInManage(HttpSession session, HttpServletRequest request,Integer id) {
		
		if (id==null || id==0) {
			return null;
		}
		
		Map<String, Object> map = backgroundManageService.getProductBySecondClassId(id);
		List<Product> list = (List<Product>) map.get("list");
		
		for (Product p : list) {
			p.setExtremeName(p.getProductName() + (p.getSize()==null?"":" "+p.getSize()) + (p.getVersion()==null?"":" "+p.getVersion())+" "+p.getColor());
		}
		
		return list;
	}
	
	@RequestMapping("getProductInfoInManageByTime")
	public @ResponseBody List<Product> getProductInfoInManageByTime(HttpSession session, HttpServletRequest request,Integer id,Date date,String time) {
		
		if (id==null || id==0) {
			return null;
		}
		
		long t = Integer.parseInt(time)*1000*60*60;
		Date d = new Date(date.getTime()+t);
		
		Map<String, Object> map = backgroundManageService.getProductBySecondClassIdAndTime(id,d);
		List<Product> list = (List<Product>) map.get("list");
		
		for (Product p : list) {
			p.setExtremeName(p.getProductName() + (p.getSize()==null?"":" "+p.getSize()) + (p.getVersion()==null?"":" "+p.getVersion())+" "+p.getColor());
		}
		
		return list;
	}
	
	@RequestMapping("getProductInfoInManage")
	public @ResponseBody Product getProductInfoInManage(HttpSession session, HttpServletRequest request,Integer id) {
		
		if (id==null || id==0) {
			return null;
		}
		
		Product p= backgroundManageService.getProductById(id);
		p.setExtremeName(p.getProductName() + (p.getSize()==null?"":" "+p.getSize()) + (p.getVersion()==null?"":" "+p.getVersion())+" "+p.getColor());

		
		return p;
	}
	
	@RequestMapping("setProductStock")
	public @ResponseBody Product setProductStock(HttpSession session, HttpServletRequest request,Integer productId,Integer stock) {
		
		if (productId==null || productId==0) {
			return null;
		}
		if (stock==null || stock==0) {
			return null;
		}
		
		Product p= backgroundManageService.addProductStock(stock,productId);
		p.setExtremeName(p.getProductName() + (p.getSize()==null?"":" "+p.getSize()) + (p.getVersion()==null?"":" "+p.getVersion())+" "+p.getColor());

		
		return p;
	}
	
	@RequestMapping("addSpikeProduct")
	public String addSpikeProduct(HttpSession session, HttpServletRequest request,SpikeProduct p,Date date,String time) {
		
		if (p==null || p.getProductId()==0) {
			request.setAttribute("alertMsg", "添加失败");
			return getSpikeProductByTime(session, request, date, time);
		}
		long t = Integer.parseInt(time)*1000*60*60;
		Date d = new Date(date.getTime()+t);
		Date end = new Date(date.getTime()+t+1000*60*60);
		
		p.setStartTime(d);
		p.setEndTime(end);
		p.setSpikeStatus(1);
		p.setCurrentSpikeNum(0);
		
		backgroundManageService.addSpikeProduct(p);
		
		request.setAttribute("alertMsg", "添加成功");
		return getSpikeProductByTime(session, request, date, time);
	}
	
	@RequestMapping("modifySpikeProduct")
	public String modifySpikeProduct(HttpSession session, HttpServletRequest request,SpikeProduct p,Date date,String time) {
		
		if (p==null || p.getSpikeProductId()==0) {
			request.setAttribute("alertMsg", "修改失败");
			return getSpikeProductByTime(session, request, date, time);
		}
		
		backgroundManageService.modifySpikeProduct(p);
		
		request.setAttribute("alertMsg", "修改成功");
		return getSpikeProductByTime(session, request, date, time);
	}
	
	@RequestMapping("deleteSpikeProduct")
	public String deleteSpikeProduct(HttpSession session, HttpServletRequest request,SpikeProduct p,Date date,String time) {
		
		if (p==null || p.getSpikeProductId()==0) {
			request.setAttribute("alertMsg", "删除失败");
			return getSpikeProductByTime(session, request, date, time);
		}
		
		backgroundManageService.deleteSpikeProduct(p);
		
		request.setAttribute("alertMsg", "删除成功");
		return getSpikeProductByTime(session, request, date, time);
	}
	
	@RequestMapping("addGroupProduct")
	public String addGroupProduct(HttpSession session, HttpServletRequest request,GroupProduct p) {
		
		if (p==null || p.getProduct().getProductId()==0) {
			request.setAttribute("alertMsg", "添加失败");
			return getGroupProduct(session, request);
		}

		backgroundManageService.addGroupProduct(p);
		
		request.setAttribute("alertMsg", "添加成功");
		return getGroupProduct(session, request);
	}
	
	@RequestMapping("modifyGroupProduct")
	public String modifyGroupProduct(HttpSession session, HttpServletRequest request,GroupProduct p) {
		
		if (p==null || p.getGroupProductId()==0) {
			request.setAttribute("alertMsg", "修改失败");
			return getGroupProduct(session, request);
		}
		
		backgroundManageService.modifyGroupProduct(p);
		
		request.setAttribute("alertMsg", "修改成功");
		return getGroupProduct(session, request);
	}
	
	@RequestMapping("deleteGroupProduct")
	public String deleteGroupProduct(HttpSession session, HttpServletRequest request,GroupProduct p) {
		
		if (p==null || p.getGroupProductId()==0) {
			request.setAttribute("alertMsg", "删除失败");
			return getGroupProduct(session, request);
		}
		
		backgroundManageService.deleteGroupProduct(p);
		
		request.setAttribute("alertMsg", "删除成功");
		return getGroupProduct(session, request);
	}
	
	
}
