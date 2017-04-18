package com.bh.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.bh.util.security.MD5;

	


public class DataFormatUtils
{
    /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, Object> paraFilter(Map<String, Object> sArray) {

        Map<String, Object> result = new HashMap<String, Object>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            Object value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, Object> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
	/**
	 * map 转换
	 * @author:  zyy
	 * @Date:2015年12月10日 下午2:15:33
	 * @version: 1.0
	 * mapTransform
	 * @param map
	 * @return Map<String,String>
	 */

    public static boolean signVerify(Map<String,Object> Params,String key,String sign){

    	
    	if(StringUtils.isEmpty(key)|| Params.isEmpty()||StringUtils.isEmpty(sign)){
    		return false;
    	}
    	
    	String signRes=MD5.MD5Encode(createLinkString(paraFilter(Params))+"&key="+key);
    	if(StringUtils.equalsIgnoreCase(signRes, sign)){
    		return true;
    	}
    	return false;
    }
    @SuppressWarnings("unchecked")
	public static Map<String, Object> getRequestParams(HttpServletRequest request){
        Map<String, Object> params = new HashMap<String, Object>();
        if(null != request){
            Set<String> paramsKey = request.getParameterMap().keySet();
            for(String key : paramsKey){
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }
    
    public static void main(String[] args) {
		Map<String,Object> body = new HashMap<String, Object>();
		body.put("loginName", "ckr");
		body.put("password", "123");
		String key = "4e4cc930757f48cbb014da866ee03ac7";
		String linkString = createLinkString(body)+"&key="+key;
		String md5Encode = MD5.MD5Encode(linkString);
		System.out.println(md5Encode);
	}
    
}
