package com.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class CryptoUtil {

    private static final String AES_CIPHER = "AES/CBC/PKCS5Padding";
    private static final String KET_TYPE = "PBKDF2WithHmacSHA1";
    //private static final String salt = "test";
    private static String keyClient = "nZr4u7x!A%D*G-Ka";
    private static boolean diferentIV = false;
    private SecretKey secretKey;
    private IvParameterSpec ivParameterSpec;
    
    public CryptoUtil(String keyClient) {
    	
    }
    
    public CryptoUtil() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        this.secretKey = keyGenerator.generateKey();
        byte[] iv = new byte[16];
        this.ivParameterSpec = new IvParameterSpec(iv);
    }
    
    public static String encrypt(String input, String salt) {
	
		byte[] cipherText = null;
		try {
			SecretKey key = getKeyFromPassword(keyClient, salt);
			Cipher cipher = Cipher.getInstance(AES_CIPHER);
			IvParameterSpec iv = CryptoUtil.generateIv();
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);
			cipherText = cipher.doFinal(input.getBytes());

			if (diferentIV) {
				
				byte[] combinedPayload = new byte[iv.getIV().length
						+ cipherText.length];
				// populate payload with prefix IV and encrypted data
				System.arraycopy(iv.getIV(), 0, combinedPayload, 0,
						iv.getIV().length);
				System.arraycopy(cipherText, 0, combinedPayload,
						iv.getIV().length, cipherText.length);

				return DatatypeConverter.printBase64Binary(combinedPayload);
			} else {
				return DatatypeConverter.printBase64Binary(cipherText);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
    
    public static String decrypt(String cipherText, String salt) {
		
		byte[] plainText = "".getBytes();
		try {
			SecretKey key = getKeyFromPassword(keyClient, salt);
			byte[] encryptedPayload = DatatypeConverter
					.parseBase64Binary(cipherText);
			Cipher cipher = Cipher.getInstance(AES_CIPHER);
			
			if (diferentIV) {
			
			byte[] iv = new byte[16];
			byte[] encryptedBytes = new byte[encryptedPayload.length
					- iv.length];
			// populate iv with bytes:
			System.arraycopy(encryptedPayload, 0, iv, 0, 16);

			// populate encryptedBytes with bytes:
			System.arraycopy(encryptedPayload, iv.length, encryptedBytes, 0,
					encryptedBytes.length);
			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
			plainText = cipher.doFinal(encryptedBytes);
			}
			else
			{	IvParameterSpec iv = CryptoUtil.generateIv();
				cipher.init(Cipher.DECRYPT_MODE, key, iv);
				plainText = cipher.doFinal(encryptedPayload);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(plainText);
	}
    
    public static IvParameterSpec generateIv() {
		if(diferentIV){
			byte[] iv = new byte[16];
			new SecureRandom().nextBytes(iv);
			return new IvParameterSpec(iv);
		}
		else{
			byte[] iv = keyClient.getBytes();
			return new IvParameterSpec(iv);
		}
	}
    
    public static SecretKey getKeyFromPassword(String password, String salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		SecretKeyFactory factory = SecretKeyFactory.getInstance(KET_TYPE);
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(),
				65536, 128);
		return new SecretKeySpec(factory.generateSecret(spec).getEncoded(),
				"AES");
	}

	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(n);
		return keyGenerator.generateKey();
	}

    public String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CIPHER);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CIPHER);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
        	
        	String salt = "test";
        	String input = "This is a secret message";
    		String cipherText = CryptoUtil.encrypt(input, salt);
    		System.out.println("Encrypted " + cipherText);
    		String plainText = CryptoUtil.decrypt(cipherText, salt);
    		System.out.println("Decrypted " + plainText);
        	
            CryptoUtil cryptoUtil = new CryptoUtil();
            String input2 = "This is a secret message";
            String encryptedText = cryptoUtil.encrypt(input2);
            String decryptedText = cryptoUtil.decrypt(encryptedText);

            System.out.println("Plain Text: " + plainText);
            System.out.println("Encrypted Text: " + encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}