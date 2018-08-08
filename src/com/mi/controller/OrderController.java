package com.mi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.Coupon;
import com.mi.model.bean.Order;
import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.ReceiverAddress;
import com.mi.model.bean.User;
import com.mi.model.service.OrderService;
import com.mi.utils.BaseController;

@Controller
@RequestMapping("mi")
public class OrderController extends BaseController{
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("updateCalCartItems")
	public String updateCalCartItems(int[] cartItemIds,Model model,HttpSession session){
		//���Ҵ�����Ĺ��ﳵ��Ŀ
		List<CartItem> cartItems = orderService.findCartItems(cartItemIds);
		//model.addAttribute("cartItems",cartItems);
		session.setAttribute("cartItems", cartItems);
		//session.setAttribute("orderType", 1);
		session.setAttribute("itemNum", cartItems.size());
		float total = 0;
		for(int i=0;i< cartItems.size();i++){
			total = total + cartItems.get(i).getAmount();
		}
		model.addAttribute("total",total);
		//�����û����Ż�ȯ
		User user = (User)session.getAttribute("user");
		int[] productIds = new int[cartItems.size()];
		for(int i=0;i<cartItems.size();i++){
			productIds[i]=cartItems.get(i).getProduct().getProductId();
		}
		List<Coupon> coupons = orderService.findCoupons(user.getUserId(), productIds);
		model.addAttribute("coupons", coupons);
		//�����û���ַ
		List<ReceiverAddress> addresses = orderService.selectAddress(user.getUserId());
		model.addAttribute("addresses",addresses);
		return "createOrder";
	}
	
	
	
	@RequestMapping("joinGroup")
	public String joinGroup(Model model,HttpSession session){
		//session.setAttribute("orderProduct", orderProduct);
		OrderProduct orderProduct = (OrderProduct)session.getAttribute("orderProduct");
		String extremeName = orderProduct.getProduct().getProductName()+" "+orderProduct.getProduct().getColor()+" "+orderProduct.getProduct().getVersion()+" "+orderProduct.getProduct().getSize();
		extremeName = extremeName.replace("null", "");
		orderProduct.getProduct().setExtremeName(extremeName);
		model.addAttribute("itemNum", 1);
		float total = orderProduct.getAmount();
		model.addAttribute("total",total);
		float actualFee = total+10;
		model.addAttribute("actualFee",actualFee);
		User user = (User)session.getAttribute("user");
		//�����û���ַ
		List<ReceiverAddress> addresses = orderService.selectAddress(user.getUserId());
		model.addAttribute("addresses",addresses);
		return "createGroupOrder";
	}
	
	@RequestMapping("addGroup")
	public String addGroup(Model model,HttpSession session){
		//session.setAttribute("orderProduct", orderProduct);
		OrderProduct orderProduct = (OrderProduct)session.getAttribute("orderProduct");
		String extremeName = orderProduct.getProduct().getProductName()+" "+orderProduct.getProduct().getColor()+" "+orderProduct.getProduct().getVersion()+" "+orderProduct.getProduct().getSize();
		extremeName = extremeName.replace("null", "");
		orderProduct.getProduct().setExtremeName(extremeName);
		model.addAttribute("itemNum", 1);
		System.out.println(orderProduct.getProductPrice());
		float total = orderProduct.getAmount();
		//total = total+10;
		model.addAttribute("total",total);
		float actualFee = total+10;
		model.addAttribute("actualFee",actualFee);
		User user = (User)session.getAttribute("user");
		//�����û���ַ
		List<ReceiverAddress> addresses = orderService.selectAddress(user.getUserId());
		model.addAttribute("addresses",addresses);
		return "createGroupOrder";
	}
	
	@RequestMapping("getAddress")
	public @ResponseBody List<ReceiverAddress> getAddress(HttpSession session){
		//�����û���ַ
		User user = (User) session.getAttribute("user");
		List<ReceiverAddress> addresses = orderService.selectAddress(user.getUserId());
		return addresses;
	}
	
