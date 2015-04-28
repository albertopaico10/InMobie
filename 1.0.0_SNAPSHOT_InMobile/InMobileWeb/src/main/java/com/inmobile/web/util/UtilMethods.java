package com.inmobile.web.util;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;

public class UtilMethods {

	public static String fromObjectToString(Object beanObject) {
		Gson gson = new Gson();
		String strGson = gson.toJson(beanObject);
		return strGson;
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

}
