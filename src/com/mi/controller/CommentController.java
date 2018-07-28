package com.mi.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mi.model.bean.Comment;
import com.mi.model.bean.CommentResponse;
import com.mi.model.bean.Order;
import com.mi.model.bean.Product;
import com.mi.model.bean.User;
import com.mi.model.service.CommentService;

@Controller
@RequestMapping("mi")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping("getWaitCommentProduct")
	public String getWaitCommentProduct(HttpSession session, HttpServletRequest request) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}

		Map<String, Object> map = commentService.getWaitCommentProduct(user);
		List<Product> products = (List<Product>) map.get("list");
		request.setAttribute("productList", products);
		return "forward:myWaitCommentProduct.jsp";
	}
	
	@RequestMapping("getCommentedProduct")
	public String getCommentedProduct(HttpSession session, HttpServletRequest request) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}

		Map<String, Object> map = commentService.getCommentedProduct(user);
		List<Product> products = (List<Product>) map.get("list");
		request.setAttribute("productList", products);
		return "forward:myCommentedProduct.jsp";
	}

	@RequestMapping("userToCommentProduct")
	public String userToCommentProduct(HttpSession session, HttpServletRequest request, Product product) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}

		if (product == null || product.getProductId() == 0) {
			System.out.println("product无效");
		}

		request.setAttribute("product", product);
		return "forward:userCommentProduct.jsp";
	}

	@RequestMapping("commentProduct")
	public String commentProduct(HttpSession session, HttpServletRequest request, Comment comment,
			MultipartFile commentPic) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}

		if (comment == null || comment.getProductId() == 0) {
			System.out.println("comment无效");
		}
		comment.setUserId(user.getUserId());
		comment.setCommentDate(new Date());

		// 文件上传
		// 获取原文件名
		String oldname = commentPic.getOriginalFilename();
		// 构建新的文件名
		String filename = System.currentTimeMillis() + oldname.substring(oldname.indexOf("."));

		File file = new File("d:/data/commentPic/", filename);
		try {
			commentPic.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comment.setCommentUrl("commentPic/"+filename);
		
		commentService.addCommentProduct(comment);

		return userToCommentDetails(session, request,comment.getProductId());
	}

	@RequestMapping("userToCommentDetails")
	public String userToCommentDetails(HttpSession session, HttpServletRequest request,Integer productId) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}

		Comment comment = commentService.getCommentByUserAndProduct(user.getUserId(),productId);
	
		request.setAttribute("comment", comment);
		return "forward:commentDetails.jsp";
	}
	
	@RequestMapping("commentDetails")
	public String commentDetails(HttpSession session, HttpServletRequest request,Integer commentId) {

		Comment comment = commentService.getCommentById(commentId);
	
		request.setAttribute("comment", comment);
		return "forward:commentDetails.jsp";
	}
	
	@RequestMapping("getCommentPage")
	public String getCommentPage(HttpSession session, HttpServletRequest request,String productName) {
		if (productName == null || productName.equals("")) {
			return "homepage.jsp";
		}
		
		Map<String, Object> map = commentService.getCommentsByName(productName);
		
		List<Comment> hotComments = (List<Comment>) map.get("hotComments");
		List<Comment> newComments = (List<Comment>) map.get("newComments");
		int goodNum = (Integer)map.get("goodNum");
		int middleNum = (Integer)map.get("middleNum");
		int badNum =(Integer) map.get("badNum");
		
		request.setAttribute("hotComments", hotComments);
		request.setAttribute("newComments", newComments);
		request.setAttribute("goodNum", goodNum);
		request.setAttribute("middleNum", middleNum);
		request.setAttribute("badNum", badNum);
		request.setAttribute("productName", productName);
		return "forward:commentProductPage.jsp";
	}
	
	@RequestMapping("responseComment")
	public String responseComment(HttpSession session, HttpServletRequest request,CommentResponse commentResponse) {
		User user = getUser(session);
		if (user == null) {
			return "homepage.jsp";
		}
		commentResponse.setUserId(user.getUserId());
		commentResponse.setCommentDate(new Date());
		commentService.addCommentResponse(commentResponse);
	
		Comment comment = commentService.getCommentByUserAndProduct(user.getUserId(),commentResponse.getProductId());
		request.setAttribute("comment", comment);
		return "forward:commentDetails.jsp";
	}
	
	@RequestMapping("getGoodCommentPage")
	public String getGoodCommentPage(HttpSession session, HttpServletRequest request,String productName) {
		if (productName == null || productName.equals("")) {
			return "homepage.jsp";
		}
		
		Map<String, Object> map = commentService.getCommentsByNameAndRank(productName,1);
		
		List<Comment> comments = (List<Comment>) map.get("comments");
		int goodNum = (Integer)map.get("goodNum");
		int middleNum = (Integer)map.get("middleNum");
		int badNum =(Integer) map.get("badNum");

		
		request.setAttribute("rankComments", comments);
		request.setAttribute("goodNum", goodNum);
		request.setAttribute("middleNum", middleNum);
		request.setAttribute("badNum", badNum);
		request.setAttribute("productName", productName);
		return "forward:commentProductPage.jsp";
	}
	
	@RequestMapping("getMiddleCommentPage")
	public String getMiddleCommentPage(HttpSession session, HttpServletRequest request,String productName) {
		if (productName == null || productName.equals("")) {
			return "homepage.jsp";
		}
		
		Map<String, Object> map = commentService.getCommentsByNameAndRank(productName,2);
		
		List<Comment> comments = (List<Comment>) map.get("comments");
		int goodNum = (Integer)map.get("goodNum");
		int middleNum = (Integer)map.get("middleNum");
		int badNum =(Integer) map.get("badNum");

		request.setAttribute("rankComments", comments);
		request.setAttribute("goodNum", goodNum);
		request.setAttribute("middleNum", middleNum);
		request.setAttribute("badNum", badNum);
		request.setAttribute("productName", productName);
		return "forward:commentProductPage.jsp";
	}
	
	@RequestMapping("getBadCommentPage")
	public String getBadCommentPage(HttpSession session, HttpServletRequest request,String productName) {
		if (productName == null || productName.equals("")) {
			return "homepage.jsp";
		}
		
		Map<String, Object> map = commentService.getCommentsByNameAndRank(productName,3);
		
		List<Comment> comments = (List<Comment>) map.get("comments");
		int goodNum = (Integer)map.get("goodNum");
		int middleNum = (Integer)map.get("middleNum");
		int badNum =(Integer) map.get("badNum");

		request.setAttribute("rankComments", comments);
		request.setAttribute("goodNum", goodNum);
		request.setAttribute("middleNum", middleNum);
		request.setAttribute("badNum", badNum);
		request.setAttribute("productName", productName);
		return "forward:commentProductPage.jsp";
	}
	
	
	public User getUser(HttpSession session) {
		// User user = (User)session.getAttribute("user");

		User user = new User();
		user.setUserId(10002);
		return user;
	}
}