	@RequestMapping("addAddress")
	public @ResponseBody List<ReceiverAddress> addAddress(@RequestBody ReceiverAddress address,HttpSession session){
		System.out.println("����servlet");
		/*System.out.println(address.getReceiverName());
		System.out.println(address.getReceiverPhone());
		System.out.println(address.getReceiverProvince());
		System.out.println(address.getReceiverCity());
		System.out.println(address.getReceiverDistrict());
		System.out.println(address.getAddress());
		System.out.println(address.getAddressLabel());*/
		User user = (User) session.getAttribute("user");
		address.setUser(user);
		/*User u = new User();
		u.setUserId(2);
		address.setUser(u);*/
		orderService.addReceiverAddress(address);
		List<ReceiverAddress> addresses = orderService.selectAddress(address.getUser().getUserId());
		return addresses;
	}
	
	/*@RequestMapping("findOrder")
	public String findOrder(int selectOrderId,Model model){
		System.out.println("����controller");
		Order order = orderService.getOrderDetailsById(selectOrderId);
		model.addAttribute("orderResult",order);
		return "pay";
	}*/
	
	@RequestMapping("payOrder")
	public String payOrder(int orderId,Model model){
		List<OrderProduct> lack = orderService.payOrder(orderId);
		if(lack.size()>0){
			//ȱ����Ʒ������lack��
			String message = "";
			for(OrderProduct o:lack){
				String name = o.getProduct().getProductName()+" "+o.getProduct().getColor()+" "+o.getProduct().getVersion()+" "+o.getProduct().getSize();
				message = message+name+" ";
			}
			message = message.replace("null", "");
			message = message+"ȱ��������ʧ��";
			//System.out.println("message:"+message);
			model.addAttribute("message", message);
			return "pay";
		}else{
			//��ȱ��
			Order orderResult = orderService.getOrderDetailsById(orderId);
			//��дproduct��extremeName
			for(OrderProduct o:orderResult.getProducts()){
				String extremeName = o.getProduct().getProductName()+" "+o.getProduct().getColor()+" "+o.getProduct().getVersion()+" "+o.getProduct().getSize();
				extremeName = extremeName.replace("null", "");
				o.getProduct().setExtremeName(extremeName);;
			}
			model.addAttribute("orderResult",orderResult);
			return "pay-success";
		}
	}
	
	@RequestMapping("createOrder")
	public String createOrder(Order order,HttpSession session,Model model){
		List<CartItem> cartItems =  (List<CartItem>) session.getAttribute("cartItems");
		User user = (User) session.getAttribute("user");
		//int orderType = (int) session.getAttribute("orderType");
		order.setUser(user);
		//����ordertype��OrderState
		order.setOrderType(1);
		order.setOrderState(1);
		order.setDeliveryFee(10);
		//����actualTotal
		float actualTotal = 10;
		for(int i=0;i< cartItems.size();i++){
			actualTotal = actualTotal + cartItems.get(i).getAmount();
		}
		actualTotal = actualTotal - order.getCoupon().getDiscountAmount();
		order.setActualTotal(actualTotal);
		String phone = order.getReceiverPhone();
		phone = phone.trim();
		order.setReceiverPhone(phone);
		int orderId = orderService.createOrder(order,cartItems);
		//���������Ƿ񱻴��͵���̨
		/*System.out.println("�Ż�ȯ��"+order.getCoupon().getCouponId()+" "+order.getCoupon().getDiscountAmount());
		System.out.println("��ַ��"+order.getReceiverName()+" "+order.getReceiverPhone()+" "+order.getReceiverAddress());
		System.out.println("����ʱ�䣺"+order.getSendPeroid());
		System.out.println("��Ʊ��"+order.getInvoice().getInvoiceType()+" "+order.getInvoice().getReceiverType());
		System.out.println(order.getInvoice().getReceiver()+" "+order.getInvoice().getTaxNum()+" "+order.getInvoice().getReceivePhone()+" "+order.getInvoice().getReceiveEmail());*/
		session.removeAttribute("cartItems");
		session.removeAttribute("orderType");
		//session.setAttribute("orderToPay", order);
		Order orderResult = orderService.getOrderDetailsById(orderId);
		//��дproduct��extremeName
		for(OrderProduct o:orderResult.getProducts()){
			String extremeName = o.getProduct().getProductName()+" "+o.getProduct().getColor()+" "+o.getProduct().getVersion()+" "+o.getProduct().getSize();
			extremeName = extremeName.replace("null", "");
			o.getProduct().setExtremeName(extremeName);
		}
		model.addAttribute("orderResult",orderResult);
		return "pay";
	}
	
