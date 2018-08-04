package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import com.mi.model.bean.Coupon;

public interface CouponDAO {
	
	public List<Coupon> selectCoupon(String productName);
	
	public int selectValidateCoupon(Map<String, Object> map);
	
	public void updateReceiveCoupon(Map<String, Object> map);

}
