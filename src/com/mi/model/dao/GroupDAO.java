package com.mi.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.Group;

public interface GroupDAO {
	
	public List<Group> getProductGroups(int groupProductId);
	
	public void addGroup(@Param("groupProductId") int groupProductId, @Param("userName") String userName);
	
	public int getGroupId(@Param("groupProductId") int groupProductId, @Param("userName") String userName);
	
}
