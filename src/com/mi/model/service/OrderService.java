
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
	
	//���ҹ��ﳵ��Ŀ
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
	
	//�����Ż�ȯ
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
	
	//���ҵ�ַ
	public List<ReceiverAddress> selectAddress(int userId){
		List<ReceiverAddress> addresses = receiverAddressDAO.selectAddress(userId);
		return addresses;
	}
	
	//֧������
	public List<OrderProduct> payOrder(int orderId){
		//ͨ���������ҵ�����
		Order order = orderDAO.getOrderDetailsById(orderId);
		//��ȡ��������Ʒ
		List<OrderProduct> products =  order.getProducts();
		//��ѯ�����
		List<OrderProduct> lack = new ArrayList<OrderProduct>();
		for(OrderProduct o:products){
			if(stockDAO.selectStock(o.getProduct().getProductId())<o.getQuantity()){
				//�����С�ڹ�����
				lack.add(o);
			}
		}
		if(lack.size()==0){
			//û����Ʒȱ��
			//���¶���״̬
			orderDAO.updatePayOrder(orderId);
			//ʹ���Ż�ȯ
			Map<String,Object> couponmap = new HashMap<String,Object>();
			couponmap.put("userId", order.getUser().getUserId());
			couponmap.put("couponId",order.getCoupon().getCouponId());
			couponDAO.updateUsedCoupon(couponmap);
			//���ٿ��
			for(OrderProduct o:products){
				Map<String,Object> stockMap = new HashMap<String,Object>();
				stockMap.put("quantity", o.getQuantity());
				stockMap.put("productId", o.getProduct().getProductId());
				stockDAO.updateStock(stockMap);
			}
		}else{
			//����Ʒȱ�����رն���
			orderDAO.closePayOrder(orderId);
		}
		return lack;
	}
	
	//��ѯ����
	public Order getOrderDetailsById(int orderId){
		return orderDAO.getOrderDetailsById(orderId);
	}
	
	//���ɶ���
	public int createOrder(Order order,List<CartItem> cartItems){
		//ʹ���Ż�ȯ
		/*Map<String,Object> couponmap = new HashMap<String,Object>();
		couponmap.put("userId", order.getUser().getUserId());
		couponmap.put("couponId",order.getCoupon().getCouponId());
		couponDAO.updateUsedCoupon(couponmap);*/
		//���ɶ���
		order.setCreateDate(new Date(System.currentTimeMillis()));
		int orderId = orderDAO.selectOrderId()+1;
		order.setOrderId(orderId);
		/*String address =  order.getReceiverPhone();
		order.setReceiverPhone(address.replace(" ", ""));*/
		orderDAO.createOrder(order);
		//���ɷ�Ʊ
		//��δ��д��Ʊ������Ĭ�ϸ��˵��ӷ�Ʊ
		//��Ʊ̧ͷ����д����λ˰�Ų���д����Ʊ���䲻��д
		//��д��Ʊ�ֻ�
		if(order.getInvoice().getReceivePhone()=="0"){
			order.getInvoice().setReceiveEmail("");
			order.getInvoice().setTaxNum(-1);
			order.getInvoice().setReceiver(order.getReceiverName());
			order.getInvoice().setReceivePhone(order.getReceiverPhone());
		}
		order.getInvoice().setOrderId(orderId);
		String content = "";
		for(CartItem c : cartItems){
			content = content+c.getProduct().getProductName()+"��"+c.getQuantity()+" "+c.getAmount()+"Ԫ\n";
		}
		order.getInvoice().setContent(content);
		order.getInvoice().setCreateDate(new Date(System.currentTimeMillis()));
		invoiceDAO.addInvoice(order.getInvoice());
		//��OrderProductд�����ݿ�
		for(CartItem c : cartItems){
			int orderItemId = orderDAO.selectOrderItemId()+1;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("cartItem", c);
			map.put("orderItemId", orderItemId);
			map.put("orderId", orderId);
			orderDAO.addOrderProduct(map);
		}
		//��CartItems��״̬�Ƴ��ѽ���
		for(CartItem c : cartItems){
			cartItemDAO.updateItemState(c.getCartItemId());
		}
		return orderId;
	}
	
	public void addReceiverAddress(ReceiverAddress receiverAddress){
		receiverAddressDAO.addReceiverAddress(receiverAddress);
	}
	
	//�����Ź�����
	public int createGroupOrder(Order order,OrderProduct orderProduct){
		//���ɶ���
		order.setCreateDate(new Date(System.currentTimeMillis()));
		int orderId = orderDAO.selectOrderId()+1;
		order.setOrderId(orderId);
		orderDAO.createOrder(order);
		//���ɷ�Ʊ
		//��δ��д��Ʊ������Ĭ�ϸ��˵��ӷ�Ʊ
		//��Ʊ̧ͷ����д����λ˰�Ų���д����Ʊ���䲻��д
		//��д��Ʊ�ֻ�
		if(order.getInvoice().getReceivePhone()=="0"){
			order.getInvoice().setReceiveEmail("");
			order.getInvoice().setTaxNum(-1);
			order.getInvoice().setReceiver(order.getReceiverName());
			order.getInvoice().setReceivePhone(order.getReceiverPhone());
		}
		order.getInvoice().setOrderId(orderId);
		String content = "";
		content = orderProduct.getProduct().getProductName()+"��"+orderProduct.getQuantity()+" "+orderProduct.getProductPrice()+"Ԫ\n";
		order.getInvoice().setContent(content);
		order.getInvoice().setCreateDate(new Date(System.currentTimeMillis()));
		invoiceDAO.addInvoice(order.getInvoice());
		//��OrderProductд�����ݿ�
		int orderItemId = orderDAO.selectOrderItemId()+1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderProduct", orderProduct);
		map.put("orderItemId", orderItemId);
		map.put("orderId", orderId);
		orderDAO.addGroupOrderProduct(map);
		return orderId;
	}
	
	public void payGroupOrder(int orderId,int groupId){
		//order״̬�ĳ�4
		orderDAO.updatePayGroupOrder(orderId);
		//���ݿ���group��currentQuantity������һ,���Ż��߲���state״̬�ĳ�1
		orderDAO.updateGroup(groupId);
	}
	
	//������ɱ����
	public int createSpikeOrder(Order order,OrderProduct orderProduct){
		//���ɶ���
		order.setCreateDate(new Date(System.currentTimeMillis()));
		int orderId = orderDAO.selectOrderId()+1;
		order.setOrderId(orderId);
		orderDAO.createOrder(order);
		//���ɷ�Ʊ
		//��δ��д��Ʊ������Ĭ�ϸ��˵��ӷ�Ʊ
		//��Ʊ̧ͷ����д����λ˰�Ų���д����Ʊ���䲻��д
		//��д��Ʊ�ֻ�
		if(order.getInvoice().getReceivePhone()=="0"){
			order.getInvoice().setReceiveEmail("");
			order.getInvoice().setTaxNum(-1);
			order.getInvoice().setReceiver(order.getReceiverName());
			order.getInvoice().setReceivePhone(order.getReceiverPhone());
		}
		order.getInvoice().setOrderId(orderId);
		String content = "";
		content = orderProduct.getProduct().getProductName()+"��"+orderProduct.getQuantity()+" "+orderProduct.getProductPrice()+"Ԫ\n";
		order.getInvoice().setContent(content);
		order.getInvoice().setCreateDate(new Date(System.currentTimeMillis()));
		invoiceDAO.addInvoice(order.getInvoice());
		//��OrderProductд�����ݿ�
		int orderItemId = orderDAO.selectOrderItemId()+1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderProduct", orderProduct);
		map.put("orderItemId", orderItemId);
		map.put("orderId", orderId);
		orderDAO.addGroupOrderProduct(map);
		return orderId;
	}
	
	public int paySpikeOrder(int orderId,int spikeProductId){
		//�жϵ�ǰ��ɱ��������ɱ�����ĶԱ�
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
