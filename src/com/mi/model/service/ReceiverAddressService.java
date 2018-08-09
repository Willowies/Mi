package com.mi.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mi.model.bean.ReceiverAddress;
import com.mi.model.dao.ReceiverAddressDAO;

@Service
public class ReceiverAddressService {
	@Autowired
	private ReceiverAddressDAO receiverAddressDAO;
	
	public Map<String, Object> selectReceiverAddress(Integer userId,int pageNum,int pageSize){
		Page<ReceiverAddress> page = PageHelper.startPage(pageNum, pageSize);
		receiverAddressDAO.selectReceiverAddressByUserId(userId);
		List<ReceiverAddress> list = page.getResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageTotal", page.getPages());
		return map;
	}
	public void addReceiverAddress(ReceiverAddress receiverAddress){
		receiverAddressDAO.addReceiverAddress(receiverAddress);
	}
	public void deleteReceiverAddress(Integer receiverAddressId){
		receiverAddressDAO.deleteReceiverAddressById(receiverAddressId);
	}
	public void updateReceiverAddress(ReceiverAddress receiverAddress){
		receiverAddressDAO.updateReceiverAddress(receiverAddress);
	}
	
	
}
