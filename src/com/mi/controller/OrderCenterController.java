package com.mi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.mi.model.bean.Order;
import com.mi.model.bean.OrderProduct;
import com.mi.model.bean.User;
import com.mi.model.service.OrderCenterService;
import com.mi.utils.BaseController;

@Controller
@RequestMapping("mi")
public class OrderCenterController extends BaseController {
	@Autowired
	private OrderCenterService orderCenterService;

	@RequestMapping("getOrderByProductName")
	public String getOrderByProductName(HttpSession session, HttpServletRequest request, String productName,
			String orderType, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}
		int type = 0;
		if (orderType != null && orderType.equals("3")) {
			type = 3;
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getOrderByProductName(user, type, productName, page, 5);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 0);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		if (type == 0) {
			return "forward:myOrder.jsp";
		} else {
			return "forward:myGroupOrder.jsp";
		}

	}

	@RequestMapping("getOrderDetailsById")
	public String getOrderDetailsById(HttpSession session, HttpServletRequest request, Integer orderId) {
		if (orderId == null || orderId == 0) {
			return "homepage";
		}
		Order order = orderCenterService.getOrderDetailsById(orderId);

		request.setAttribute("order", order);

		return "forward:orderDetails.jsp";
	}

	@RequestMapping("getAllOrder")
	public String getAllOrder(HttpSession session, HttpServletRequest request, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getAllOrder(user, page, 5);
		List<Order> orders = (List<Order>) map.get("list");
		System.out.println(orders.size());
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 1);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}

	@RequestMapping("getOrderWaitPaid")
	public String getOrderWaitPaid(HttpSession session, HttpServletRequest request, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getOrderByState(user, page, 5, 1);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 2);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}

	@RequestMapping("getOrderWaitTaken")
	public String getOrderWaitTaken(HttpSession session, HttpServletRequest request, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getOrderByState(user, page, 5, 2);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 3);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}

	@RequestMapping("getOrderClosed")
	public String getOrderClosed(HttpSession session, HttpServletRequest request, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getOrderByState(user, page, 5, 0);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 4);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myOrder.jsp";
	}

	@RequestMapping("getAllGroupOrder")
	public String getAllGroupOrder(HttpSession session, HttpServletRequest request, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getAllGroupOrder(user, page, 5);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 1);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myGroupOrder.jsp";
	}

	@RequestMapping("getGroupOrderWaitPaid")
	public String getGroupOrderWaitPaid(HttpSession session, HttpServletRequest request, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getGroupOrderByState(user, page, 5, 1);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 2);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myGroupOrder.jsp";
	}

	@RequestMapping("getGroupOrderWaitTaken")
	public String getGroupOrderWaitTaken(HttpSession session, HttpServletRequest request, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getGroupOrderByState(user, page, 5, 2);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 3);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myGroupOrder.jsp";
	}

	@RequestMapping("getGroupOrderWaitBuilt")
	public String getGroupOrderWaitBuilt(HttpSession session, HttpServletRequest request, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getGroupOrderByState(user, page, 5, 4);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 5);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myGroupOrder.jsp";
	}

	@RequestMapping("getGroupOrderClosed")
	public String getGroupOrderClosed(HttpSession session, HttpServletRequest request, Integer page) {
		User user = getUser(session);
		if (user == null) {
			return "homepage";
		}

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = orderCenterService.getGroupOrderByState(user, page, 5, 0);
		List<Order> orders = (List<Order>) map.get("list");
		int pageTotal = (Integer) map.get("pageTotal");
		request.setAttribute("type", 4);
		request.setAttribute("orderList", orders);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		return "forward:myGroupOrder.jsp";
	}

	@RequestMapping("getInvoicePdf")
	public ResponseEntity<byte[]> getInvoicePdf(HttpServletRequest request,Integer orderId) throws Exception {
		Order order = orderCenterService.getOrderDetailsById(orderId);
		
		//创建一个pdf读入流  
        PdfReader reader = new PdfReader("D:/data/pdf/order.pdf");   
        //根据一个pdfreader创建一个pdfStamper.用来生成新的pdf.  
        PdfStamper stamper = new PdfStamper(reader,  
          new FileOutputStream("D:/data/pdf/订单.pdf"));   
          
        //这个字体是itext-asian.jar中自带的 所以不用考虑操作系统环境问题.  
        BaseFont bf = BaseFont.createFont("STSong-Light",   
                "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); // set font  
        //baseFont不支持字体样式设定.但是font字体要求操作系统支持此字体会带来移植问题.  
        Font font = new Font(bf,10);  
        font.setStyle(Font.BOLD);  
        font.getBaseFont();  
        //页数是从1开始的  
        for (int i=1; i<=reader.getNumberOfPages(); i++){  
  
           //获得pdfstamper在当前页的上层打印内容.也就是说 这些内容会覆盖在原先的pdf内容之上.  
            PdfContentByte over = stamper.getOverContent(i);  
            //用pdfreader获得当前页字典对象.包含了该页的一些数据.比如该页的坐标轴信息.  
            PdfDictionary p = reader.getPageN(i);  
            //拿到mediaBox 里面放着该页pdf的大小信息.  
           PdfObject po =  p.get(new PdfName("MediaBox"));  
           //po是一个数组对象.里面包含了该页pdf的坐标轴范围.  
           PdfArray pa = (PdfArray) po;  
           
            //开始写入文本  
            over.beginText();  
            //设置字体和大小  
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.BLACK); 
            //设置字体的输出位置  
            over.setTextMatrix(107, 275);   
            //要输出的text  
            if (order.getInvoice().getInvoiceType()==1) {
            	 over.showText("个人 " );  
			}else {
				over.showText("单位 " );  
			}
            over.endText();  
            
          //开始写入文本  
            over.beginText();  
            //设置字体和大小  
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.BLACK); 
            //设置字体的输出位置  
            over.setTextMatrix(50, 200);   
            //要输出的text  
            over.showText("运费" );    
            over.endText();  
            
            //开始写入文本  
            over.beginText();  
            //设置字体和大小  
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.BLACK); 
            //设置字体的输出位置  
            over.setTextMatrix(250, 200);   
            //要输出的text  
            over.showText("1"+".00" );    
            over.endText(); 
            
          //开始写入文本  
            over.beginText();  
            //设置字体和大小  
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.BLACK); 
            //设置字体的输出位置  
            over.setTextMatrix(400, 200);   
            //要输出的text  
            over.showText("10" );    
            over.endText(); 
            
          //开始写入文本  
            over.beginText();  
            //设置字体和大小  
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.BLACK); 
            //设置字体的输出位置  
            over.setTextMatrix(500, 200);   
            //要输出的text  
            over.showText("10" );    
            over.endText(); 
            
            float totalPrice = 10;
            int ind = 0;
            for (OrderProduct oP : order.getProducts()) {
            	ind++;
            	//开始写入文本  
                over.beginText();  
                //设置字体和大小  
                over.setFontAndSize(font.getBaseFont(), 10);
                //设置字体颜色
                over.setColorFill(BaseColor.BLACK); 
                //设置字体的输出位置  
                over.setTextMatrix(50, 200-ind*10);   
                //要输出的text  
                over.showText(oP.getProduct().getProductName());    
                over.endText();  
                
                //开始写入文本  
                over.beginText();  
                //设置字体和大小  
                over.setFontAndSize(font.getBaseFont(), 10);
                //设置字体颜色
                over.setColorFill(BaseColor.BLACK); 
                //设置字体的输出位置  
                over.setTextMatrix(250, 200-ind*10);   
                //要输出的text  
                over.showText(oP.getQuantity()+".00" );    
                over.endText(); 
                
              //开始写入文本  
                over.beginText();  
                //设置字体和大小  
                over.setFontAndSize(font.getBaseFont(), 10);
                //设置字体颜色
                over.setColorFill(BaseColor.BLACK); 
                //设置字体的输出位置  
                over.setTextMatrix(400, 200-ind*10);   
                //要输出的text  
                over.showText(oP.getProductPrice()+"" );    
                over.endText(); 
                
              //开始写入文本  
                over.beginText();  
                //设置字体和大小  
                over.setFontAndSize(font.getBaseFont(), 10);
                //设置字体颜色
                over.setColorFill(BaseColor.BLACK); 
                //设置字体的输出位置  
                over.setTextMatrix(500, 200-ind*10);   
                //要输出的text  
                over.showText(oP.getProductPrice()*oP.getQuantity()+"" );    
                over.endText();
                
                totalPrice += oP.getProductPrice()*oP.getQuantity();
			}
            
            
          
            
            //开始写入文本  
            over.beginText();  
            //设置字体和大小  
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.BLACK); 
            //设置字体的输出位置  
            over.setTextMatrix(500, 330);   
            //要输出的text  
            over.showText(order.getInvoice().getInvoiceId()+"" );    
            over.endText(); 
            
          //开始写入文本  
            over.beginText();  
            //设置字体和大小  
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.BLACK); 
            //设置字体的输出位置  
            over.setTextMatrix(500, 315);   
            //要输出的text 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            over.showText(format.format(order.getInvoice().getCreateDate()));    
            over.endText(); 
            
            //开始写入文本  
            over.beginText();  
            //设置字体和大小  
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.BLACK); 
            //设置字体的输出位置  
            over.setTextMatrix(520, 100);   
            //要输出的text  
            over.showText(totalPrice+"" );    
            over.endText(); 
            
        }  
  
        stamper.close();  
		
		String path = "D:/data/pdf/订单.pdf";
		File file = new File(path);
		HttpHeaders httpHeaders = new HttpHeaders();
		String fileName = file.getName();
		httpHeaders.setContentDispositionFormData("attachment", java.net.URLEncoder.encode(fileName, "UTF-8"));
		httpHeaders.setContentType(MediaType.parseMediaType("application/pdf"));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
	}

	public User getUser(HttpSession session) {
		 User user = (User)session.getAttribute("user");

		return user;
	}

}
