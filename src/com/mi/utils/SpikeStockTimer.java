package com.mi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mi.model.service.ProductSpikeService;

@Component
public class SpikeStockTimer {
	
	@Autowired
	private ProductSpikeService productSpikeService;
	
	@Scheduled(cron="0 0 11,13,19,21,23 * * ?")
	public void handleSpikeStock(){
		productSpikeService.updateSpikeStock();
	}	

}
