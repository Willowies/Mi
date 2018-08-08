
package com.mi.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mi.model.bean.CartItem;
import com.mi.model.bean.Coupon;
import com.mi.model.bean.Invoice;
import com.mi.model.bean.Order;
import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.Product;
import com.mi.model.bean.ReceiverAddress;
import com.mi.model.bean.SpikeProduct;
import com.mi.model.dao.CartItemDAO;
import com.mi.model.dao.CouponDAO;
import com.mi.model.dao.InvoiceDAO;
import com.mi.model.dao.OrderDAO;
import com.mi.model.dao.ReceiverAddressDAO;
import com.mi.model.dao.SpikeProductDAO;
import com.mi.model.dao.StockDAO;

@Service
public class OrderService {
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private StockDAO stockDAO;
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private CouponDAO couponDAO;
	@Autowired
	private ReceiverAddressDAO receiverAddressDAO;
	@Autowired
	private InvoiceDAO invoiceDAO;
	@Autowired
	private SpikeProductDAO spikeProductDAO;
	
	//查找购物车条目
	public List<CartItem> findCartItems(int[] cartItemIds){
		List<CartItem> cartItems = new ArrayList<CartItem>();
		for(int id:cartItemIds){
			CartItem c = cartItemDAO.getItemById(id);
			Product p = c.getProduct();
			float amount = p.getProductPrice()*c.getQuantity();
			c.setAmount(amount);
			String name = p.getProductName()+" "+p.getColor()+" "+p.getVersion()+" "+p.getSize();
			String extremeName = name.replace("null", "");
			c.getProduct().setExtremeName(extremeName);
			cartItems.add(c);
		}
		return cartItems;
	}
	
