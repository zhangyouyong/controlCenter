package com.bh.util;


import java.net.URLDecoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;



import javax.crypto.Cipher;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;


public class RsaEncrypto
{
	
  public static String encryptBASE64(byte[] key) throws Exception {
    return Base64.encode(key);
  }

  public static byte[] decryptBASE64(String key) throws Exception {
    return Base64.decode(key);
  }

  public static String RSAsign(byte[] data, String privateKey) throws Exception
  {
    byte[] keyBytes = decryptBASE64(privateKey);

    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

    KeyFactory keyFactory = KeyFactory.getInstance("RSA");

    PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

    Signature signature = Signature.getInstance("SHA1withRSA");
    signature.initSign(priKey);
    signature.update(data);

    return encryptBASE64(signature.sign());
  }

  public static boolean RSAverify(byte[] data, String publicKey, String sign)
    throws Exception
  {
    byte[] keyBytes = decryptBASE64(publicKey);

    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

    KeyFactory keyFactory = KeyFactory.getInstance("RSA");

    PublicKey pubKey = keyFactory.generatePublic(keySpec);
    
    System.out.println(pubKey);
    
    Signature signature = Signature.getInstance("SHA1withRSA");
    signature.initVerify(pubKey);
    signature.update(data);

    return signature.verify(decryptBASE64(sign));
  }

  public static byte[] RSAdecryptByPrivateKey(byte[] data, String key)
    throws Exception
  {
    byte[] keyBytes = decryptBASE64(key);

    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(2, privateKey);

    return cipher.doFinal(data);
  }

  public static byte[] RSAdecryptByPublicKey(byte[] data, String key)
    throws Exception
  {
    byte[] keyBytes = decryptBASE64(key);

    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    Key publicKey = keyFactory.generatePublic(x509KeySpec);

    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(2, publicKey);

    return cipher.doFinal(data);
  }

  public static byte[] RSAencryptByPublicKey(byte[] data, String key)
    throws Exception
  {
    byte[] keyBytes = decryptBASE64(key);

    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    Key publicKey = keyFactory.generatePublic(x509KeySpec);

    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(1, publicKey);

    return cipher.doFinal(data);
  }

	public static byte[] RSAencryptByPrivateKey(byte[] data, String key)
    throws Exception
  {
    byte[] keyBytes = decryptBASE64(key);

    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(1, privateKey);

    return cipher.doFinal(data);
  }

	/**
	* RSA验签名检查
	* @param content 待签名数据
	* @param sign 签名值
	* @param ali_public_key 支付宝公钥
	* @param input_charset 编码格式
	* @return 布尔值
	*/
	public static boolean verify(String content, String sign, String ali_public_key, String input_charset)
	{
		try 
		{
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        byte[] encodedKey = Base64.decode(ali_public_key);
	        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

		
			java.security.Signature signature = java.security.Signature
			.getInstance("SHA1WithRSA");
		
			signature.initVerify(pubKey);
			signature.update( content.getBytes(input_charset) );
		
			boolean bverify = signature.verify(Base64.decode(sign));
			return bverify;
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
  
  
  	public static void main(String[] args) throws Exception {
//  		RsaEncrypto.RSAverify(null, Common.getPubKey("D:/key/pub.der"),null);
//  		Map<String, Object> map = initRSAKey();
//  		Common.WriteFile("D:/key/pri.der", getRSAPrivateKey(map));
//  		Common.WriteFile("D:/key/pub.der", getRSAPrivateKey(map));
  		
  		System.out.println(new String(RSAdecryptByPublicKey("9ff782468e12e04a0229f0b2846c09eggo".getBytes(), 
  				"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP8ig8yOrDyWDIisI2ra8PTe7fS086nVG3t2vMTlueb7xwqUmeSvirQxvSYeRSpWBHfaUTBWgsrCgA0cSKFyJJvPOABIEORycYhSVqrPqYtbbqdyxKqC56km6viXTQqmSjco133MDuzWeQjGXneR24wzxTZc2dgy/TlZr06miJAwIDAQAB")));
	}
  
}