package com.mi.model.dao;

import java.util.List;
import java.util.Map;

public interface SpikeRemindDAO {
	
	public void addSpikeRemind(Map<String, Object> map);
	
	public List<Integer> selectSpikeRemind(Map<String,Object> map);
	
	public void updateSpikeRemind(Map<String,Object> map);

}
