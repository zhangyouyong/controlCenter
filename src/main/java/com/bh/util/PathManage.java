package com.bh.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
/**
 * 路径管理类
 * @author 杜红成
 *
 */
public class PathManage
{
	/**
	 * 获取生成的Classes的路径
	 * EG:D:/java_workspace/.metadata/.plugins/org.eclipse.wst.server
	 * .core/tmp0/wtpwebapps/readXML/WEB-INF/classes/
	 * 
	 * @return Classes的路径
	 */
	public static String getClassesPath()
	{
		URL url = Thread.currentThread().getContextClassLoader().getResource("");
		if (url == null)
		{
			throw new RuntimeException("未找到生成类的路径");
		}
		try
		{
			String path = URLDecoder.decode(url.getPath(), "GBK");
			if (System.getProperty("os.name").toLowerCase().indexOf("windows") >= 0)
			{
				if (path.startsWith("/"))
				{
					path = path.substring(1);
				}
				else if (path.startsWith("file:/"))
				{
					path = path.substring(6);
				}
			}
			else if (path.startsWith("file:/"))
			{
				path = path.substring(5);
			}
			return path.substring(0, path.lastIndexOf("/") + 1);
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到web程序所在的根目录
	 * EG：D:/java_workspace/.metadata/.plugins/org.eclipse.wst.server
	 * .core/tmp0/wtpwebapps/readXML/
	 * 
	 * @return web程序所在的根目录
	 */
	public static String getContextRealPath()
	{
		String strPath = getClassesPath();
		if (strPath != null && strPath != "")
		{
			int index = strPath.indexOf("WEB-INF");
			if (index > 0)
			{
				strPath = strPath.substring(0, index);
			}
			return strPath;
		}
		return null;

	}
}