	@RequestMapping("createGroupOrder")
	public String createGroupOrder(Order order,HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		order.setUser(user);
		int groupId = (int)session.getAttribute("groupId");
		order.setGroupId(groupId);
		//����ordertype��OrderState
		order.setOrderType(2);
		order.setOrderState(1);
		order.setDeliveryFee(10);
		//����actualTotal
		float actualTotal = 10;
		OrderProduct orderProduct = (OrderProduct)session.getAttribute("orderProduct"); 
		actualTotal = actualTotal + orderProduct.getProductPrice();
		order.setActualTotal(actualTotal);
		String phone = order.getReceiverPhone();
		phone = phone.trim();
		order.setReceiverPhone(phone);
		int orderId = orderService.createGroupOrder(order,orderProduct);
		//���������Ƿ񱻴��͵���̨
		/*System.out.println("�Ż�ȯ��"+order.getCoupon().getCouponId()+" "+order.getCoupon().getDiscountAmount());
		System.out.println("��ַ��"+order.getReceiverName()+" "+order.getReceiverPhone()+" "+order.getReceiverAddress());
		System.out.println("����ʱ�䣺"+order.getSendPeroid());
		System.out.println("��Ʊ��"+order.getInvoice().getInvoiceType()+" "+order.getInvoice().getReceiverType());
		System.out.println(order.getInvoice().getReceiver()+" "+order.getInvoice().getTaxNum()+" "+order.getInvoice().getReceivePhone()+" "+order.getInvoice().getReceiveEmail());*/
		session.removeAttribute("orderProduct");
		//session.setAttribute("orderToPay", order);
		Order orderResult = orderService.getOrderDetailsById(orderId);
		//��дproduct��extremeName
		OrderProduct o = orderResult.getProducts().get(0);
		String extremeName = o.getProduct().getProductName()+" "+o.getProduct().getColor()+" "+o.getProduct().getVersion()+" "+o.getProduct().getSize();
		extremeName = extremeName.replace("null", "");
		o.getProduct().setExtremeName(extremeName);
		model.addAttribute("orderResult",orderResult);
		return "groupPay";
	}
	
	@RequestMapping("payGroupOrder")
	public String payGroupOrder(int orderId,Model model,HttpSession session){
		int groupId = (int)session.getAttribute("groupId");
		orderService.payGroupOrder(orderId,groupId);
		Order orderResult = orderService.getOrderDetailsById(orderId);
		OrderProduct o = orderResult.getProducts().get(0);
		String extremeName = o.getProduct().getProductName()+" "+o.getProduct().getColor()+" "+o.getProduct().getVersion()+" "+o.getProduct().getSize();
		extremeName = extremeName.replace("null", "");
		o.getProduct().setExtremeName(extremeName);
		model.addAttribute("orderResult",orderResult);
		return "pay-success";
	}
	
