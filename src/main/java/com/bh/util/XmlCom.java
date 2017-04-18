package com.bh.util;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;


/**
 * 通过字符解析xml
 * 
 * @author:  zyy
 * @Date:2015年12月25日 下午6:13:11
 * @version: 1.0
 */
public class XmlCom{
	 static Map<String,Object>  map=new HashMap<String, Object>();
		/**
		 * 解析xml所有的节点
		 * @author:  zyy
		 * @Date:2015年12月29日 下午5:03:29
		 * @version: 1.0
		 * getAllLeafNode
		 * @param xmlDoc
		 * @return
		 * @throws DocumentException Map<String,String>
		 * @throws UnsupportedEncodingException 
		 */
		 @SuppressWarnings("unchecked")
		public  static Map<String,Object>  getAllLeafNode(String xmlDoc) throws DocumentException, UnsupportedEncodingException{
			 Document document= DocumentHelper.parseText(xmlDoc);
			 Element root=document.getRootElement();
			 return nextElement(root);
		  }
	 /**
	  * 递归解析
	  * @author:  zyy
	  * @Date:2015年12月29日 下午5:03:58
	  * @version: 1.0
	  * nextElement
	  * @param el void
	  */
	 private static Map<String,Object> nextElement(Element element){
		
		  for (int i = 0, size = element.nodeCount(); i < size; i++)     {
	           Node node = element.node(i);
	           if (node instanceof Element) {
	        	   nextElement((Element) node);
	           } else { // do something....
	        	
	        	   map.put(element.getName(), element.getData());
	           }
	       }
		return map;
	 }
	 	

	 
	 
}
