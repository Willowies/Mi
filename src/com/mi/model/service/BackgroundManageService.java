package com.mi.model.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.model.bean.GroupProduct;
import com.mi.model.bean.Product;
import com.mi.model.bean.ProductFirstClass;
import com.mi.model.bean.ProductSecondClass;
import com.mi.model.bean.SpikeProduct;
import com.mi.model.dao.ManageDAO;



@Service
public class BackgroundManageService {
	@Autowired
	private ManageDAO manageDAO;

	public Map<String, Object> getSpikeProductByTime(Date d) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SpikeProduct> products = manageDAO.getSpikeProductByTime(d);
		map.put("list", products);
		return map;
	}

	public Map<String, Object> getProductFirstClass() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProductFirstClass> products = manageDAO.getProductFirstClass();
		map.put("list", products);
		return map;
	}

	public Map<String, Object> getProductSecondClass(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProductSecondClass> products = manageDAO.getProductSecondClass((int)id);
		map.put("list", products);
		return map;
	}

	public Map<String, Object> getProductBySecondClassId(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Product> products = manageDAO.getProductBySecondClassId((int)id);
		map.put("list", products);
		return map;
	}

	public Product getProductById(Integer id) {
		return manageDAO.getProductById((int)id);
	}

	public Product addProductStock(Integer stock, Integer id) {
		manageDAO.addStock((int)stock, (int)id);
		return manageDAO.getProductById((int)id);
	}

	public Map<String, Object> getProductBySecondClassIdAndTime(Integer id, Date d) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Product> products = manageDAO.getProductBySecondClassIdAndTime((int)id,d);
		map.put("list", products);
		return map;
	}

	public void addSpikeProduct(SpikeProduct p) {
		manageDAO.addSpikeProduct(p);
		manageDAO.modifyStock(p.getSpikeQuantity(), p.getProductId());
	}

	public void modifySpikeProduct(SpikeProduct p) {
		int quantity = manageDAO.getSpikeQuantity(p.getSpikeProductId());
		manageDAO.modifySpikeProduct(p.getSpikeProductId(), p.getSpikePrice(), p.getSpikeQuantity());
		if (p.getSpikeQuantity()!=quantity) {
			manageDAO.modifyStock(p.getSpikeQuantity()-quantity, p.getProductId());
		}
	}

	public void deleteSpikeProduct(SpikeProduct p) {
		int quantity = manageDAO.getSpikeQuantity(p.getSpikeProductId());
		manageDAO.deleteSpikeProduct(p.getSpikeProductId());
		manageDAO.modifyStock(-quantity, p.getProductId());
	}

	public Map<String, Object> getGroupProduct() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<GroupProduct> products = manageDAO.getGroupProduct(new Date());
		map.put("list", products);
		return map;
	}

	public void addGroupProduct(GroupProduct p) {
		manageDAO.addGroupProduct(p.getProduct().getProductId(), p.getGroupPrice(), p.getLeastGroupNum(), p.getMaxGroupProductNum(), p.getBeginDate(), p.getEndDate());
		manageDAO.modifyStock(p.getMaxGroupProductNum(), p.getProduct().getProductId());
	}

	public void modifyGroupProduct(GroupProduct p) {
		int quantity = manageDAO.getGroupQuantity(p.getGroupProductId());
		manageDAO.modifyGroupProduct(p.getGroupProductId(), p.getGroupPrice(), p.getLeastGroupNum(), p.getMaxGroupProductNum());
		if (p.getMaxGroupProductNum()!=quantity) {
			manageDAO.modifyStock(p.getMaxGroupProductNum()-quantity, p.getGroupProductId());
		}
	}

	public void deleteGroupProduct(GroupProduct p) {
		int quantity = manageDAO.getGroupQuantity(p.getGroupProductId());
		manageDAO.deleteGrorupProduct(p.getGroupProductId());
		manageDAO.modifyStock(-quantity, p.getGroupProductId());
	}

	
	
	
}
