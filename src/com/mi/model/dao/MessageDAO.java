package com.mi.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.Message;

public interface MessageDAO {
	public List<Message> selectMessageByUserId(@Param("userId")int userId);
}
