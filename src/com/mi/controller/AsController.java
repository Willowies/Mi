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

	//Ajax静态判断输入的SN是否有效
	@RequestMapping("checkSN")
	public void  getCheckSn(Integer asSn, HttpServletResponse response,HttpServletRequest request ) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		OrderProduct oderProduct = asService.getOrderProBySn(asSn);
		if(oderProduct != null) {
			out.println(1);//SN是有效的
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
		//先判断MultipartFile asInvoiceUrl有没有，不然会空指针exception
		String sn = request.getParameter("asSn");
		int asSn = Integer.parseInt(sn);
	
		if (request instanceof MultipartHttpServletRequest) {	
			MultipartFile asInvoiceUrl = ((MultipartHttpServletRequest) request).getFile("asInvoiceUrl");
			
			//先判断MultipartFile asInvoiceUrl有没有，不然会空指针exception
			String oldName;
			if(asInvoiceUrl == null) {
			     oldName = "";
			}else {
				oldName = asInvoiceUrl.getOriginalFilename();
			}
			 //测试在asInvoiceUrl为null的时候，能否正常插入数据
	        if(oldName == null || "" == oldName) {
	        	// 通过sn取得商品的信息
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
	        	// 构建新的文件名
	    		String newName = System.currentTimeMillis() + oldName.substring(oldName.indexOf("."));
	    		// 文件的保存路径
	    		File file = new File("E:/invioceUrl/", newName);
	    		// 上传
	    		asInvoiceUrl.transferTo(file);
	    		
	    		// 通过sn取得商品的信息
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
			// 通过sn取得商品的信息
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
        
        return "forward:AasChooseService.jsp";//跳转到新界面的jsp
	}

	/*
	 * 使用UUID得到唯一的服务清单Id
	 */

	public static String getAsIdByUUId() {
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		String uniqueId = String.format("%015d", hashCodeV);

		// 求得时间戳
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMdd");

		// System.out.println("Current Date: " + );
		String asId = "AS" + ft.format(dNow) + uniqueId.substring(8);
		return asId;
	}


	//@SuppressWarnings("unused")
	// 选择服务类型的页面数据
	@RequestMapping("asChooseService")
	public String AddTableChooseService(HttpSession chooseServiceSession, Model model, String asWay,
			String asDescription, String asBack,MultipartFile asRepairProUrl) throws IllegalStateException, IOException {
		//将上个页面的数据从session里面取出来
		AsTable asTableChooseService = (AsTable) chooseServiceSession.getAttribute("asTableChoosePro");
		//获取页面的数据
		asTableChooseService.setAsWay(asWay);
		asTableChooseService.setAsDescription(asDescription);	
		asTableChooseService.setAsBack(asBack);


		//先去判断上传的文件是否为空
		String oldRepairName;
		if (asRepairProUrl == null) {
			oldRepairName = "";
		}else {
			oldRepairName = asRepairProUrl.getOriginalFilename();
		}
		
		//不为空的话在去获得文件的名字
		if(oldRepairName == null || "" == oldRepairName) {
			// 再把数据存储到session里面
			chooseServiceSession.setAttribute("asTableChooseService", asTableChooseService);
		}else {
			// 构建新的文件名
			String newRepairName = System.currentTimeMillis() + oldRepairName.substring(oldRepairName.indexOf("."));
			// 文件的保存路径
		    File file = new File("E:/asRepairProUrl/", newRepairName);
			// 上传
		    asRepairProUrl.transferTo(file);

			asTableChooseService.setAsRepairProUrl(newRepairName);

			// 再把数据存储到session里面
			chooseServiceSession.setAttribute("asTableChooseService", asTableChooseService);
		}
		
		return "forward:AasFillAppForm.jsp";//跳转到新页面
	}

	@RequestMapping("asFillForm")
	public String AddAsTable(HttpSession session, HttpServletRequest request) {
		// 从session 里面拿出之前存储的值
		AsTable asTable = (AsTable) session.getAttribute("asTableChooseService");
		
		// 从request里面拿出地址信息
		String asPerson = request.getParameter("asPerson");
		String asPhone = request.getParameter("asPhone");
		String asAddress = request.getParameter("province") + request.getParameter("city")
				+ request.getParameter("town") + request.getParameter("addressDetail");
		// 获取当前时间
		Date timeNow = new Date();
		SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String asTime = ft1.format(timeNow);
		// 把新的信息传入asTable里面,终于形成一个完整的数据
		asTable.setAsAddress(asAddress);
		asTable.setAsPerson(asPerson);
		asTable.setAsPhone(asPhone);
		asTable.setAsState("7002");// 正在审核
		asTable.setAsTime(asTime);
		asTable.setAsId(getAsIdByUUId());
		
		
		//为了下一个页面的数据，依旧把数据存到session里面
	    session.setAttribute("asTable", asTable);
		//存储到数据库里面
		asService.insertAsInfo(asTable);
		
		//将此数据传向updateStateAuto()方法，方便去改变状态
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
	 * 分页显示查询结果
	 */
	@RequestMapping("asSelectTables")
	public String selectTables(Model model,@RequestParam(defaultValue="1" ,required=true,value="pageNo") Integer pageNo) {
		int pageSize = 5;//每页显示记录数
		PageInfo<AsTable> pageInfo = asService.getAllTables(pageNo,pageSize);//获取所有的申请单
		
		model.addAttribute("pageInfo", pageInfo);
		
		return "forward:AasServiceLog.jsp";
	}
	
	@RequestMapping("asTableDetail")
	public String asTableDetail(String asId,HttpSession session) {
		AsTable asTable = asService.getTableBySn(asId);
		session.setAttribute("asTable", asTable);
		return "forward:AasServiceDetail.jsp";
		
	}
	
	//这个是取消状态的那个页面
	@RequestMapping("asChangeTableState")
	public String updateTableState(String asId,HttpSession session) {
		asService.updateState(asId);//先去改变状态
		AsTable asTable = asService.getTableBySn(asId);//改变状态之后再去获得这个asId的售后服务表
		session.setAttribute("asTable", asTable);
		//return "forward:asServiceDetail.jsp";
		return "forward:AasServiceDetail.jsp";
	}
	
	//根据订单ID得到所有的订单
	@RequestMapping("getAllOrders")
	public String getAllOrder(HttpSession session) {
		List<Order> orders = asService.getAllOrder();
		session.setAttribute("orders", orders);
		return "forward:AasOrder.jsp";
	}
	
	/**
	 * 根据订单ID显示订单内的商品信息
	 * 通过订单ID得到orderProduct里面的记录
	 * 一个orderid对应多个orderproduct的记录
	 */

	@RequestMapping("showOrderPro")
	public String getOrderPro(int orderId,HttpSession session) {
		List<OrderProduct> orderProducts = asService.getOrderProById(orderId);
		
	    
	    List<AsTable> tableList = new ArrayList();
		//遍历orderProducts，把他的元素加载到astable里面去
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
	 * 自动改变申请单的状态
	 * 由正在审核（7002），变为已完成（7001）
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


















