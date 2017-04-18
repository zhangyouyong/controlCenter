package com.bh.util;

import java.util.ArrayList;
import java.util.List;


/**
 * 将map写进excel
 * @author chenkerui
 *
 */
public  class ExcelUtil {
	
	/**
	 * columnName放入封装的数据,data放入封装的数据
	 * @param columnName
	 * @param data
	 * @return
	 */
	public static List<List<String>> add2List(List<String> columnName,List<List<String>> data){
		List<List<String>> list = new ArrayList<List<String>>();
		list.add(columnName);
		list.addAll(data);
		return list;
	}

}
