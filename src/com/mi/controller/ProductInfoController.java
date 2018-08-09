package com.mi.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.Coupon;
import com.mi.model.bean.Product;
import com.mi.model.bean.ReceiverAddress;
import com.mi.model.bean.User;
import com.mi.model.service.ProductInfoService;

@Controller
@RequestMapping("mi")
public class ProductInfoController {
	@Autowired
	private ProductInfoService productInfoService;
	
	public User getUser(HttpSession session){
		User user = (User) session.getAttribute("user");
		return user;
	}
	
	//��ѯ��Ʒ�������Ż�ȯ�����ڵص���Ϣ
	@RequestMapping("selectProductInfo")
	public String selectProductInfo(Model model, String productName, HttpSession session){
		//����Service
		System.out.println("��Ʒ���ƣ�"+productName);
		try {
			URLDecoder.decode(productName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User user = getUser(session);
		List<Product> list = productInfoService.selectProductByName(productName);
		ReceiverAddress receiverAddress = new ReceiverAddress();;
		if(user != null){
			receiverAddress = productInfoService.selectAddress(user.getUserId());
		}else{
			receiverAddress.setReceiverProvince("ֱϽ");
			receiverAddress.setReceiverCity("������");
			receiverAddress.setReceiverDistrict("������");
			receiverAddress.setAddress("");
		}
		
		List<Coupon> couponList = productInfoService.selectCoupon(productName);
		model.addAttribute("productName", productName);
		model.addAttribute("productList", list);
		model.addAttribute("receiverAddress", receiverAddress);
		model.addAttribute("couponList", couponList);
		return "productInfo";
	}
	//������Ʒ���汾������ѯ��Ʒ
	@RequestMapping("selectProductColor")
	public @ResponseBody List<Product> selectProductColor(String productName, String version){
		try {
			URLDecoder.decode(productName, "UTF-8");
			URLDecoder.decode(version, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<Product> productList = productInfoService.selectProductColor(productName, version);
		//System.out.println(productList.size());
		
		return productList;
	}
	//������Ʒ���汾��ɫ������ѯ��Ʒ
	@RequestMapping("selectProduct")
	public @ResponseBody Product selectProduct(String productName, String version, String color, String size){
		try {
			URLDecoder.decode(productName, "UTF-8");
			URLDecoder.decode(version, "UTF-8");
			URLDecoder.decode(color, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Product product = productInfoService.selectProduct(productName, version, color, size);
		//System.out.println(product.getColor());
		return product;
	}
	//��ѯ���
	@RequestMapping("selectProductStock")
	public @ResponseBody String selectProductStock(String productName, String version, String color, String size){
		try {
			URLDecoder.decode(productName, "UTF-8");
			URLDecoder.decode(version, "UTF-8");
			URLDecoder.decode(color, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Product product = productInfoService.selectProduct(productName,version,color,size);		
		String isHasStock = "";
		isHasStock = productInfoService.selectProductStock(product.getProductId());
		return isHasStock;
	}
	//��ȡ�Ż�ȯ
	@RequestMapping("receiveCoupon")
	public @ResponseBody String updateReceiveCoupon(int couponId, HttpSession session){
		User user = getUser(session);
		String isSucceed = productInfoService.updateReceiveCoupon(couponId, user.getUserId());
		return isSucceed;
	}
	//���õ���֪ͨ
	@RequestMapping("noticeArrival")
	public @ResponseBody String addProductArrivalNotice(Model model, String productName, String version, String color, String size, HttpSession session){
		User user = getUser(session);		
		Product product = productInfoService.selectProduct(productName,version,color,size);
		String isSetted = productInfoService.addProductArrivalNotice(user.getUserId(), product.getProductId());
		return isSetted;
	}
	//ȡ������֪ͨ
	/*@RequestMapping("cancelArrival")
	public @ResponseBody String deleteProductArrivalNotice(Model model, String productName, String version, String color, String size, HttpSession session){
		User user = getUser(session);		
		Product product = productInfoService.selectProduct(productName,version,color,size);
		productInfoService.deleteProductArrivalNotice(user.getUserId(), product.getProductId());
		return "��ȡ��";
	}*/	

}
