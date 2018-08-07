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
		
		//����һ��pdf������  
        PdfReader reader = new PdfReader("D:/data/pdf/order.pdf");   
        //����һ��pdfreader����һ��pdfStamper.���������µ�pdf.  
        PdfStamper stamper = new PdfStamper(reader,  
          new FileOutputStream("D:/data/pdf/����.pdf"));   
          
        //���������itext-asian.jar���Դ��� ���Բ��ÿ��ǲ���ϵͳ��������.  
        BaseFont bf = BaseFont.createFont("STSong-Light",   
                "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); // set font  
        //baseFont��֧��������ʽ�趨.����font����Ҫ�����ϵͳ֧�ִ�����������ֲ����.  
        Font font = new Font(bf,10);  
        font.setStyle(Font.BOLD);  
        font.getBaseFont();  
        //ҳ���Ǵ�1��ʼ��  
        for (int i=1; i<=reader.getNumberOfPages(); i++){  
  
           //���pdfstamper�ڵ�ǰҳ���ϲ��ӡ����.Ҳ����˵ ��Щ���ݻḲ����ԭ�ȵ�pdf����֮��.  
            PdfContentByte over = stamper.getOverContent(i);  
            //��pdfreader��õ�ǰҳ�ֵ����.�����˸�ҳ��һЩ����.�����ҳ����������Ϣ.  
            PdfDictionary p = reader.getPageN(i);  
            //�õ�mediaBox ������Ÿ�ҳpdf�Ĵ�С��Ϣ.  
           PdfObject po =  p.get(new PdfName("MediaBox"));  
           //po��һ���������.��������˸�ҳpdf�������᷶Χ.  
           PdfArray pa = (PdfArray) po;  
           
            //��ʼд���ı�  
            over.beginText();  
            //��������ʹ�С  
            over.setFontAndSize(font.getBaseFont(), 10);
            //����������ɫ
            over.setColorFill(BaseColor.BLACK); 
            //������������λ��  
            over.setTextMatrix(107, 275);   
            //Ҫ�����text  
            if (order.getInvoice().getInvoiceType()==1) {
            	 over.showText("���� " );  
			}else {
				over.showText("��λ " );  
			}
            over.endText();  
            
          //��ʼд���ı�  
            over.beginText();  
            //��������ʹ�С  
            over.setFontAndSize(font.getBaseFont(), 10);
            //����������ɫ
            over.setColorFill(BaseColor.BLACK); 
            //������������λ��  
            over.setTextMatrix(50, 200);   
            //Ҫ�����text  
            over.showText("�˷�" );    
            over.endText();  
            
            //��ʼд���ı�  
            over.beginText();  
            //��������ʹ�С  
            over.setFontAndSize(font.getBaseFont(), 10);
            //����������ɫ
            over.setColorFill(BaseColor.BLACK); 
            //������������λ��  
            over.setTextMatrix(250, 200);   
            //Ҫ�����text  
            over.showText("1"+".00" );    
            over.endText(); 
            
          //��ʼд���ı�  
            over.beginText();  
            //��������ʹ�С  
            over.setFontAndSize(font.getBaseFont(), 10);
            //����������ɫ
            over.setColorFill(BaseColor.BLACK); 
            //������������λ��  
            over.setTextMatrix(400, 200);   
            //Ҫ�����text  
            over.showText("10" );    
            over.endText(); 
            
          //��ʼд���ı�  
            over.beginText();  
            //��������ʹ�С  
            over.setFontAndSize(font.getBaseFont(), 10);
            //����������ɫ
            over.setColorFill(BaseColor.BLACK); 
            //������������λ��  
            over.setTextMatrix(500, 200);   
            //Ҫ�����text  
            over.showText("10" );    
            over.endText(); 
            
            float totalPrice = 10;
            int ind = 0;
            for (OrderProduct oP : order.getProducts()) {
            	ind++;
            	//��ʼд���ı�  
                over.beginText();  
                //��������ʹ�С  
                over.setFontAndSize(font.getBaseFont(), 10);
                //����������ɫ
                over.setColorFill(BaseColor.BLACK); 
                //������������λ��  
                over.setTextMatrix(50, 200-ind*10);   
                //Ҫ�����text  
                over.showText(oP.getProduct().getProductName());    
                over.endText();  
                
                //��ʼд���ı�  
                over.beginText();  
                //��������ʹ�С  
                over.setFontAndSize(font.getBaseFont(), 10);
                //����������ɫ
                over.setColorFill(BaseColor.BLACK); 
                //������������λ��  
                over.setTextMatrix(250, 200-ind*10);   
                //Ҫ�����text  
                over.showText(oP.getQuantity()+".00" );    
                over.endText(); 
                
              //��ʼд���ı�  
                over.beginText();  
                //��������ʹ�С  
                over.setFontAndSize(font.getBaseFont(), 10);
                //����������ɫ
                over.setColorFill(BaseColor.BLACK); 
                //������������λ��  
                over.setTextMatrix(400, 200-ind*10);   
                //Ҫ�����text  
                over.showText(oP.getProductPrice()+"" );    
                over.endText(); 
                
              //��ʼд���ı�  
                over.beginText();  
                //��������ʹ�С  
                over.setFontAndSize(font.getBaseFont(), 10);
                //����������ɫ
                over.setColorFill(BaseColor.BLACK); 
                //������������λ��  
                over.setTextMatrix(500, 200-ind*10);   
                //Ҫ�����text  
                over.showText(oP.getProductPrice()*oP.getQuantity()+"" );    
                over.endText();
                
                totalPrice += oP.getProductPrice()*oP.getQuantity();
			}
            
            
          
            
            //��ʼд���ı�  
            over.beginText();  
            //��������ʹ�С  
            over.setFontAndSize(font.getBaseFont(), 10);
            //����������ɫ
            over.setColorFill(BaseColor.BLACK); 
            //������������λ��  
            over.setTextMatrix(500, 330);   
            //Ҫ�����text  
            over.showText(order.getInvoice().getInvoiceId()+"" );    
            over.endText(); 
            
          //��ʼд���ı�  
            over.beginText();  
            //��������ʹ�С  
            over.setFontAndSize(font.getBaseFont(), 10);
            //����������ɫ
            over.setColorFill(BaseColor.BLACK); 
            //������������λ��  
            over.setTextMatrix(500, 315);   
            //Ҫ�����text 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            over.showText(format.format(order.getInvoice().getCreateDate()));    
            over.endText(); 
            
            //��ʼд���ı�  
            over.beginText();  
            //��������ʹ�С  
            over.setFontAndSize(font.getBaseFont(), 10);
            //����������ɫ
            over.setColorFill(BaseColor.BLACK); 
            //������������λ��  
            over.setTextMatrix(520, 100);   
            //Ҫ�����text  
            over.showText(totalPrice+"" );    
            over.endText(); 
            
        }  
  
        stamper.close();  
		
		String path = "D:/data/pdf/����.pdf";
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
