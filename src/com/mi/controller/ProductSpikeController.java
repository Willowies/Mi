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
		/*User u = new User();
		u.setUserId(2);
		session.setAttribute("user", u);*/
		User user = (User) session.getAttribute("user");
		return user;
	}
	//根据秒杀时间查询秒杀商品
	@RequestMapping("selectSpikeProduct")
	public @ResponseBody List<SpikeProduct> selectSpikeProduct(String focusSpikeTime){
		int startTime = Integer.parseInt(focusSpikeTime);
		List<SpikeProduct> productList = productSpikeService.selectSpikeProduct(startTime);
		//System.out.println(productList.size());
		return productList;
	}
	//设置秒杀提醒
	@RequestMapping("addSpikeRemind")
	public @ResponseBody String addSpikeRemind(String spikeProductId, String remindTime, HttpSession session){
		User user = getUser(session);
		String isSetted = productSpikeService.addSpikeRemind(Integer.parseInt(spikeProductId), user.getUserId(), remindTime);
		return isSetted;
	}
	//抢购商品
	@RequestMapping("buySpikeProduct")
	public @ResponseBody String buySpikeProduct(String spikeProductId, HttpSession session){
		//session.setAttribute("spikeProductId", spikeProductId);
		String buySucceed = productSpikeService.selectBuySpikeProduct(Integer.parseInt(spikeProductId));		
		return buySucceed;
	}
	//封装商品信息
	@RequestMapping("findSpikeProduct")
	public @ResponseBody OrderProduct findSpikeProduct(String spikeProductId, HttpSession session){
		//spikeProductId = Integer.parseInt(request.getParameter("spikeProductId"));
		OrderProduct orderProduct = productSpikeService.findSpikeProduct(Integer.parseInt(spikeProductId));
		session.setAttribute("orderProduct", orderProduct);
		session.setAttribute("spikeProductId", Integer.parseInt(spikeProductId));
		return orderProduct;
	}
	//发送消息提醒秒杀
	@RequestMapping("addSpikeMessage")
	public void addSpikeMessage(String spikeProductId, String sendTime, HttpSession session){
		User user = getUser(session);
		//spikeProductId = Integer.parseInt(request.getParameter("spikeProductId"));
		productSpikeService.addSpikeMessage(Integer.parseInt(spikeProductId), user.getUserId(), sendTime);
	}
	//返回首页查找的秒杀商品列表
	@RequestMapping("selectIndexSpikeProduct")
	public @ResponseBody List<SpikeProduct> selectIndexSpikeProduct(String currentDate){
		List<SpikeProduct> spikeList = productSpikeService.selectIndexSpikeProduct(currentDate);
		return spikeList;
	}
	//更改秒杀提醒的状态
	@RequestMapping("updateSpikeRemind")
	public void updateSpikeRemind(String spikeProductId, String remindTime, HttpSession session){
		User user = getUser(session);
		productSpikeService.updateSpikeRemind(Integer.parseInt(spikeProductId), user.getUserId(), remindTime);
	}


}
