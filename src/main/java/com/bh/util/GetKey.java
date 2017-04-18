package com.bh.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;


public class GetKey
{
	public static String getRSAPrivateKey(Map<String, Object> keyMap) throws Exception
	{
		Key key = (Key) keyMap.get("RSAPrivateKey");
		return RsaEncrypto.encryptBASE64(key.getEncoded());
	}

	public static String getRSAPublicKey(Map<String, Object> keyMap) throws Exception
	{
		Key key = (Key) keyMap.get("RSAPublicKey");

		return RsaEncrypto.encryptBASE64(key.getEncoded());
	}

	public static Map<String, Object> initRSAKey() throws Exception
	{
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);

		KeyPair keyPair = keyPairGen.generateKeyPair();

		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		Map keyMap = new HashMap(2);

		keyMap.put("RSAPublicKey", publicKey);
		keyMap.put("RSAPrivateKey", privateKey);
		return keyMap;
	}

	 private static byte[] getContentBytes(String content, String charset) {
	        if (charset == null || "".equals(charset)) {
	            return content.getBytes();
	        }
	        try {
	            return content.getBytes(charset);
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
	        }
	    }
}
