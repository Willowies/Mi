package com.mi.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.Product;

public interface SearchDAO {

	public List<Product> getSearchProducts(@Param(value = "text")String text,@Param(value = "secondClassName") String secondClassName);

	public List<Product> getSearchProductsWithComment(String text, String secondClassName);

	public List<Product> getSearchProductsWithStock(String text, String secondClassName);

	public List<Integer> getLikeProductId(int userId);

	public void addLikeProduct(int userId, int productId);

}
