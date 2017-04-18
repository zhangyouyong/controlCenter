package com.bh.util;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesEncrypto {
	private static final String DES = "DES";

	public static String saveDesKey() {
		try {
			SecureRandom sr = new SecureRandom();
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			kg.init(sr);

			Key key = kg.generateKey();
			return Base64.encode(key.getEncoded());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args)
	{
		System.out.println(generateDesKey());
	}

	public static String generateDesKey() {
		try {
			String radStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234!@#$%^&*()56789qwertyuioplkjhgfdsazxcvbnm";
			StringBuffer generateRandStr = new StringBuffer();
			Random rand = new Random();
			int length = 8;
			int radLen = radStr.length();
			for (int i = 0; i < length; i++) {
				int randNum = rand.nextInt(radLen - 2);
				generateRandStr.append(radStr.substring(randNum, randNum + 1));
			}
			return generateRandStr.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String encrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance(DES);
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

		cipher.init(1, secretKey);
		return Base64.encode(cipher.doFinal(message.getBytes("UTF-8")));
	}

	public static String decrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance(DES);
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

		cipher.init(2, secretKey);
		return new String(cipher.doFinal(Base64.decode(message)), "UTF-8");
	}
}