package com.mi.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mi.model.bean.Coupon;
import com.mi.model.bean.Message;
import com.mi.model.dao.CouponDAO;

@Service
public class CouponService {
	@Autowired
	private CouponDAO couponDAO;
	
	public  Map<String, Object> selectCouponByUserId(int userId,int couponStatus,int pageNum,int pageSize){
		Page<Coupon> page = PageHelper.startPage(pageNum, pageSize);
		couponDAO.selectCouponByUserId(userId,couponStatus);
		List<Coupon> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());
		return map;
	}
}