	@RequestMapping("updateSpikeOrder")
	public String updateSpikeOrder(Model model,HttpSession session){
		OrderProduct orderProduct = (OrderProduct)session.getAttribute("orderProduct");
		String extremeName = orderProduct.getProduct().getProductName()+" "+orderProduct.getProduct().getColor()+" "+orderProduct.getProduct().getVersion()+" "+orderProduct.getProduct().getSize();
		extremeName = extremeName.replace("null", "");
		orderProduct.getProduct().setExtremeName(extremeName);
		model.addAttribute("itemNum", 1);
		float total = orderProduct.getAmount();
		model.addAttribute("total",total);
		float actualFee = total+10;
		model.addAttribute("actualFee",actualFee);
		User user = (User)session.getAttribute("user");
		//�����û���ַ
		List<ReceiverAddress> addresses = orderService.selectAddress(user.getUserId());
		model.addAttribute("addresses",addresses);
		return "createSpikeOrder";
	}
	
	@RequestMapping("createSpikeOrder")
	public String createSpikeOrder(Order order,HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		order.setUser(user);
		//����ordertype��OrderState
		order.setOrderType(3);
		order.setOrderState(1);
		order.setDeliveryFee(10);
		//����actualTotal
		float actualTotal = 10;
		OrderProduct orderProduct = (OrderProduct)session.getAttribute("orderProduct"); 
		actualTotal = actualTotal + orderProduct.getProductPrice();
		order.setActualTotal(actualTotal);
		String phone = order.getReceiverPhone();
		phone = phone.trim();
		order.setReceiverPhone(phone);
		int orderId = orderService.createSpikeOrder(order,orderProduct);
		//���������Ƿ񱻴��͵���̨
		/*System.out.println("�Ż�ȯ��"+order.getCoupon().getCouponId()+" "+order.getCoupon().getDiscountAmount());
		System.out.println("��ַ��"+order.getReceiverName()+" "+order.getReceiverPhone()+" "+order.getReceiverAddress());
		System.out.println("����ʱ�䣺"+order.getSendPeroid());
		System.out.println("��Ʊ��"+order.getInvoice().getInvoiceType()+" "+order.getInvoice().getReceiverType());
		System.out.println(order.getInvoice().getReceiver()+" "+order.getInvoice().getTaxNum()+" "+order.getInvoice().getReceivePhone()+" "+order.getInvoice().getReceiveEmail());*/
		session.removeAttribute("orderProduct");
		//session.setAttribute("orderToPay", order);
		Order orderResult = orderService.getOrderDetailsById(orderId);
		//��дproduct��extremeName
		OrderProduct o = orderResult.getProducts().get(0);
		String extremeName = o.getProduct().getProductName()+" "+o.getProduct().getColor()+" "+o.getProduct().getVersion()+" "+o.getProduct().getSize();
		extremeName = extremeName.replace("null", "");
		o.getProduct().setExtremeName(extremeName);
		model.addAttribute("orderResult",orderResult);
		return "spikePay";
	}
	
	@RequestMapping("paySpikeOrder")
	public String paySpikeOrder(int orderId,Model model,HttpSession session){
		int spikeProductId = (int)session.getAttribute("spikeProductId");
		int result = orderService.paySpikeOrder(orderId,spikeProductId);
		if(result==1){
			//��ɱ��Ʒ�ѱ�����
			String message ="��ɱ����������ʧ��";
			model.addAttribute("message", message);
			return "spikePay";
		}else{
			//��ɱ��Ʒ������
			Order orderResult = orderService.getOrderDetailsById(orderId);
			OrderProduct o = orderResult.getProducts().get(0);
			String extremeName = o.getProduct().getProductName()+" "+o.getProduct().getColor()+" "+o.getProduct().getVersion()+" "+o.getProduct().getSize();
			extremeName = extremeName.replace("null", "");
			o.getProduct().setExtremeName(extremeName);
			model.addAttribute("orderResult",orderResult);
			session.removeAttribute("spikeProductId");
			return "pay-success";
		}
	}
	
}
