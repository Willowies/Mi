package com.mi.model.dao;

import java.util.Date;
import java.util.List;

import com.mi.model.bean.SpikeProduct;

public interface SpikeProductDAO {
	
	public List<SpikeProduct> selectSpikeProduct(Date spikeTime);
	
	public SpikeProduct selectSpikeProductById(int spikeProductId);
	
	public List<SpikeProduct> selectIndexSpikeProduct(Date currentDate);
	
	public List<SpikeProduct> selectSpikeStock(Date startTime);

}
