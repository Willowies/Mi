package com.mi.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mi.model.bean.Comment;
import com.mi.model.bean.Product;
import com.mi.model.dao.CommentDAO;
import com.mi.model.dao.SearchDAO;
import com.mi.model.po.SearchResult;

@Service
public class SearchService {
	@Autowired
	private SearchDAO searchDAO;

	public Map<String, Object> getSearchProducts(int userId, String text, String secondClassName, String searchType, String requireCondition, int pageNum,
			int pageSize) {
		List<Product> list = null;
		int pageTotal = 1;
		if (requireCondition.equals("")) {
			Page<Product> page = PageHelper.startPage(pageNum, pageSize);
			List<Product> products = searchDAO.getSearchProducts(text, secondClassName);
			list = page.getResult();
			pageTotal = page.getPages();
		}
		if (requireCondition.equals("评价")) {
			Page<Product> page = PageHelper.startPage(pageNum, pageSize);
			List<Product> products = searchDAO.getSearchProductsWithComment(text, secondClassName);
			list = page.getResult();
			pageTotal = page.getPages();
		}
		if (requireCondition.equals("有货")) {
			Page<Product> page = PageHelper.startPage(pageNum, pageSize);
			List<Product> products = searchDAO.getSearchProductsWithStock(text, secondClassName);
			list = page.getResult();
			pageTotal = page.getPages();
		}
		

		if (list == null || list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", null);
			map.put("pageTotal", 1);
			return map;
		}

		List<SearchResult> results = transformList(list);

		if (searchType.equals("推荐") || searchType.equals("")) {

		}
		if (searchType.equals("价格高")) {
			Collections.sort(results, new Comparator<SearchResult>() {

				@Override
				public int compare(SearchResult o1, SearchResult o2) {
					return (int) (o2.getProductPrice()-o1.getProductPrice());
				}
			});
		}
		if (searchType.equals("价格低")) {
			Collections.sort(results, new Comparator<SearchResult>() {

				@Override
				public int compare(SearchResult o1, SearchResult o2) {
					return (int) (o1.getProductPrice()-o2.getProductPrice());
				}
			});
		}
		if (searchType.equals("评论")) {
			Collections.sort(results, new Comparator<SearchResult>() {

				@Override
				public int compare(SearchResult o1, SearchResult o2) {
					return o2.getCommentNum()-o1.getCommentNum();
				}
			});
		}
		
		if (userId != 0) {
			List<Integer> ids = searchDAO.getLikeProductId(userId);
			
			for (SearchResult r : results) {
				for (Product p : r.getProducts()) {
					for (int i : ids) {
						System.out.println("like id "+i+" pId "+p.getProductId());
						if (p.getProductId()==i) {
							p.setLikeProduct(1);
						}
					}
				}
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", results);
		map.put("pageTotal", pageTotal);
		return map;
	}

	public List<SearchResult> transformList(List<Product> list) {
		List<SearchResult> results = new ArrayList<SearchResult>();
		for (Product p : list) {
			int flag = 0;
			String tempName = p.getProductName() + (p.getSize()==null?"":p.getSize()) + (p.getVersion()==null?"":p.getVersion()) ;
			for (SearchResult r : results) {
				if (r.getProductName().equals(tempName)) {
					flag = 1;
					if (r.getProducts() == null) {
						List<Product> t = new ArrayList<Product>();
						t.add(p);
						r.setProducts(t);
					} else {
						r.getProducts().add(p);
					}
					if (r.getComment() == null) {
						if (p.getComment() != null) {
							r.setComment(p.getComment());
						}
					}
					r.setCommentNum(r.getCommentNum()+p.getProductCommentNum()); 
				}
			}
			if (flag == 0) {
				SearchResult tempR = new SearchResult();
				tempR.setPicUrl(p.getPicUrl());
				tempR.setProductName(tempName);
				tempR.setProductOriginalName(p.getProductName());

				List<Product> t = new ArrayList<Product>();
				t.add(p);
				tempR.setProductPrice(p.getProductPrice());
				tempR.setProducts(t);
				if (p.getComment() != null) {
					tempR.setComment(p.getComment());
				}
				tempR.setCommentNum(tempR.getCommentNum()+p.getProductCommentNum()); 
				results.add(tempR);
			}
		}
		return results;
	}

	public void addLikeProduct(int userId, int productId) {
		searchDAO.addLikeProduct(userId,productId);
		
	}

}
