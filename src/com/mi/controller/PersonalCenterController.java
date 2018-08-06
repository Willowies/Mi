package com.mi.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mi.model.bean.Coupon;
import com.mi.model.bean.LikeProduct;
import com.mi.model.bean.Message;
import com.mi.model.bean.Product;
import com.mi.model.bean.ReceiverAddress;
import com.mi.model.bean.User;
import com.mi.model.service.CouponService;
import com.mi.model.service.LikeProductService;
import com.mi.model.service.MessageService;
import com.mi.model.service.ReceiverAddressService;
import com.mi.model.service.UserService;

@Controller
@RequestMapping("mi")
public class PersonalCenterController {
	@Autowired
	private LikeProductService likeProductService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ReceiverAddressService receiverAddressService;
	@Autowired
	private CouponService couponService;
	
	@RequestMapping("disPlayMyPersonalCenter")
	public String disPlayMyPersonalCenter(Model model,HttpSession session) {
		/* 待整合的时候加入真实的USER
		 * User user = (User)session.getAttribute("user");
		if(user==null){
			return "homePage";
		}*/
		User user = new User();
		user.setUserId(1);
		int userId = user.getUserId();
		int likeProductCount = likeProductService.selectLikeProductCount(userId);
		int unpayOrderCount = likeProductService.selectUnpayOrderCount(userId);
		int pendingOrderCount = likeProductService.selectPendingOrderCount(userId);
		int uncommentOrderCount = likeProductService.selectUncommentOrderCount(userId);
		
		model.addAttribute("user",user);
		model.addAttribute("likeProductCount",likeProductCount);
		model.addAttribute("unpayOrderCount",unpayOrderCount);
		model.addAttribute("pendingOrderCount",pendingOrderCount);
		model.addAttribute("uncommentOrderCount",uncommentOrderCount);
		
		return "forward:myPersonalCenter.jsp";
	}
	@RequestMapping("displayMessage")
	public String disPlayMessage(Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
		User user = new User();
		user.setUserId(1);
		int userId = user.getUserId();
		
		Map<String, Object> map = messageService.selectMessageByUserId(userId, pageNum, 5);
		List<Message> messageResult = (List<Message>) map.get("list");
		model.addAttribute("resultList", messageResult);
		model.addAttribute("pageTotal", (int)map.get("pageTotal"));
		return "forward:myMessage.jsp";
	}
	@RequestMapping("displayLikeProduct")
	public String displayLikeProduct(Model model,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
		User user = new User();
		user.setUserId(10001);
		int userId = user.getUserId();
		
		Map<String, Object> map = likeProductService.selectLikeProductByUserId(userId, pageNum, 5);
		List<LikeProduct> likeProductResult = (List<LikeProduct>) map.get("list");
		model.addAttribute("resultList", likeProductResult);
		model.addAttribute("pageTotal", (int)map.get("pageTotal"));
		return "forward:likeProduct.jsp";
	}
	@RequestMapping("displayCoupon")
	public String disPlayCoupon(Model model,@RequestParam(value="couponType",defaultValue="1")Integer couponType,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
		User user = new User();
		user.setUserId(2);
		int userId = user.getUserId();
		
		Map<String, Object> map = couponService.selectCouponByUserId(userId,couponType, pageNum, 5);
		List<Coupon> result = (List<Coupon>) map.get("list");
		model.addAttribute("resultList", result);
		model.addAttribute("pageTotal", (int)map.get("pageTotal"));
		return "forward:myCoupon.jsp";
	}
	@RequestMapping("displayReceiverAddress")
	public String displayReceiverAddress(Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
		User user = new User();
		Map<String, Object> map = receiverAddressService.selectReceiverAddress(user.getUserId(),pageNum,5);
		List<ReceiverAddress> resultList = (List<ReceiverAddress>) map.get("list");
		model.addAttribute("resultList", resultList);
		model.addAttribute("pageTotal", (int)map.get("pageTotal"));
		return "forward:receiverAddress.jsp";
	}
	@RequestMapping("addReceiverAddress")
	public String addReceiverAddress(Model model,HttpSession httpSession,ReceiverAddress receiverAddress) {
		/*User user = (User)httpSession.getAttribute("user");
		if(user==null){
			return "homePage";
		}
		从session中获取登录的USER
		*/
		//临时代替
		User user = new User();
		receiverAddress.setUser(user);
		receiverAddressService.addReceiverAddress(receiverAddress);
		
		
		return "redirect:displayReceiverAddress.action";
	}
	
	@RequestMapping("deleteReceiverAddress")
	public String deleteReceiverAddress(Integer receiverAddressId) {
		receiverAddressService.deleteReceiverAddress(receiverAddressId);
		return "redirect:displayReceiverAddress.action";
	}
	@RequestMapping("updateReceiverAddress")
	public String updateReceiverAddress(ReceiverAddress receiverAddress) {
		receiverAddressService.updateReceiverAddress(receiverAddress);
		return "redirect:displayReceiverAddress.action";
	}
	@RequestMapping("selectClassfiedProduct")
	public String selectClassfiedProduct(Model model,@RequestParam(value="secondClassId",defaultValue="1") Integer secondClassId,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
		Map<String, Object> map = likeProductService.selectClassfiedProductBySecondClassId(secondClassId,pageNum);
		List<Product> resultList = (List<Product>) map.get("list");
		model.addAttribute("resultList", resultList);
		model.addAttribute("pageTotal", (int)map.get("pageTotal"));
		return "forward:classifiProduct.jsp";
	}
	
/*	@RequestMapping("selectLikeProductCount")
	public ModelAndView tttt() {
		List<LikeProduct> list = likeProductService.selectLikeProduct();
		ModelAndView mav = new ModelAndView();
		//LikeProduct likeProduct = new LikeProduct();
		System.out.println(list.get(0).getLikeProductId());
		mav.addObject("resultList",list);
		mav.setViewName("selectLikeProduct");
		return mav;
	}
	@RequestMapping("selectLikeProduct2")
	public ModelAndView dddd() {
		int likeProductCount = 0;
		likeProductCount = likeProductService.selectLikeProductCount();
		
		ModelAndView mav = new ModelAndView();
		//LikeProduct likeProduct = new LikeProduct();
		mav.addObject("likeProductCount",likeProductCount);
		mav.setViewName("selectLikeProduct");
		return mav;
	}*/
	
}
