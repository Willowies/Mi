package com.mi.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.LikeProduct;
import com.mi.model.bean.Product;

public interface LikeProductDAO {
	public List<LikeProduct> selectLikeProductByUserId(@Param("userId") int userId);
	public int selectLikeProductCount(@Param("userId")int userId);
	public int deleteLikeProduct(@Param("likeProductId")int likeProductId);
	public int selectUnpayOrderCount(@Param("userId")int userId);
	public int selectUncommentOrderCount(@Param("userId")int userId);
	public int selectPendingOrderCount(@Param("userId")int userId);
	public List<Product> selectClassfiedProductBySecondClassId(@Param("secondClassId") int secondClassId);
}
