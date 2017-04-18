package com.bh.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCharacter
{
	public static void setServletCharachterUTF8(HttpServletRequest request, HttpServletResponse response)
	{
		response.setHeader("Pragma", "No-Cache");
		response.setHeader("Cache-Control", "No-Cache");
		response.setDateHeader("Expires", 0L);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		try
		{
			request.setCharacterEncoding("UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
}
