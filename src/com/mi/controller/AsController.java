package com.mi.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.mi.model.bean.AsProInfo;
import com.mi.model.bean.AsTable;
import com.mi.model.bean.Order;
import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.Product;
import com.mi.model.service.AsService;

import jdk.nashorn.internal.AssertsEnabled;

@Controller
@RequestMapping("mi")
public class AsController {
	@Autowired
	private AsService asService;

	//Ajax��̬�ж������SN�Ƿ���Ч
	@RequestMapping("checkSN")
	public void  getCheckSn(Integer asSn, HttpServletResponse response,HttpServletRequest request ) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		OrderProduct oderProduct = asService.getOrderProBySn(asSn);
		if(oderProduct != null) {
			out.println(1);//SN����Ч��
		}else {
			out.println(0);
		}
		
		out.flush();
		out.close();
	}
	
	
	
	/**
	 * 
	 * @param session
	 * @param asSn
	 * @param asInvoiceUrl
	 * @return
	 * @throws Exception
	 */
	//@SuppressWarnings("unused")    Integer asSn, MultipartFile asInvoiceUrl,
	@RequestMapping("asChoosePro")
	public String AddTableChoosePro(HttpSession session, HttpServletRequest request) throws Exception {
		//���ж�MultipartFile asInvoiceUrl��û�У���Ȼ���ָ��exception
		String sn = request.getParameter("asSn");
		int asSn = Integer.parseInt(sn);
	
		if (request instanceof MultipartHttpServletRequest) {	
			MultipartFile asInvoiceUrl = ((MultipartHttpServletRequest) request).getFile("asInvoiceUrl");
			
			//���ж�MultipartFile asInvoiceUrl��û�У���Ȼ���ָ��exception
			String oldName;
			if(asInvoiceUrl == null) {
			     oldName = "";
			}else {
				oldName = asInvoiceUrl.getOriginalFilename();
			}
			 //������asInvoiceUrlΪnull��ʱ���ܷ�������������
	        if(oldName == null || "" == oldName) {
	        	// ͨ��snȡ����Ʒ����Ϣ
	        	AsProInfo proInfo = asService.getProBySn(asSn);
	    		
	    		AsTable asTableChoosePro = new AsTable();
	    		asTableChoosePro.setAsSn(asSn);
	    		
	    		asTableChoosePro.setAsProId(proInfo.getProductId());
	    		asTableChoosePro.setProductName(proInfo.getProductName());
	    		asTableChoosePro.setVersion(proInfo.getVersion());
	    		asTableChoosePro.setColor(proInfo.getColor());
	    		asTableChoosePro.setPicUrl(proInfo.getPicUrl());
	    		
	    		session.setAttribute("asTableChoosePro", asTableChoosePro);
	        }else {
	        	// �����µ��ļ���
	    		String newName = System.currentTimeMillis() + oldName.substring(oldName.indexOf("."));
	    		// �ļ��ı���·��
	    		File file = new File("E:/invioceUrl/", newName);
	    		// �ϴ�
	    		asInvoiceUrl.transferTo(file);
	    		
	    		// ͨ��snȡ����Ʒ����Ϣ
	    	    AsProInfo proInfo = asService.getProBySn(asSn);
	    		
	    		AsTable asTableChoosePro = new AsTable();
	    		asTableChoosePro.setAsSn(asSn);
	    		asTableChoosePro.setAsInvoiceUrl(newName);
	    		
	    		asTableChoosePro.setAsProId(proInfo.getProductId());
	    		asTableChoosePro.setProductName(proInfo.getProductName());
	    		asTableChoosePro.setVersion(proInfo.getVersion());
	    		asTableChoosePro.setColor(proInfo.getColor());
	    		asTableChoosePro.setPicUrl(proInfo.getPicUrl());
	    		session.setAttribute("asTableChoosePro", asTableChoosePro);
	        }
		}else {
			// ͨ��snȡ����Ʒ����Ϣ
        	AsProInfo proInfo = asService.getProBySn(asSn);
    		
    		AsTable asTableChoosePro = new AsTable();
    		asTableChoosePro.setAsSn(asSn);
    		
    		asTableChoosePro.setAsProId(proInfo.getProductId());
    		asTableChoosePro.setProductName(proInfo.getProductName());
    		asTableChoosePro.setVersion(proInfo.getVersion());
    		asTableChoosePro.setColor(proInfo.getColor());
    		asTableChoosePro.setPicUrl(proInfo.getPicUrl());
    		
    		session.setAttribute("asTableChoosePro", asTableChoosePro);
		}
        
        return "forward:AasChooseService.jsp";//��ת���½����jsp
	}

	/*
	 * ʹ��UUID�õ�Ψһ�ķ����嵥Id
	 */

	public static String getAsIdByUUId() {
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// �п����Ǹ���
			hashCodeV = -hashCodeV;
		}
		// 0 ����ǰ�油��0
		// 4 ������Ϊ4
		// d �������Ϊ������
		String uniqueId = String.format("%015d", hashCodeV);

		// ���ʱ���
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMdd");

		// System.out.println("Current Date: " + );
		String asId = "AS" + ft.format(dNow) + uniqueId.substring(8);
		return asId;
	}


	//@SuppressWarnings("unused")
	// ѡ��������͵�ҳ������
	@RequestMapping("asChooseService")
	public String AddTableChooseService(HttpSession chooseServiceSession, Model model, String asWay,
			String asDescription, String asBack,MultipartFile asRepairProUrl) throws IllegalStateException, IOException {
		//���ϸ�ҳ������ݴ�session����ȡ����
		AsTable asTableChooseService = (AsTable) chooseServiceSession.getAttribute("asTableChoosePro");
		//��ȡҳ�������
		asTableChooseService.setAsWay(asWay);
		asTableChooseService.setAsDescription(asDescription);	
		asTableChooseService.setAsBack(asBack);


		//��ȥ�ж��ϴ����ļ��Ƿ�Ϊ��
		String oldRepairName;
		if (asRepairProUrl == null) {
			oldRepairName = "";
		}else {
			oldRepairName = asRepairProUrl.getOriginalFilename();
		}
		
		//��Ϊ�յĻ���ȥ����ļ�������
		if(oldRepairName == null || "" == oldRepairName) {
			// �ٰ����ݴ洢��session����
			chooseServiceSession.setAttribute("asTableChooseService", asTableChooseService);
		}else {
			// �����µ��ļ���
			String newRepairName = System.currentTimeMillis() + oldRepairName.substring(oldRepairName.indexOf("."));
			// �ļ��ı���·��
		    File file = new File("E:/asRepairProUrl/", newRepairName);
			// �ϴ�
		    asRepairProUrl.transferTo(file);

			asTableChooseService.setAsRepairProUrl(newRepairName);

			// �ٰ����ݴ洢��session����
			chooseServiceSession.setAttribute("asTableChooseService", asTableChooseService);
		}
		
		return "forward:AasFillAppForm.jsp";//��ת����ҳ��
	}

	@RequestMapping("asFillForm")
	public String AddAsTable(HttpSession session, HttpServletRequest request) {
		// ��session �����ó�֮ǰ�洢��ֵ
		AsTable asTable = (AsTable) session.getAttribute("asTableChooseService");
		
		// ��request�����ó���ַ��Ϣ
		String asPerson = request.getParameter("asPerson");
		String asPhone = request.getParameter("asPhone");
		String asAddress = request.getParameter("province") + request.getParameter("city")
				+ request.getParameter("town") + request.getParameter("addressDetail");
		// ��ȡ��ǰʱ��
		Date timeNow = new Date();
		SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String asTime = ft1.format(timeNow);
		// ���µ���Ϣ����asTable����,�����γ�һ������������
		asTable.setAsAddress(asAddress);
		asTable.setAsPerson(asPerson);
		asTable.setAsPhone(asPhone);
		asTable.setAsState("7002");// �������
		asTable.setAsTime(asTime);
		asTable.setAsId(getAsIdByUUId());
		
		
		//Ϊ����һ��ҳ������ݣ����ɰ����ݴ浽session����
	    session.setAttribute("asTable", asTable);
		//�洢�����ݿ�����
		asService.insertAsInfo(asTable);
		
		//�������ݴ���updateStateAuto()����������ȥ�ı�״̬
	    updateStateAuto(asTable.getAsId());		
		
		//return "forward:asFinishApply.jsp";
		return "forward:AasFinishApp.jsp";
	}
	
	@RequestMapping("finishApply")
	public String finishApply(HttpSession session) {
		AsTable asTable = (AsTable) session.getAttribute("asTable");
		session.setAttribute("asTable", asTable);
		//return "forward:asServiceDetail.jsp";
		return "forward:AasServiceDetail.jsp";
	} 
	
	/**
	 * 
	 * @param session
	 * @return
	 * ��ҳ��ʾ��ѯ���
	 */
	@RequestMapping("asSelectTables")
	public String selectTables(Model model,@RequestParam(defaultValue="1" ,required=true,value="pageNo") Integer pageNo) {
		int pageSize = 5;//ÿҳ��ʾ��¼��
		PageInfo<AsTable> pageInfo = asService.getAllTables(pageNo,pageSize);//��ȡ���е����뵥
		
		model.addAttribute("pageInfo", pageInfo);
		
		return "forward:AasServiceLog.jsp";
	}
	
	@RequestMapping("asTableDetail")
	public String asTableDetail(String asId,HttpSession session) {
		AsTable asTable = asService.getTableBySn(asId);
		session.setAttribute("asTable", asTable);
		return "forward:AasServiceDetail.jsp";
		
	}
	
	//�����ȡ��״̬���Ǹ�ҳ��
	@RequestMapping("asChangeTableState")
	public String updateTableState(String asId,HttpSession session) {
		asService.updateState(asId);//��ȥ�ı�״̬
		AsTable asTable = asService.getTableBySn(asId);//�ı�״̬֮����ȥ������asId���ۺ�����
		session.setAttribute("asTable", asTable);
		//return "forward:asServiceDetail.jsp";
		return "forward:AasServiceDetail.jsp";
	}
	
	//���ݶ���ID�õ����еĶ���
	@RequestMapping("getAllOrders")
	public String getAllOrder(HttpSession session) {
		List<Order> orders = asService.getAllOrder();
		session.setAttribute("orders", orders);
		return "forward:AasOrder.jsp";
	}
	
	/**
	 * ���ݶ���ID��ʾ�����ڵ���Ʒ��Ϣ
	 * ͨ������ID�õ�orderProduct����ļ�¼
	 * һ��orderid��Ӧ���orderproduct�ļ�¼
	 */

	@RequestMapping("showOrderPro")
	public String getOrderPro(int orderId,HttpSession session) {
		List<OrderProduct> orderProducts = asService.getOrderProById(orderId);
		
	    
	    List<AsTable> tableList = new ArrayList();
		//����orderProducts��������Ԫ�ؼ��ص�astable����ȥ
		for(OrderProduct orderProduct : orderProducts) {
			Product product =  asService.getProductById(orderProduct.getProduct().getProductId());
			
			AsTable asTable = new AsTable();
			
			asTable.setAsSn(orderProduct.getSn());
			asTable.setAsProId(product.getProductId());
			asTable.setProductName(product.getProductName());
			asTable.setVersion(product.getVersion());
			asTable.setColor(product.getColor());
			asTable.setPicUrl(product.getPicUrl());
			
			tableList.add(asTable);
		}
		session.setAttribute("tableList", tableList);
		return "forward:AasApplyByUser.jsp";
	}

	
	/**
	 * �Զ��ı����뵥��״̬
	 * ��������ˣ�7002������Ϊ����ɣ�7001��
	 */
    public void  updateStateAuto(String asId){
    	Date asAutoDate = new Date();
    	new Thread(new Runnable(){
    		public void run(){
    			while(true){
    				Date now = new Date();
    				//if(now.getTime() - orderDate.getTime()>1000*60*15){
    				if(now.getTime() - asAutoDate.getTime()>1000*60*60*24*3){
    					asService.updateStateAuto(asId);
    					break;
    				}
    				try {
    					Thread.sleep(1000);
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		}
    	}).start();

    }

}


















