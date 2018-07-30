package com.mi.model.dao;

import java.util.Date;
import java.util.List;

import com.mi.model.bean.GroupProduct;
import com.mi.model.bean.Product;
import com.mi.model.bean.ProductFirstClass;
import com.mi.model.bean.ProductSecondClass;
import com.mi.model.bean.SpikeProduct;


public interface ManageDAO {

	public List<SpikeProduct> getSpikeProductByTime(Date d);

	public void addSpikeProduct(SpikeProduct p);
	
	public void addGroupProduct(int productId,float groupPrice,int leastGroupNum,int maxGroupProductNum,Date beginDate,Date endDate);

	public void addStock(int stock,int productId);
	
	public void modifyStock(int stock,int productId);
	
	public void modifySpikeProduct(int id,float spikePrice,int spikeQuantity);
	
	public void modifyGroupProduct(int id,float groupPrice,int leastGroupNum,int maxGroupProductNum);

	public List<ProductFirstClass> getProductFirstClass();

	public List<ProductSecondClass> getProductSecondClass(int id);

	public List<Product> getProductBySecondClassId(int id);

	public Product getProductById(int id);

	public List<Product> getProductBySecondClassIdAndTime(int id, Date d);

	public void deleteSpikeProduct(int spikeProductId);

	public List<GroupProduct> getGroupProduct(Date date);

	public int getSpikeQuantity(int spikeProductId);

	public int getGroupQuantity(int groupProductId);

	public void deleteGrorupProduct(int groupProductId);

}
