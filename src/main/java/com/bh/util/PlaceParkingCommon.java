package com.bh.util;

import java.util.Date;
import java.util.Map;

public class PlaceParkingCommon {
	/**
	 * 获取本地停车场实时数据
	 * 
	 */
	
   public static Map<String,Object> getParkCost(Map<String,Object> map){
	    String tURL="http://192.168.1.241/DealWith.ashx?LogUser=admin&LogSign=9625d9e8b009d3d056fbaa5ddc7b162b&ReqFunction=TerminalCalculate";
	    String Rtime= DateUtil.formatDate2String((Date)map.get("inTime"), "yyyyMMddHHmmss");
	    String Ctime=DateUtil.formatDate2String((Date)map.get("outTime"),"yyyyMMddHHmmss");
	    String PlateNume=map.get("plateID")!=null?map.get("plateID").toString():null;
	    String reusltXml="";
	    try {
	    	reusltXml=HttpUtil.sendGetRequest(tURL+"&Rtime="+Rtime+"&Ctime="+Ctime+"&PlateNume="+PlateNume+"&AreaID=0","utf-8");
			return XmlCom.getAllLeafNode(reusltXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return null;
   }
}
