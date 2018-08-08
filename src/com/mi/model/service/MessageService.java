package com.mi.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mi.model.bean.Message;
import com.mi.model.bean.Order;
import com.mi.model.dao.MessageDAO;

@Service
public class MessageService {
	@Autowired
	private MessageDAO messageDAO;
	public Map<String, Object> selectMessageByUserId(Integer userId,int  messageType,int pageNum,int pageSize){
		Page<Message> page = PageHelper.startPage(pageNum, pageSize);
		messageDAO.selectMessageByUserId(userId, messageType);
		List<Message> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());
		return map; 
	}
}
