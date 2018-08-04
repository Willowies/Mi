package com.mi.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.Comment;
import com.mi.model.bean.CommentResponse;
import com.mi.model.bean.Product;
import com.mi.model.bean.User;
import com.mi.model.po.SearchResult;
import com.mi.model.service.SearchService;


@Controller
@RequestMapping("mi")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("likeProductInSeachPage")
	public @ResponseBody List<String> likeProductInSeachPage(HttpSession session, HttpServletRequest request,Integer productId) {
		List<String> list = new ArrayList<String>();
		User user = getUser(session);
		if (user == null) {
			list.add("未登录");
			return list;
		}
		if (productId==null || productId==0) {
			list.add("数据传输错误");
			return list;
		}
	
		searchService.addLikeProduct(user.getUserId(),(int)productId);
		
		list.add("成功");
		return list;
	}
	
	@RequestMapping("unlikeProductInSeachPage")
	public @ResponseBody List<String> unlikeProductInSeachPage(HttpSession session, HttpServletRequest request,Integer productId) {
		List<String> list = new ArrayList<String>();
		User user = getUser(session);
		if (user == null) {
			list.add("未登录");
			return list;
		}
		if (productId==null || productId==0) {
			list.add("数据传输错误");
			return list;
		}
	
		searchService.deleteLikeProduct(user.getUserId(),(int)productId);
		
		list.add("成功");
		return list;
	}
	
	@RequestMapping("searchProduct")
	public String searchProduct(HttpSession session, HttpServletRequest request,String requireCondition,Integer page,String text,String secondClassName,String searchType) {

		if (searchType==null) {
			searchType = "";
		}
		
		if (text==null) {
			text = "";
		}
		
		if (secondClassName==null) {
			secondClassName = "";
		}
		if (requireCondition==null) {
			requireCondition = "";
		}
		
		if (page == null || page == 0) {
			page = 1; 
		}
		
		
		User user = getUser(session);
		int userId = 0;
		if (user != null) {
			userId = user.getUserId();
		}
		
		Map<String, Object> map = searchService.getSearchProducts(userId,text,secondClassName,searchType,requireCondition,(int)page,50);
		List<SearchResult> searchResults = (List<SearchResult>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		
		if (requireCondition.equals("评价")) {
			request.setAttribute("commentFormat", 1);
		}else {
			request.setAttribute("commentFormat",  0);
		}
		
		List<String> secondClassNames = searchService.getSecondClassNames();
		
		request.setAttribute("text", text);
		request.setAttribute("searchType", searchType);
		request.setAttribute("requireCondition", requireCondition);
		request.setAttribute("secondClassName", secondClassName);
		request.setAttribute("secondClassNames", secondClassNames);
		request.setAttribute("searchResults", searchResults);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:searchProduct.jsp";
	}
	
	public User getUser(HttpSession session) {
		// User user = (User)session.getAttribute("user");

		User user = new User();
		user.setUserId(10002);
		return user;
	}
}
