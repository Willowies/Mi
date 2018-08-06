package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.Coupon;

public interface CouponDAO {
	
	public List<Coupon> selectCoupon(String productName);
	
	public int selectValidateCoupon(Map<String, Object> map);
	
	public void updateReceiveCoupon(Map<String, Object> map);
	
	public List<Coupon> selectCouponByUserId(@Param("userId") int userId,@Param("couponStatus") int couponStatus);
}
