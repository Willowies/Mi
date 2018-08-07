package com.mi.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.SpikeProduct;
import com.mi.model.bean.User;
import com.mi.model.service.ProductSpikeService;

@Controller
@RequestMapping("mi")
public class ProductSpikeController {
	@Autowired
	private ProductSpikeService productSpikeService;	
	
	public User getUser(HttpSession session){
		User u = new User();
		u.setUserId(2);
		session.setAttribute("user", u);
		User user = (User) session.getAttribute("user");
		return user;
	}
	//������ɱʱ���ѯ��ɱ��Ʒ
	@RequestMapping("selectSpikeProduct")
	public @ResponseBody List<SpikeProduct> selectSpikeProduct(String focusSpikeTime){
		int startTime = Integer.parseInt(focusSpikeTime);
		List<SpikeProduct> productList = productSpikeService.selectSpikeProduct(startTime);
		//System.out.println(productList.size());
		return productList;
	}
	//������ɱ����
	@RequestMapping("addSpikeRemind")
	public @ResponseBody String addSpikeRemind(HttpServletRequest request, int spikeProductId, Date remindTime, HttpSession session){
		User user = getUser(session);
		spikeProductId = Integer.parseInt(request.getParameter("spikeProductId"));
		String isSetted = productSpikeService.addSpikeRemind(spikeProductId, user.getUserId(), remindTime);
		return isSetted;
	}
	//������Ʒ
	@RequestMapping("buySpikeProduct")
	public @ResponseBody String buySpikeProduct(HttpServletRequest request, String spikeProductId, HttpSession session){
		
		//session.setAttribute("spikeProductId", Integer.parseInt(spikeProductId));
		String buySucceed = productSpikeService.selectBuySpikeProduct(Integer.parseInt(spikeProductId));
		System.out.println(buySucceed);
		return buySucceed;
	}
	//��װ��Ʒ��Ϣ
	@RequestMapping("findSpikeProduct")
	public @ResponseBody OrderProduct findSpikeProduct(HttpServletRequest request, int spikeProductId){
		spikeProductId = Integer.parseInt(request.getParameter("spikeProductId"));
		OrderProduct orderProduct = productSpikeService.findSpikeProduct(spikeProductId);
		return orderProduct;
	}
	//������Ϣ������ɱ
	@RequestMapping("addSpikeMessage")
	public void addSpikeMessage(HttpServletRequest request, int spikeProductId, Date sendTime, HttpSession session){
		User user = getUser(session);
		spikeProductId = Integer.parseInt(request.getParameter("spikeProductId"));
		productSpikeService.addSpikeMessage(spikeProductId, user.getUserId(), sendTime);
	}
	//������ҳ���ҵ���ɱ��Ʒ�б�
	@RequestMapping("selectIndexSpikeProduct")
	public @ResponseBody List<SpikeProduct> selectIndexSpikeProduct(Date currentDate){
		List<SpikeProduct> spikeList = productSpikeService.selectIndexSpikeProduct(currentDate);
		return spikeList;
	}
	


}
