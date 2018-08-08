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
		
		/*User user = (User)session.getAttribute("user");
		if(user==null){
			return "forward:homepage.jsp";
		}
		int userId = user.getUserId();*/
		User user = new User();
		user.setUserId(10002);
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
	public String disPlayMessage(Model model,HttpSession session,@RequestParam(value="messageType",defaultValue="1")Integer messageType,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
		System.out.println("½øÈëdisplayMessage");
		/*User user = (User)session.getAttribute("user");
		if(user==null){
			return "forward:homepage.jsp";
		}
		int userId = user.getUserId();*/
		User user = new User();
		user.setUserId(10002);
		int userId = user.getUserId();
		System.out.println(userId);
		Map<String, Object> map = messageService.selectMessageByUserId(userId,messageType, pageNum, 5);
		List<Message> messageResult = (List<Message>) map.get("list");
		model.addAttribute("resultList", messageResult);
		model.addAttribute("pageTotal", (int)map.get("pageTotal"));
		return "forward:myMessage.jsp";
	}
	@RequestMapping("displayLikeProduct")
	public String displayLikeProduct(Model model,HttpSession session,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
		User user = (User)session.getAttribute("user");
		if(user==null){
			return "forward:homepage.jsp";
		}
		int userId = user.getUserId();
		
		Map<String, Object> map = likeProductService.selectLikeProductByUserId(userId, pageNum, 5);
		List<LikeProduct> likeProductResult = (List<LikeProduct>) map.get("list");
		model.addAttribute("resultList", likeProductResult);
		model.addAttribute("pageTotal", (int)map.get("pageTotal"));
		return "forward:likeProduct.jsp";
	}
	@RequestMapping("displayCoupon")
	public String disPlayCoupon(Model model,HttpSession session,@RequestParam(value="couponStatus",defaultValue="1")Integer couponStatus,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
		/*User user = (User)session.getAttribute("user");
		if(user==null){
			return "forward:homepage.jsp";
		}
		int userId = user.getUserId();*/
		User user = new User();
		user.setUserId(2);
		int userId = user.getUserId();
		
		Map<String, Object> map = couponService.selectCouponByUserId(userId,couponStatus, pageNum, 5);
		List<Coupon> result = (List<Coupon>) map.get("list");
		model.addAttribute("resultList", result);
		model.addAttribute("pageTotal", (int)map.get("pageTotal"));
		return "forward:myCoupon.jsp";
	}
	@RequestMapping("displayReceiverAddress")
	public String displayReceiverAddress(Model model,HttpSession session,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
		/*User user = (User)session.getAttribute("user");
		if(user==null){
			return "forward:homepage.jsp";
		}
		int userId = user.getUserId();*/
		User user = new User();
		user.setUserId(2);
		int userId = user.getUserId();
		
		Map<String, Object> map = receiverAddressService.selectReceiverAddress(user.getUserId(),pageNum,5);
		List<ReceiverAddress> resultList = (List<ReceiverAddress>) map.get("list");
		model.addAttribute("resultList", resultList);
		model.addAttribute("pageTotal", (int)map.get("pageTotal"));
		return "forward:receiverAddress.jsp";
	}
	
	@RequestMapping("addReceiverAddress")
	public String addReceiverAddress(Model model,HttpSession session,ReceiverAddress receiverAddress) {
		User user = (User)session.getAttribute("user");
		if(user==null){
			return "forward:homepage.jsp";
		}
		
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
	
}
