package com.mi.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.ServiceNetwork;
import com.mi.model.bean.ServiceProduct;

public interface ServiceNetworkDAO {
	
	public List<ServiceNetwork> selectSN(@Param(value="snCity")String snCity,@Param(value="secondClassId")int secondClassId);
	public List<ServiceProduct> selectAllServiceProducts();

}
