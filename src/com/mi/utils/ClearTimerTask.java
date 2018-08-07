package com.mi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mi.model.bean.Group;
import com.mi.model.bean.GroupProduct;
import com.mi.model.dao.GroupDAO;
import com.mi.model.dao.OrderDAO;
import com.mi.model.dao.StockDAO;
import com.mi.model.service.GroupPurchaseService;

import sun.tools.jar.resources.jar;

/**
 * group product clearing function
 */
@Component
public class ClearTimerTask {
	@Autowired
	private GroupPurchaseService groupPurchaseService;
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private StockDAO stockDAO;
	//get group products
	private List<GroupProduct> list = null;
	private String cron;
	private ScheduledThreadPoolExecutor exec;
			
	//everyday 00:00
	@Scheduled(cron="0 0 0 * * ? ")
	public void updateGroupProducts() throws ParseException {
		list = groupPurchaseService.getGroupProducts();
		/*
		 * date.getTime()，按时间排序
		 * 上面取出来的是未结束的团购活动
		 * 排序后仅选出当天会结束的活动,为其设置定时任务
		 */
		int min;
		GroupProduct tempGP = null;
		for(int i=0;i<list.size()-1;i++) {
			min = i;
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).getEndDate().getTime()>list.get(j).getEndDate().getTime()) {
					min = j;
				}
			}
			tempGP = list.get(i);
			list.set(i, list.get(min));
			list.set(min, tempGP);
		}
		System.out.println("list_size_get:"+list.size());
		//排除不是当天结束的团购商品
		Calendar now = Calendar.getInstance();
		String currentZero = ""+now.get(Calendar.YEAR)+"-"+now.get(Calendar.MONTH)+"-"+now.get(Calendar.DATE)+" 00:00:00";
		String currentLastMoment = ""+now.get(Calendar.YEAR)+"-"+now.get(Calendar.MONTH)+"-"+now.get(Calendar.DATE)+" 23:59:59";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDateZero = sdf.parse(currentZero);//当天零时
		Date currentDateLastMoment = sdf.parse(currentLastMoment);//当天最后一刻
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getEndDate().getTime()<currentDateZero.getTime() 
					|| list.get(i).getEndDate().getTime()>=currentDateLastMoment.getTime()) {
				list.remove(i);
				i--;
			}
		}
		System.out.println("list_size_currentday:"+list.size());
		//
		exec = new ScheduledThreadPoolExecutor(list.size());
		for(int i=0;i<list.size();i++) {
			GroupProduct temp = list.get(i);
			//calculate the delay
			long current = (new Date()).getTime();
			long delay = temp.getEndDate().getTime()-current;
			//get groups of the group product
			List<Group> listGroup = groupDAO.getProductGroups(temp.getGroupProductId());
			int leastGroupNum = temp.getLeastGroupNum();
			if(list.size()!=0) {
				exec.schedule(new Runnable() {
					@Override
					public void run() {
						for(Group g:listGroup) {
							if(g.getCurrentQuantity() >= leastGroupNum) {
								//group by group
								orderDAO.updateClearingSuccessOrder(temp.getGroupProductId(), g.getGroupId());
								stockDAO.updateClearingSuccessStock(temp.getGroupProductId(), g.getCurrentQuantity());
							}else {
								orderDAO.updateClearingFailOrder(g.getGroupId());
								stockDAO.updateClearingFailStock(temp.getGroupProductId(), g.getCurrentQuantity());
							}
							System.out.println("CLEARING: Group "+g.getGroupId()+" was cleared!");
						}
						System.out.println("CLEARING: All cleared!!!!");
					}
				}, delay, TimeUnit.MILLISECONDS);
			}
		}
	}
}



