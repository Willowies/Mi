package com.mi.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.Message;

public interface MessageDAO {
	public List<Message> selectMessageByUserId(@Param("userId")int userId,@Param("messageType")int messageType);
	
	public void addMessage(Map<String,Object> map);
}
