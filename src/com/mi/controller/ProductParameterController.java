package com.mi.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

@Controller
@RequestMapping("mi")
public class ProductParameterController {
	@RequestMapping("displayProductParameter")
	public String displayProductParameter(Model model,@RequestParam(value="productName")String productName) {
		String productNamePinYin = convertToPinyin(productName);
		String fileName = "p-"+productNamePinYin+".jsp";
		/*ͨ���ַ�����ȡ�������Ŀ·��*/
		String PATH_CLASS_ROOT = this.getClass().getResource("/").getPath();
		String ROOT_Path = PATH_CLASS_ROOT.substring(0,PATH_CLASS_ROOT.length() - "WEB-INF\\classes\\".length());
		System.out.println(ROOT_Path);
		//ROOT_Path :D:/Users/Ayanami/workspace2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Mi/
		File file = new File(ROOT_Path+"mi\\"+fileName);
		/* 
		 * �жϲ���ҳ���Ƿ���ڣ�
		 * 1.���ڼ���ת��
		 * 2.������ת��δ�ҵ���ʾҳ��
		 * */
		String relativelyPath=System.getProperty("user.dir"); 
		System.out.println(relativelyPath);
		if(file.exists())
			return "forward:"+fileName;
		else
			return "forward:p-nofound.jsp";
	}
	
	private String convertToPinyin(String ch){
		String pinyinName = "";
		
        char[] nameChar = ch.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = 
                                           new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
            	/*������ת����ƴ��*/
                try {
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray
                                           (nameChar[i], defaultFormat)[0];
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
            else{
            	/*�Ǻ���ֱ��ƴ�Ӳ�ת��*/
            	pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }
}
