package com.jsfProject.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class LocalEncrypter {

	private static final String ALGORITHM = "AES";
	private static final byte[] keyValue = new byte[] { 'T', 'r', 'i', 'u', 'I', 'g', 'A', 'O', 'e', 'f', 'r', 'n', 't',
			'K', 'p', 'y' };

	public static String encrypt(String valueToEnc) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = c.doFinal(valueToEnc.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encValue);
		return encryptedValue;
	}

	public static String decrypt(String encryptedValue) throws Exception {
		String decryptedValue = "";

		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
			byte[] decValue = c.doFinal(decordedValue);
			decryptedValue = new String(decValue);
		} catch (Exception e) {
			return "0";
		}
		return decryptedValue;
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		// SecretKeyFactory keyFactory =
		// SecretKeyFactory.getInstance(ALGORITHM);
		// key = keyFactory.generateSecret(new DESKeySpec(keyValue));
		return key;
	}

	public static void main(String args[]) {

		try {

			String a = LocalEncrypter.encrypt("3");
			String b = LocalEncrypter.decrypt("uIrsFegO4eSDwXe5LqyCkA==");
			System.out.println(a.toString());
			System.out.println(b.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}