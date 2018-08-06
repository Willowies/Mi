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
	
	
	/**   
	* ͨ�����ڵõ��ó��ε�������Ʒ��Ϣ
	*/
	@RequestMapping("getSpikeProductByTime")
	public String getSpikeProductByTime(HttpSession session, HttpServletRequest request,Date date,String time) {
		
		long t = Integer.parseInt(time)*1000*60*60;
		Date d = new Date(date.getTime()+t);
		
		Map<String, Object> map = backgroundManageService.getSpikeProductByTime(d);
		List<SpikeProduct> products = (List<SpikeProduct>) map.get("list");
		
		for (SpikeProduct p : products) {
			System.out.println(p.getSpikeProductId()+" "+p.getProductName());
			p.setProductName(p.getProductName() + (p.getSize()==null?"":" "+p.getSize()) + (p.getVersion()==null?"":" "+p.getVersion())+" "+p.getColor());
		}
		
		request.setAttribute("state", d.after(new Date())?"ableChange":"unableChange");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		request.setAttribute("date", format.format(date));
		request.setAttribute("time", time);
		request.setAttribute("productList", products);
		return "forward:setSpikeProduct.jsp";
	}
	
	/**   
	* �õ����е�������Ʒ��Ϣ
	*/
	@RequestMapping("getGroupProduct")
	public String getGroupProduct(HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = backgroundManageService.getGroupProduct();
		List<GroupProduct> products = (List<GroupProduct>) map.get("list");
		
		for (GroupProduct p : products) {
			p.getProduct().setExtremeName(p.getProduct().getProductName() + (p.getProduct().getSize()==null?"":" "+p.getProduct().getSize()) + (p.getProduct().getVersion()==null?"":" "+p.getProduct().getVersion())+" "+p.getProduct().getColor());
		}
		
		request.setAttribute("productList", products);
		return "forward:setGroupProduct.jsp";
	}
	
	/**   
	* �õ����е���Ʒһ��������Ϣ
	*/
	@RequestMapping("getProductFirstClassInManage")
	public @ResponseBody List<ProductFirstClass> getProductFirstClassInManage(HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> map = backgroundManageService.getProductFirstClass();
		List<ProductFirstClass> list = (List<ProductFirstClass>) map.get("list");
		
		return list;
	}
	
	
	/**   
	* �õ����е���Ʒ����������Ϣ
	*/
	@RequestMapping("getProductSecondClassInManage")
	public @ResponseBody List<ProductSecondClass> getProductSecondClassInManage(HttpSession session, HttpServletRequest request,Integer id) {
		
		if (id==null || id==0) {
			return null;
		}
		
		Map<String, Object> map = backgroundManageService.getProductSecondClass(id);
		List<ProductSecondClass> list = (List<ProductSecondClass>) map.get("list");
		
		return list;
	}
	
	/**   
	* ͨ����������õ���Ʒ��Ϣ
	*/
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
	
	/**   
	* ����������Ʒ����Ϊһ�������ﲻ�����ظ���Ʒ
	* ����ͨ����������ͳ�����Ϣ�õ���Ʒ��Ϣ
	*/
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
	
	/**   
	* ͨ��id�õ���Ʒ�ľ�����Ϣ
	*/
	@RequestMapping("getProductInfoInManage")
	public @ResponseBody Product getProductInfoInManage(HttpSession session, HttpServletRequest request,Integer id) {
		
		if (id==null || id==0) {
			return null;
		}
		
		Product p= backgroundManageService.getProductById(id);
		p.setExtremeName(p.getProductName() + (p.getSize()==null?"":" "+p.getSize()) + (p.getVersion()==null?"":" "+p.getVersion())+" "+p.getColor());

		
		return p;
	}
	
	/**   
	* ͨ����Ʒid�����ӵĿ����
	* �ı���
	*/
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
	
	/**   
	* ��������ĳ��κ���Ʒ��Ϣ
	* ���������Ʒ 
	*/
	@RequestMapping("addSpikeProduct")
	public String addSpikeProduct(HttpSession session, HttpServletRequest request,SpikeProduct p,Date date,String time) {
		
		if (p==null || p.getProductId()==0) {
			request.setAttribute("alertMsg", "���ʧ��");
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
		
		request.setAttribute("alertMsg", "��ӳɹ�");
		return getSpikeProductByTime(session, request, date, time);
	}
	
	/**   
	* ͨ����Ʒid�������ĳ��κ��޸ĺ����Ʒ��Ϣ
	* �ı�������Ʒ
	*/
	@RequestMapping("modifySpikeProduct")
	public String modifySpikeProduct(HttpSession session, HttpServletRequest request,SpikeProduct p,Date date,String time) {
		
		if (p==null || p.getSpikeProductId()==0) {
			request.setAttribute("alertMsg", "�޸�ʧ��");
			return getSpikeProductByTime(session, request, date, time);
		}
		
		backgroundManageService.modifySpikeProduct(p);
		
		request.setAttribute("alertMsg", "�޸ĳɹ�");
		return getSpikeProductByTime(session, request, date, time);
	}
	
	/**   
	* ͨ��������Ʒid����Ʒid
	* ɾ��������Ʒͬʱ�޸Ŀ��
	*/
	@RequestMapping("deleteSpikeProduct")
	public String deleteSpikeProduct(HttpSession session, HttpServletRequest request,SpikeProduct p,Date date,String time) {
		
		if (p==null || p.getSpikeProductId()==0) {
			request.setAttribute("alertMsg", "ɾ��ʧ��");
			return getSpikeProductByTime(session, request, date, time);
		}
		
		backgroundManageService.deleteSpikeProduct(p);
		
		request.setAttribute("alertMsg", "ɾ���ɹ�");
		return getSpikeProductByTime(session, request, date, time);
	}
	
	/**   
	* ͨ����Ʒ��Ϣ
	* �����Ź���Ʒ
	*/
	@RequestMapping("addGroupProduct")
	public String addGroupProduct(HttpSession session, HttpServletRequest request,GroupProduct p,Integer productId) {
		
		if (p==null ) {
			request.setAttribute("alertMsg", "���ʧ��");
			return getGroupProduct(session, request);
		}
		if (productId ==null || productId==0) {
			request.setAttribute("alertMsg", "���ʧ��");
			return getGroupProduct(session, request);
		}
		Product pro = new Product();
		pro.setProductId(productId);
		p.setProduct(pro);
		

		backgroundManageService.addGroupProduct(p);
		
		request.setAttribute("alertMsg", "��ӳɹ�");
		return getGroupProduct(session, request);
	}
	
	/**   
	* ͨ����Ʒ��Ϣ
	* �޸��Ź���Ʒ
	*/
	@RequestMapping("modifyGroupProduct")
	public String modifyGroupProduct(HttpSession session, HttpServletRequest request,GroupProduct p,Integer productId) {
		
		if (p==null || p.getGroupProductId()==0) {
			request.setAttribute("alertMsg", "�޸�ʧ��");
			return getGroupProduct(session, request);
		}
		if (productId ==null || productId==0) {
			request.setAttribute("alertMsg", "�޸�ʧ��");
			return getGroupProduct(session, request);
		}
		Product pro = new Product();
		pro.setProductId(productId);
		p.setProduct(pro);
		
		backgroundManageService.modifyGroupProduct(p);
		
		request.setAttribute("alertMsg", "�޸ĳɹ�");
		return getGroupProduct(session, request);
	}
	
	/**   
	* ͨ����Ʒ��Ϣ
	* ɾ���Ź���Ʒ
	*/
	@RequestMapping("deleteGroupProduct")
	public String deleteGroupProduct(HttpSession session, HttpServletRequest request,GroupProduct p) {
		
		if (p==null || p.getGroupProductId()==0) {
			request.setAttribute("alertMsg", "ɾ��ʧ��");
			return getGroupProduct(session, request);
		}
		
		backgroundManageService.deleteGroupProduct(p);
		
		request.setAttribute("alertMsg", "ɾ���ɹ�");
		return getGroupProduct(session, request);
	}
	
	
}
