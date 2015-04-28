package com.rest.web.service.inmobile.util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;

public class UtilMethods {
	// --This method is only for test
	public static int showRandomInteger(int aStart, int aEnd, Random aRandom) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	public static String encriptedPassword(String message, String algorithm) {
		String secretKey = CommonConstants.EncriptedValues.KEY_VALUE_ENCRIPTED;
		String base64EncryptedString = "";

		try {

			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
			byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] plainTextBytes = message.getBytes("utf-8");
			byte[] buf = cipher.doFinal(plainTextBytes);
			byte[] base64Bytes = Base64.encodeBase64(buf);
			base64EncryptedString = new String(base64Bytes);

		} catch (Exception ex) {
		}
		return base64EncryptedString;
	}

	public static String descriptionPassword(String textoEncriptado,
			String algorithm) throws Exception {

		String secretKey = CommonConstants.EncriptedValues.KEY_VALUE_ENCRIPTED;
		String base64EncryptedString = "";

		try {
			byte[] message = Base64.decodeBase64(textoEncriptado
					.getBytes("utf-8"));
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
			byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
			SecretKey key = new SecretKeySpec(keyBytes, "DESede");

			Cipher decipher = Cipher.getInstance("DESede");
			decipher.init(Cipher.DECRYPT_MODE, key);

			byte[] plainText = decipher.doFinal(message);

			base64EncryptedString = new String(plainText, "UTF-8");

		} catch (Exception ex) {
		}
		return base64EncryptedString;
	}
	
	public static String fromObjectToString(Object beanObject){
		Gson gson=new Gson();
		String strGson=gson.toJson(beanObject);
		return strGson;
	}

}
