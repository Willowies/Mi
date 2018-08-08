package com.mi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mi.model.service.ProductSpikeService;

@Component
public class SpikeStockTimer {
	
	@Autowired
	private ProductSpikeService productSpikeService;
	
	@Scheduled(cron="0 0 0 * * ?")
	public void handleSpikeStock(){
		System.out.println("进入定时任务");
		productSpikeService.updateSpikeStock();
	}	

}
