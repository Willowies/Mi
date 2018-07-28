package com.mi.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.Comment;
import com.mi.model.bean.CommentResponse;
import com.mi.model.bean.Product;
import com.mi.model.bean.User;

public interface CommentDAO {
	
	public List<Product> getWaitCommentProduct(User user);

	public void addCommentProduct(Comment comment);

	public List<Product> getCommentedProduct(User user);

	public Comment getCommentByUserAndProduct(int userId, Integer productId);

	public Comment getCommentById(int commentId);

	public void addCommentResponse(CommentResponse commentResponse);

	public List<Integer> getHotCommentIds(@Param(value = "ids")int []ids,@Param(value = "productName") String productName);
	
	public List<Comment> getHotComments(@Param(value = "ids")List<Integer> ids,@Param(value = "productName") String productName);

	public List<Comment> getNewComments(String productName);

	public int getGoodCommentsNum(String productName);

	public int getMiddleCommentsNum(String productName);

	public int getBadCommentsNum(String productName);

	public List<Comment> getCommentsByNameAndRank(@Param(value = "productName")String productName, @Param(value = "rank")int rank);
	
	public List<Product> getRecommendProducts();
	
	public List<Product> getPopularProducts();
	
	public List<Product> getPopularProductsOfAppliance();
	
	public List<Product> getPopularProductsOfCollocation();
	
}
