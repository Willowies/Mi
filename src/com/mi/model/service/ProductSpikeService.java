package com.mi.model.service;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.Product;
import com.mi.model.bean.SpikeProduct;
import com.mi.model.dao.MessageDAO;
import com.mi.model.dao.ProductDAO;
import com.mi.model.dao.SpikeProductDAO;
import com.mi.model.dao.SpikeRemindDAO;
import com.mi.model.dao.StockDAO;

@Service
public class ProductSpikeService {
	@Autowired
	private SpikeProductDAO spikeProductDAO;
	@Autowired
	private SpikeRemindDAO spikeRemindDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private StockDAO stockDAO;
	
	//根据秒杀场次查询秒杀商品
	public List<SpikeProduct> selectSpikeProduct(int startTime){
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");  //参数是要获取的时间字段
		Date date1 = null;
		try {
			date1 = sim.parse(currentDate);//参数是String类型时间
		} catch (ParseException e) {
			e.printStackTrace();
		}       
		String date = sim.format(date1);  //提取出当前时间的日期字段并转换成String类型
		switch(startTime){
		case 0:
			date += " 10:00:00";
			break;
		case 1:
			date += " 12:00:00";
			break;
		case 2:
			date += " 18:00:00";
			break;
		case 3:
			date += " 20:00:00";
			break;
		case 4:
			date += " 22:00:00";
			break;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		Date spikeTime = null;
		try {
			spikeTime = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<SpikeProduct> productList = spikeProductDAO.selectSpikeProduct(spikeTime);
		return productList;
	}
	
	//增加秒杀提醒记录
	public String addSpikeRemind(int spikeProductId, int userId, String remindTime){
		long stamp = new Long(remindTime);
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date remindDate = new Date(stamp);
		System.out.println(remindDate);
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("spikeProductId", spikeProductId);
		map.put("userId", userId);
		map.put("remindTime", remindDate);
		String isSetted = "";
		List<Integer> list = spikeRemindDAO.selectSpikeRemind(map);
		if(list.size() != 0){
			for(int i = 0; i < list.size(); i++){
				if(list.get(i) == 1){
					isSetted = "您已设置过了";
				}else{
					//设置提醒
					spikeRemindDAO.addSpikeRemind(map);
					isSetted = "提醒设置成功!";
				}
			}			
		}else{
			spikeRemindDAO.addSpikeRemind(map);
			isSetted = "提醒设置成功!";
			
		}					
		return isSetted;
	}
	
	//定时启动秒杀提醒
	public void addSpikeMessage(int spikeProductId, final int userId, final Date remindTime){
		//设置发送消息定时器
		final SpikeProduct spikeProduct = spikeProductDAO.selectSpikeProductById(spikeProductId);
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask(){
			@Override
			public void run() {
				addMessage(userId, remindTime, spikeProduct);				
			}};
		timer.schedule(timerTask, remindTime);
	}
	
	//立即抢购时查询抢购商品情况
	public String selectBuySpikeProduct(int spikeProductId){
		String buySucceed = "";
		SpikeProduct spikeProduct = spikeProductDAO.selectSpikeProductById(spikeProductId);
		Date currentDate = Calendar.getInstance().getTime();
		long currentTime = currentDate.getTime();
		if(currentTime <= spikeProduct.getEndTime().getTime()){
			if(spikeProduct.getCurrentSpikeNum() < spikeProduct.getSpikeQuantity()){
				//库存非空，购买成功
				buySucceed = "抢购成功";			
			}else{
				buySucceed = "超过上限";
			}	
		}else{
			//抢购时间超过结束时间
			buySucceed = "抢购已结束";
		}
			
		return buySucceed;
	}
	//把商品信息封装成OrderProduct
	public OrderProduct findSpikeProduct(int spikeProductId){
		SpikeProduct spikeProduct = spikeProductDAO.selectSpikeProductById(spikeProductId);
		Product product = selectProductById(spikeProduct.getProductId());
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setProduct(product);
		orderProduct.setAmount(spikeProduct.getSpikePrice());
		orderProduct.setProductPrice(spikeProduct.getSpikePrice());
		orderProduct.setQuantity(1);
		return orderProduct;
	}
	//根据商品ID查询商品
	public Product selectProductById(int productId){
		Product product = productDAO.selectProductById(productId);
		return product;
	}

	//首页秒杀查询秒杀商品
	public List<SpikeProduct> selectIndexSpikeProduct(String currentDate){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date spikeTime = null;
		try {
			spikeTime = format.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//long stamp = date.getTime();
		//Date currentTime = new Date(stamp);
		List<SpikeProduct> spikeList = spikeProductDAO.selectIndexSpikeProduct(spikeTime);
		for(int i = 8; i < spikeList.size(); i++){
			spikeList.remove(i);
		}
		return spikeList;
	}
	//增加提醒消息
	public void addMessage(int userId, Date sendTime, SpikeProduct spikeProduct){
		String messageTitle = "秒杀提醒";		
		String message = spikeProduct.getProductName()+""+spikeProduct.getVersion()
		+""+spikeProduct.getColor()+""+spikeProduct.getSize()+" 库存充足，您可以前去购买了。";
		String picUrl = spikeProduct.getPicUrl();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("messageTitle", messageTitle);
		map.put("message", message);
		map.put("userId", userId);
		map.put("sendTime", sendTime);
		map.put("picUrl", picUrl);
		messageDAO.addMessage(map);
	}
	
	//定时器到截止时间时，处理当场秒杀的库存
	public void updateSpikeStock(){
		List<String> activityList = getDateList();
		//遍历所有活动结束时间，定时器设定每个活动的结束时间时执行处理库存的操作
		for(int i = 0; i < activityList.size(); i++){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date exeDate = null;
			try {
				exeDate = formatter.parse(activityList.get(i));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			List<SpikeProduct> spikeProductList = spikeProductDAO.selectSpikeStock(exeDate);
			for(int j = 0; j < spikeProductList.size(); j++){
				int remainStock = spikeProductList.get(i).getSpikeQuantity() - spikeProductList.get(i).getCurrentSpikeNum();
				if(remainStock > 0){
					//秒杀商品有剩余，加到商品库存中的可分配量中
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("productId", spikeProductList.get(i).getProductId());
					map.put("remainStock", remainStock);
					stockDAO.updateSpikeStock1(map);
				}
			}
		}
	}
	//获取所有秒杀活动时间
	public List<String> getDateList(){
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");  //参数是要获取的时间字段
		Date date = null;
		try {
			date = sim.parse(currentDate);//参数是String类型时间
		} catch (ParseException e) {
			e.printStackTrace();
		}       
		String date1 = sim.format(date);  //提取出当前时间的日期字段并转换成String类型
		List<String> activityList = new ArrayList<String>();
		String activity1 = date1 + " 10:00:00";
		String activity2 = date1 + " 12:00:00";
		String activity3 = date1 + " 18:00:00";
		String activity4 = date1 + " 20:00:00";
		String activity5 = date1 + " 22:00:00";
		activityList.add(activity1);
		activityList.add(activity2);
		activityList.add(activity3);
		activityList.add(activity4);
		activityList.add(activity5);
		
		return activityList;
	}

}
