package com.mi.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.Comment;
import com.mi.model.bean.CommentResponse;
import com.mi.model.bean.Product;
import com.mi.model.bean.User;
import com.mi.model.dao.CommentDAO;

@Service
public class CommentService {
	@Autowired
	private CommentDAO commentDAO;

	public Map<String, Object> getWaitCommentProduct(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Product> products = commentDAO.getWaitCommentProduct(user);
		map.put("list", products);
		return map;
	}

	public void addCommentProduct(Comment comment) {
		commentDAO.addCommentProduct(comment);
	}

	public Map<String, Object> getCommentedProduct(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Product> products = commentDAO.getCommentedProduct(user);
		map.put("list", products);
		return map;
	}

	public Comment getCommentByUserAndProduct(int userId, Integer productId) {
		return commentDAO.getCommentByUserAndProduct(userId,productId);
	}

	public void addCommentResponse(CommentResponse commentResponse) {
		commentDAO.addCommentResponse(commentResponse);
	}

	public Comment getCommentById(Integer commentId) {
		return commentDAO.getCommentById(commentId);
	}

	public Map<String, Object> getCommentsByName(String productName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> ids = commentDAO.getHotCommentIds(new int[1], productName);
		if (ids==null || ids.size()==0) {
			map.put("hotComments", new ArrayList<>());
			map.put("newComments", new ArrayList<>());
			map.put("goodNum", 0);
			map.put("middleNum", 0);
			map.put("badNum", 0);
			return map;
		}
		List<Comment> hotComments = commentDAO.getHotComments(ids,productName);
		Collections.sort(hotComments, new Comparator<Comment>() {

			@Override
			public int compare(Comment arg0, Comment arg1) {
				return arg1.getCommentResponses().size()-arg0.getCommentResponses().size();
			}
		});
		List<Comment> newComments = commentDAO.getNewComments(productName);
		int goodNum = commentDAO.getGoodCommentsNum(productName);
		int middleNum = commentDAO.getMiddleCommentsNum(productName);
		int badNum = commentDAO.getBadCommentsNum(productName);
		map.put("hotComments", hotComments);
		map.put("newComments", newComments);
		map.put("goodNum", goodNum);
		map.put("middleNum", middleNum);
		map.put("badNum", badNum);
		return map;
	}

	public Map<String, Object> getCommentsByNameAndRank(String productName,int rank) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Comment> comments = commentDAO.getCommentsByNameAndRank(productName,rank);
		
		int goodNum = commentDAO.getGoodCommentsNum(productName);
		int middleNum = commentDAO.getMiddleCommentsNum(productName);
		int badNum = commentDAO.getBadCommentsNum(productName);
		
		map.put("comments", comments);
		map.put("goodNum", goodNum);
		map.put("middleNum", middleNum);
		map.put("badNum", badNum);
		
		return map;
		
	}

	public Map<String, Object> getCommentsByNameRankPage(String productName, int rank, int page) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Comment> comments = commentDAO.getCommentsByNameRankPage(productName,rank,page);
		
		map.put("comments", comments);
		
		return map;
	}
	
	
}
