package com.mi.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mi.model.bean.LikeProduct;
import com.mi.model.bean.Order;
import com.mi.model.bean.Product;
import com.mi.model.dao.LikeProductDAO;

@Service
public class LikeProductService {
	@Autowired
	private LikeProductDAO likeProductDAO;
	
	public Map<String, Object> selectLikeProductByUserId(Integer userId,int pageNum,int pageSize){
		Page<LikeProduct> page = PageHelper.startPage(pageNum, pageSize);
		likeProductDAO.selectLikeProductByUserId(userId);
		List<LikeProduct> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());
		return map;
	}
	public int selectLikeProductCount(Integer userId){
		return likeProductDAO.selectLikeProductCount(userId);
	}
	public void deleteLikeProduct(Integer likeProductId){
		likeProductDAO.deleteLikeProduct(likeProductId);
	}
	public int selectUnpayOrderCount(int userId){
		return likeProductDAO.selectUnpayOrderCount(userId);
	}
	public int selectUncommentOrderCount(int userId){
		return likeProductDAO.selectUncommentOrderCount(userId);
	}
	public int selectPendingOrderCount(int userId){
		return likeProductDAO.selectPendingOrderCount(userId);
	}
	public Map<String, Object> selectClassfiedProductBySecondClassId(int secondClassId,int pageNum){
		Page<Product> page = PageHelper.startPage(pageNum, 5);
		likeProductDAO.selectClassfiedProductBySecondClassId(secondClassId);
		List<Product> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());
		return map;
	}
}
