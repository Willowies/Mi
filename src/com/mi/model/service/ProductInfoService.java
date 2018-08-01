package com.mi.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.Coupon;
import com.mi.model.bean.Product;
import com.mi.model.bean.ReceiverAddress;
import com.mi.model.dao.CouponDAO;
import com.mi.model.dao.NoticeOfArrivalDAO;
import com.mi.model.dao.ProductDAO;
import com.mi.model.dao.ReceiverAddressDAO;
import com.mi.model.dao.StockDAO;

@Service
public class ProductInfoService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private StockDAO stockDAO;
	@Autowired
	private ReceiverAddressDAO receiverAddressDAO;
	@Autowired
	private CouponDAO couponDAO;
	@Autowired
	private NoticeOfArrivalDAO noticeOfArrivalDAO;
	
	public List<Product> selectProductByName(String productName){		
		List<Product> list = productDAO.selectProductByName(productName);
		for(int i = 0 ; i < list.size()-1; i++){       
		      for(int j = list.size()-1; j > i;j--){       
		           if(list.get(j).getVersion().equals(list.get(i).getVersion())){       
		              list.remove(j);       
		           }        
		      }        
		}        
		return list;
	}
	
	public String selectProductStock(int productId){
		int productStock = stockDAO.selectProductStock(productId);
		String isHasStock = "";
		if(productStock == 0){
			isHasStock = "暂时缺货";
		}else{
			isHasStock = "有货";
		}
		return isHasStock;
	}
	
	public ReceiverAddress selectAddress(Integer userId){
		List<ReceiverAddress> list = receiverAddressDAO.selectAddress(userId);
		ReceiverAddress receiverAddress = new ReceiverAddress();
		if(list.size() == 0){
			receiverAddress.setReceiverProvince("直辖");
			receiverAddress.setReceiverCity("北京市");
			receiverAddress.setReceiverDistrict("海淀区");
			receiverAddress.setAddress("");
		}else{
			receiverAddress = list.get(0);
		}
		return receiverAddress;
	}
	
	public List<Coupon> selectCoupon(String productName){
		List<Coupon> couponList = couponDAO.selectCoupon(productName);
		return couponList;
	}	
	
	public String updateReceiveCoupon(int couponId, int userId){
		String isSucceed = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("couponId", couponId);
		map.put("userId", userId);
		if(couponDAO.selectValidateCoupon(map) == 0){
			couponDAO.updateReceiveCoupon(map);	
			isSucceed = "领取成功";
		}else{
			isSucceed = "领取失败(已领取过)";
		}
		return isSucceed;
	}
	
	public Product selectProduct(String productName, String version, String color, String size){
		List<String> list = new ArrayList<String>();
		list.add(productName);
		list.add(version);
		list.add(color);
		list.add(size);
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) == null){
				list.set(i, "");
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productName", list.get(0));
		map.put("version", list.get(1));
		map.put("color", list.get(2));
		map.put("size", list.get(3));
		Product product = productDAO.selectProduct(map);
		List<String> list1 = new ArrayList<String>();
		list1.add(product.getVersion());
		list1.add(product.getColor());
		list1.add(product.getSize());
		for(int i = 0; i < list1.size(); i++){
			if(list1.get(i) == null){
				list1.set(i, "");
			}
		}
		product.setVersion(list1.get(0));
		product.setColor(list1.get(1));
		product.setSize(list1.get(2));
		return product;
	}
	
	public String addProductArrivalNotice(int userId, int productId){
		String isSetted = "";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("productId", productId);
		//检查是否设置过
		if(noticeOfArrivalDAO.selectProductArrivalNotice(map) == 1){
			isSetted = "已设置过";
		}else{
			//设置提醒
			noticeOfArrivalDAO.addProductArrivalNotice(map);
			isSetted = "到货通知设置成功!";
		}		
		return isSetted;
	}
	public void deleteProductArrivalNotice(int userId, int productId){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("productId", productId);
		noticeOfArrivalDAO.deleteProductArrivalNotice(map);
	}
	
	public List<Product> selectProductColor(String productName, String version){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productName", productName);
		map.put("version", version);
		return productDAO.selectProductColor(map);
	}
	

}
