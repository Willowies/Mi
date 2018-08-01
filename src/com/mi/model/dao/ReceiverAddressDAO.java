package com.mi.model.dao;

import java.util.List;

import com.mi.model.bean.ReceiverAddress;

public interface ReceiverAddressDAO {
	
	public List<ReceiverAddress> selectAddress(Integer userId);

}
