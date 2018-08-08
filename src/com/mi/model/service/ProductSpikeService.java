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
	
	//������ɱ���β�ѯ��ɱ��Ʒ
	public List<SpikeProduct> selectSpikeProduct(int startTime){
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");  //������Ҫ��ȡ��ʱ���ֶ�
		Date date1 = null;
		try {
			date1 = sim.parse(currentDate);//������String����ʱ��
		} catch (ParseException e) {
			e.printStackTrace();
		}       
		String date = sim.format(date1);  //��ȡ����ǰʱ��������ֶβ�ת����String����
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
	
	//������ɱ���Ѽ�¼
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
					isSetted = "�������ù���";
				}else{
					//��������
					spikeRemindDAO.addSpikeRemind(map);
					isSetted = "�������óɹ�!";
				}
			}			
		}else{
			spikeRemindDAO.addSpikeRemind(map);
			isSetted = "�������óɹ�!";
			
		}					
		return isSetted;
	}
	
	//��ʱ������ɱ����
	public void addSpikeMessage(int spikeProductId, final int userId, final Date remindTime){
		//���÷�����Ϣ��ʱ��
		final SpikeProduct spikeProduct = spikeProductDAO.selectSpikeProductById(spikeProductId);
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask(){
			@Override
			public void run() {
				addMessage(userId, remindTime, spikeProduct);				
			}};
		timer.schedule(timerTask, remindTime);
	}
	
	//��������ʱ��ѯ������Ʒ���
	public String selectBuySpikeProduct(int spikeProductId){
		String buySucceed = "";
		SpikeProduct spikeProduct = spikeProductDAO.selectSpikeProductById(spikeProductId);
		Date currentDate = Calendar.getInstance().getTime();
		long currentTime = currentDate.getTime();
		if(currentTime <= spikeProduct.getEndTime().getTime()){
			if(spikeProduct.getCurrentSpikeNum() < spikeProduct.getSpikeQuantity()){
				//���ǿգ�����ɹ�
				buySucceed = "�����ɹ�";			
			}else{
				buySucceed = "��������";
			}	
		}else{
			//����ʱ�䳬������ʱ��
			buySucceed = "�����ѽ���";
		}
			
		return buySucceed;
	}
	//����Ʒ��Ϣ��װ��OrderProduct
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
	//������ƷID��ѯ��Ʒ
	public Product selectProductById(int productId){
		Product product = productDAO.selectProductById(productId);
		return product;
	}

	//��ҳ��ɱ��ѯ��ɱ��Ʒ
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
	//����������Ϣ
	public void addMessage(int userId, Date sendTime, SpikeProduct spikeProduct){
		String messageTitle = "��ɱ����";		
		String message = spikeProduct.getProductName()+""+spikeProduct.getVersion()
		+""+spikeProduct.getColor()+""+spikeProduct.getSize()+" �����㣬������ǰȥ�����ˡ�";
		String picUrl = spikeProduct.getPicUrl();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("messageTitle", messageTitle);
		map.put("message", message);
		map.put("userId", userId);
		map.put("sendTime", sendTime);
		map.put("picUrl", picUrl);
		messageDAO.addMessage(map);
	}
	
	//��ʱ������ֹʱ��ʱ����������ɱ�Ŀ��
	public void updateSpikeStock(){
		List<String> activityList = getDateList();
		//�������л����ʱ�䣬��ʱ���趨ÿ����Ľ���ʱ��ʱִ�д�����Ĳ���
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
					//��ɱ��Ʒ��ʣ�࣬�ӵ���Ʒ����еĿɷ�������
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("productId", spikeProductList.get(i).getProductId());
					map.put("remainStock", remainStock);
					stockDAO.updateSpikeStock1(map);
				}
			}
		}
	}
	//��ȡ������ɱ�ʱ��
	public List<String> getDateList(){
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");  //������Ҫ��ȡ��ʱ���ֶ�
		Date date = null;
		try {
			date = sim.parse(currentDate);//������String����ʱ��
		} catch (ParseException e) {
			e.printStackTrace();
		}       
		String date1 = sim.format(date);  //��ȡ����ǰʱ��������ֶβ�ת����String����
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