	//查找优惠券
	public List<Coupon> findCoupons(int userId,int[] productIds){
		List products = new ArrayList();
		for(int i=0;i<productIds.length;i++){
			products.add(productIds[i]);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("products", products);
		List<Coupon> coupons = couponDAO.findCoupons(map);
		return coupons;
	}
	
	//查找地址
	public List<ReceiverAddress> selectAddress(int userId){
		List<ReceiverAddress> addresses = receiverAddressDAO.selectAddress(userId);
		return addresses;
	}
	
	//支付订单
	public List<OrderProduct> payOrder(int orderId){
		//通过订单号找到订单
		Order order = orderDAO.getOrderDetailsById(orderId);
		//获取订单中商品
		List<OrderProduct> products =  order.getProducts();
		//查询库存量
		List<OrderProduct> lack = new ArrayList<OrderProduct>();
		for(OrderProduct o:products){
			if(stockDAO.selectStock(o.getProduct().getProductId())<o.getQuantity()){
				//库存量小于购买量
				lack.add(o);
			}
		}
		if(lack.size()==0){
			//没有商品缺货
			//更新订单状态
			orderDAO.updatePayOrder(orderId);
			//使用优惠券
			Map<String,Object> couponmap = new HashMap<String,Object>();
			couponmap.put("userId", order.getUser().getUserId());
			couponmap.put("couponId",order.getCoupon().getCouponId());
			couponDAO.updateUsedCoupon(couponmap);
			//减少库存
			for(OrderProduct o:products){
				Map<String,Object> stockMap = new HashMap<String,Object>();
				stockMap.put("quantity", o.getQuantity());
				stockMap.put("productId", o.getProduct().getProductId());
				stockDAO.updateStock(stockMap);
			}
		}else{
			//有商品缺货，关闭订单
			orderDAO.closePayOrder(orderId);
		}
		return lack;
	}
	
	//查询订单
	public Order getOrderDetailsById(int orderId){
		return orderDAO.getOrderDetailsById(orderId);
	}
	
	//生成订单
	public int createOrder(Order order,List<CartItem> cartItems){
		//使用优惠券
		/*Map<String,Object> couponmap = new HashMap<String,Object>();
		couponmap.put("userId", order.getUser().getUserId());
		couponmap.put("couponId",order.getCoupon().getCouponId());
		couponDAO.updateUsedCoupon(couponmap);*/
		//生成订单
		order.setCreateDate(new Date(System.currentTimeMillis()));
		int orderId = orderDAO.selectOrderId()+1;
		order.setOrderId(orderId);
		/*String address =  order.getReceiverPhone();
		order.setReceiverPhone(address.replace(" ", ""));*/
		orderDAO.createOrder(order);
		//生成发票
		//若未填写发票内容则默认个人电子发票
		//发票抬头不填写，单位税号不填写，收票邮箱不填写
		//填写收票手机
		if(order.getInvoice().getReceivePhone()=="0"){
			order.getInvoice().setReceiveEmail("");
			order.getInvoice().setTaxNum(-1);
			order.getInvoice().setReceiver(order.getReceiverName());
			order.getInvoice().setReceivePhone(order.getReceiverPhone());
		}
		order.getInvoice().setOrderId(orderId);
		String content = "";
		for(CartItem c : cartItems){
			content = content+c.getProduct().getProductName()+"×"+c.getQuantity()+" "+c.getAmount()+"元\n";
		}
		order.getInvoice().setContent(content);
		order.getInvoice().setCreateDate(new Date(System.currentTimeMillis()));
		invoiceDAO.addInvoice(order.getInvoice());
		//将OrderProduct写入数据库
		for(CartItem c : cartItems){
			int orderItemId = orderDAO.selectOrderItemId()+1;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("cartItem", c);
			map.put("orderItemId", orderItemId);
			map.put("orderId", orderId);
			orderDAO.addOrderProduct(map);
		}
		//将CartItems的状态制成已结算
		for(CartItem c : cartItems){
			cartItemDAO.updateItemState(c.getCartItemId());
		}
		return orderId;
	}
	
	public void addReceiverAddress(ReceiverAddress receiverAddress){
		receiverAddressDAO.addReceiverAddress(receiverAddress);
	}
	
	//生成团购订单
	public int createGroupOrder(Order order,OrderProduct orderProduct){
		//生成订单
		order.setCreateDate(new Date(System.currentTimeMillis()));
		int orderId = orderDAO.selectOrderId()+1;
		order.setOrderId(orderId);
		orderDAO.createOrder(order);
		//生成发票
		//若未填写发票内容则默认个人电子发票
		//发票抬头不填写，单位税号不填写，收票邮箱不填写
		//填写收票手机
		if(order.getInvoice().getReceivePhone()=="0"){
			order.getInvoice().setReceiveEmail("");
			order.getInvoice().setTaxNum(-1);
			order.getInvoice().setReceiver(order.getReceiverName());
			order.getInvoice().setReceivePhone(order.getReceiverPhone());
		}
		order.getInvoice().setOrderId(orderId);
		String content = "";
		content = orderProduct.getProduct().getProductName()+"×"+orderProduct.getQuantity()+" "+orderProduct.getProductPrice()+"元\n";
		order.getInvoice().setContent(content);
		order.getInvoice().setCreateDate(new Date(System.currentTimeMillis()));
		invoiceDAO.addInvoice(order.getInvoice());
		//将OrderProduct写入数据库
		int orderItemId = orderDAO.selectOrderItemId()+1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderProduct", orderProduct);
		map.put("orderItemId", orderItemId);
		map.put("orderId", orderId);
		orderDAO.addGroupOrderProduct(map);
		return orderId;
	}
	
	public void payGroupOrder(int orderId,int groupId){
		//order状态改成4
		orderDAO.updatePayGroupOrder(orderId);
		//数据库里group，currentQuantity数量加一,开团或者参团state状态改成1
		orderDAO.updateGroup(groupId);
	}
	
	//生成秒杀订单
	public int createSpikeOrder(Order order,OrderProduct orderProduct){
		//生成订单
		order.setCreateDate(new Date(System.currentTimeMillis()));
		int orderId = orderDAO.selectOrderId()+1;
		order.setOrderId(orderId);
		orderDAO.createOrder(order);
		//生成发票
		//若未填写发票内容则默认个人电子发票
		//发票抬头不填写，单位税号不填写，收票邮箱不填写
		//填写收票手机
		if(order.getInvoice().getReceivePhone()=="0"){
			order.getInvoice().setReceiveEmail("");
			order.getInvoice().setTaxNum(-1);
			order.getInvoice().setReceiver(order.getReceiverName());
			order.getInvoice().setReceivePhone(order.getReceiverPhone());
		}
		order.getInvoice().setOrderId(orderId);
		String content = "";
		content = orderProduct.getProduct().getProductName()+"×"+orderProduct.getQuantity()+" "+orderProduct.getProductPrice()+"元\n";
		order.getInvoice().setContent(content);
		order.getInvoice().setCreateDate(new Date(System.currentTimeMillis()));
		invoiceDAO.addInvoice(order.getInvoice());
		//将OrderProduct写入数据库
		int orderItemId = orderDAO.selectOrderItemId()+1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderProduct", orderProduct);
		map.put("orderItemId", orderItemId);
		map.put("orderId", orderId);
		orderDAO.addGroupOrderProduct(map);
		return orderId;
	}
	
	public int paySpikeOrder(int orderId,int spikeProductId){
		//判断当前秒杀人数和秒杀数量的对比
		SpikeProduct s = spikeProductDAO.selectSpikeProductById(spikeProductId);
		if(s.getCurrentSpikeNum()==s.getSpikeQuantity()){
			orderDAO.closePayOrder(orderId);
			return 1;
		}else{
			orderDAO.updatePayOrder(orderId);
			orderDAO.updateSpikeProduct(spikeProductId);
			Map<String,Object> stockMap = new HashMap<String,Object>();
			stockMap.put("quantity", 1);
			Order o = orderDAO.getOrderDetailsById(orderId);
			Product p = o.getProducts().get(0).getProduct();
			stockMap.put("productId", p.getProductId());
			stockDAO.updateSpikeStock(stockMap);
			return 2;
		}
	}
	
}
