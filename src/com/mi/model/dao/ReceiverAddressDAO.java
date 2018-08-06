package com.mi.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mi.model.bean.ReceiverAddress;

public interface ReceiverAddressDAO {
	
	public List<ReceiverAddress> selectAddress(Integer userId);
	public List<ReceiverAddress> selectReceiverAddressByUserId(@Param("userId") int userId);
	public void addReceiverAddress(ReceiverAddress receiverAddress);
	public void deleteReceiverAddressById(@Param("receiverAddressId")int receiverAddressId);
	public void updateReceiverAddress(ReceiverAddress receiverAddress);	
}
