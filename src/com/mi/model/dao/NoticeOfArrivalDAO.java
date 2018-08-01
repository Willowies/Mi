package com.mi.model.dao;

import java.util.Map;

public interface NoticeOfArrivalDAO {
	
	public void addProductArrivalNotice(Map<String,Object> map);
	
	public int selectProductArrivalNotice(Map<String,Object> map);
	
	public void deleteProductArrivalNotice(Map<String,Object> map);

}
