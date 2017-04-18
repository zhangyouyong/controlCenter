
package com.bh.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author tzq
 * 
 */
public class StringUtils {

    /**
     * 字符串的正则匹配
     * 
     * @param test
     *            正则表达试
     * @param str
     *            比较字符串
     * @return
     */
    public static boolean pattern(String test, String str) {
        Pattern p = Pattern.compile(test);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 检查字符串是否为<code>null</code>或空字符串<code>""</code>。
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = false
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     * @param str 要检查的字符串
     *
     * @return 如果为空, 则返回<code>true</code>
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    /**
     * 检查字符串是否不是<code>null</code>和空字符串<code>""</code>。
     * <pre>
     * StringUtil.isEmpty(null)      = false
     * StringUtil.isEmpty("")        = false
     * StringUtil.isEmpty(" ")       = true
     * StringUtil.isEmpty("bob")     = true
     * StringUtil.isEmpty("  bob  ") = true
     * </pre>
     *
     * @param str 要检查的字符串
     *
     * @return 如果不为空, 则返回<code>true</code>
     */
    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }

    /**
     * 获取字符串的长度
     * 
     * @param str
     * @return
     */
    public static int strLength(String str) {
        return str.length();
    }

    /**
     * 判断是否全为数字,全为返回true,否则返回false
     * @param str
     * @return
     */
    public static boolean checkInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 检查字符串是否是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
     * StringUtil.isBlank(null)      = true
     * StringUtil.isBlank("")        = true
     * StringUtil.isBlank(" ")       = true
     * StringUtil.isBlank("bob")     = false
     * StringUtil.isBlank("  bob  ") = false
     * @param str 要检查的字符串
     *
     * @return 如果为空白, 则返回<code>true</code>
     */
    public static boolean isBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 检查字符串是否不是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
     * StringUtil.isBlank(null)      = false
     * StringUtil.isBlank("")        = false
     * StringUtil.isBlank(" ")       = false
     * StringUtil.isBlank("bob")     = true
     * StringUtil.isBlank("  bob  ") = true
     * @param str 要检查的字符串
     *
     * @return 如果为空白, 则返回<code>true</code>
     */
    public static boolean isNotBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * 比较两个字符串（大小写敏感）。
     * <pre>
     * StringUtil.equals(null, null)   = true
     * StringUtil.equals(null, "abc")  = false
     * StringUtil.equals("abc", null)  = false
     * StringUtil.equals("abc", "abc") = true
     * StringUtil.equals("abc", "ABC") = false
     * </pre>
     *
     * @param str1 要比较的字符串1
     * @param str2 要比较的字符串2
     *
     * @return 如果两个字符串相同，或者都是<code>null</code>，则返回<code>true</code>
     */
    public static boolean equals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equals(str2);
    }

    /**
     * 比较两个字符串（大小写不敏感）。
     * <pre>
     * StringUtil.equalsIgnoreCase(null, null)   = true
     * StringUtil.equalsIgnoreCase(null, "abc")  = false
     * StringUtil.equalsIgnoreCase("abc", null)  = false
     * StringUtil.equalsIgnoreCase("abc", "abc") = true
     * StringUtil.equalsIgnoreCase("abc", "ABC") = true
     * </pre>
     *
     * @param str1 要比较的字符串1
     * @param str2 要比较的字符串2
     *
     * @return 如果两个字符串相同，或者都是<code>null</code>，则返回<code>true</code>
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equalsIgnoreCase(str2);
    }

    /* ============================================================================ */
    /*  大小写转换。                                                                */
    /* ============================================================================ */

    /**
     * 将字符串转换成大写。
     * 
     * <p>
     * 如果字符串是<code>null</code>则返回<code>null</code>。
     * <pre>
     * StringUtil.toUpperCase(null)  = null
     * StringUtil.toUpperCase("")    = ""
     * StringUtil.toUpperCase("aBc") = "ABC"
     * </pre>
     * </p>
     *
     * @param str 要转换的字符串
     *
     * @return 大写字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String toUpperCase(String str) {
        if (str == null) {
            return null;
        }

        return str.toUpperCase();
    }

    /**
     * 将字符串转换成小写。
     * 
     * <p>
     * 如果字符串是<code>null</code>则返回<code>null</code>。
     * <pre>
     * StringUtil.toLowerCase(null)  = null
     * StringUtil.toLowerCase("")    = ""
     * StringUtil.toLowerCase("aBc") = "abc"
     * </pre>
     * </p>
     *
     * @param str 要转换的字符串
     *
     * @return 大写字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String toLowerCase(String str) {
        if (str == null) {
            return null;
        }

        return str.toLowerCase();
    }

    /**
     * 返回card的前四后四位
     * 
     * @param card
     * @return
     */
    public static String parseIdCard(String card) {
        if (card == null || "".equals(card)) {
            return null;
        }
        return card.trim().substring(0, 4) + "****" + card.trim().substring(card.length() - 4, card.length());
    }

    /**
     * 处理空字符串
     * 
     * @param str
     */
    public static String handleStringNull(String str) {
        return str == null || str.trim().length() == 0 || "null".equals(str) ? "" : str;
    }

    /**
     * 处理HTML字符串
     * 
     * @param str
     */
    public static String handleHtmlString(String str) {
        return handleStringNull(str) == "" ? "" : str.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&ldquo;", "")
            .replaceAll("&mdash;", "").replaceAll("&rdquo;", "").replaceAll("&nbsp;", " ");
    }
    
	public static String unite(Object... values) {
		if (values == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			sb.append(values[i]);
		}
		return sb.toString();
	}
	
	public static String join(Set<String> setStr, String strSeparator){
		String resultStr="";
		System.out.println(setStr.toString());
		if(setStr!=null){
			Iterator<String> it = setStr.iterator();
			
			while (it.hasNext())
			{
				String str = (String) it.next();
				if(str==null){
					continue;
				}
				resultStr+=str+",";
			}
		}
		if(resultStr.length()>0){
			resultStr=resultStr.substring(0,resultStr.length()-1);
		}
		return resultStr;
	}
	
	public static String join(List listStr, String strSeparator){
		String resultStr="";
		if(listStr==null){
			return null;
		}
		if(listStr!=null){
			Iterator<Object>  it = listStr.iterator();
			
			while (it.hasNext())
			{
					Object str = it.next();
					resultStr+=str+",";
			}
		}
		if(resultStr.length()>0){
			resultStr=resultStr.substring(0,resultStr.length()-1);
		}
		return resultStr;
	}

}
