package com.mi.model.dao;

import java.util.List;
import java.util.Map;

public interface NoticeOfArrivalDAO {
	
	public void addProductArrivalNotice(Map<String,Object> map);
	
	public List<Integer> selectProductArrivalNotice(Map<String,Object> map);
	
	public void deleteProductArrivalNotice(Map<String,Object> map);

}
