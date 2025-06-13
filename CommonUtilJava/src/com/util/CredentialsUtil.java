package com.util;

import java.util.Map;

import com.ibm.broker.plugin.MbCredential;
import com.ibm.broker.plugin.MbCredentialDeletedException;
import com.ibm.broker.plugin.MbException;

public class CredentialsUtil {
	public static String getCredentialSalesforce(String name) {
		
		
		MbCredential myCred;
		String auxString;
		char[] auxChar;
		String credentials = "{";

		try {

			myCred = MbCredential.getCredential("salesforce", name);

			if (myCred == null) {
				throw new RuntimeException("Credentials not found");
			}

			Map<String, char[]> credentialsProperties = myCred.reloadAndRetrieveProperties();
			
			if (credentialsProperties.containsKey(MbCredential.USERNAME)) {
				auxChar = credentialsProperties.get(MbCredential.USERNAME);
				auxString = new String(auxChar);
				credentials = credentials + " \"username\" : \" " + auxString + "\","; 				
			}

			if (credentialsProperties.containsKey(MbCredential.PASSWORD)) {	
				auxChar = credentialsProperties.get(MbCredential.PASSWORD);
				auxString = new String(auxChar);
				credentials = credentials + " \"password\" : \" " + auxString + "\",";
			}
			
			if (credentialsProperties.containsKey(MbCredential.CLIENT_ID)) {				
				auxChar = credentialsProperties.get(MbCredential.CLIENT_ID);
				auxString = new String(auxChar);
				credentials = credentials + " \"client-id\" : \" " + auxString + "\",";
			}
			
			if (credentialsProperties.containsKey(MbCredential.CLIENT_SECRET)) {	
				auxChar = credentialsProperties.get(MbCredential.CLIENT_SECRET);
				auxString = new String(auxChar);
				credentials = credentials + " \"client-secret\" : \" " + auxString + "\"}";
			}

		} catch (MbCredentialDeletedException cde) {
			credentials = null;
		} catch (MbException e) {
			credentials = null;
			throw new RuntimeException("Error during credetials lookup", e);
		}

		return credentials;
	}

	public static String getCredential(String type, String name, String property) {
				
		MbCredential myCred;
		char[] auxChar;
		String credentials = "";

		try {

			myCred = MbCredential.getCredential(type, name);

			if (myCred == null) {
				throw new RuntimeException("Credentials not found");
			}

			Map<String, char[]> credentialsProperties = myCred.reloadAndRetrieveProperties();
			
			if (property.equals("ACCESS_KEY_ID") && credentialsProperties.containsKey(MbCredential.ACCESS_KEY_ID)) {
				auxChar = credentialsProperties.get(MbCredential.ACCESS_KEY_ID);
				credentials = new String(auxChar); 				
			}
			if (property.equals("ACCESS_TOKEN") && credentialsProperties.containsKey(MbCredential.ACCESS_TOKEN)) {
				auxChar = credentialsProperties.get(MbCredential.ACCESS_TOKEN);
				credentials = new String(auxChar); 				
			}
			if (property.equals("API_KEY") && credentialsProperties.containsKey(MbCredential.API_KEY)) {
				auxChar = credentialsProperties.get(MbCredential.API_KEY);
				credentials = new String(auxChar); 				
			}
			if (property.equals("AUTH_TYPE") && credentialsProperties.containsKey(MbCredential.AUTH_TYPE)) {
				auxChar = credentialsProperties.get(MbCredential.AUTH_TYPE);
				credentials = new String(auxChar); 				
			}
			if (property.equals("CLIENT_EMAIL") && credentialsProperties.containsKey(MbCredential.CLIENT_EMAIL)) {
				auxChar = credentialsProperties.get(MbCredential.CLIENT_EMAIL);
				credentials = new String(auxChar); 				
			}
			if (property.equals("CLIENT_ID") && credentialsProperties.containsKey(MbCredential.CLIENT_ID)) {
				auxChar = credentialsProperties.get(MbCredential.CLIENT_ID);
				credentials = new String(auxChar); 				
			}
			if (property.equals("CLIENT_SECRET") && credentialsProperties.containsKey(MbCredential.CLIENT_SECRET)) {
				auxChar = credentialsProperties.get(MbCredential.CLIENT_SECRET);
				credentials = new String(auxChar); 				
			}
			if (property.equals("PASSPHRASE") && credentialsProperties.containsKey(MbCredential.PASSPHRASE)) {
				auxChar = credentialsProperties.get(MbCredential.PASSPHRASE);
				credentials = new String(auxChar); 				
			}
			if (property.equals("PASSWORD") && credentialsProperties.containsKey(MbCredential.PASSWORD)) {
				auxChar = credentialsProperties.get(MbCredential.PASSWORD);
				credentials = new String(auxChar); 				
			}
			if (property.equals("PRIVATE_KEY") && credentialsProperties.containsKey(MbCredential.PRIVATE_KEY)) {
				auxChar = credentialsProperties.get(MbCredential.PRIVATE_KEY);
				credentials = new String(auxChar); 				
			}
			if (property.equals("PUBLIC_KEY") && credentialsProperties.containsKey(MbCredential.PUBLIC_KEY)) {
				auxChar = credentialsProperties.get(MbCredential.PUBLIC_KEY);
				credentials = new String(auxChar); 				
			}
			if (property.equals("PUBLIC_KEY_ID") && credentialsProperties.containsKey(MbCredential.PUBLIC_KEY_ID)) {
				auxChar = credentialsProperties.get(MbCredential.PUBLIC_KEY_ID);
				credentials = new String(auxChar); 				
			}
			if (property.equals("REFRESH_TOKEN") && credentialsProperties.containsKey(MbCredential.REFRESH_TOKEN)) {
				auxChar = credentialsProperties.get(MbCredential.REFRESH_TOKEN);
				credentials = new String(auxChar); 				
			}
			if (property.equals("SECRET_ACCESS_KEY") && credentialsProperties.containsKey(MbCredential.SECRET_ACCESS_KEY)) {
				auxChar = credentialsProperties.get(MbCredential.SECRET_ACCESS_KEY);
				credentials = new String(auxChar); 				
			}
			if (property.equals("SSH_IDENTITY_FILE") && credentialsProperties.containsKey(MbCredential.SSH_IDENTITY_FILE)) {
				auxChar = credentialsProperties.get(MbCredential.SSH_IDENTITY_FILE);
				credentials = new String(auxChar); 				
			}
			if (property.equals("USERNAME") && credentialsProperties.containsKey(MbCredential.USERNAME)) {
				auxChar = credentialsProperties.get(MbCredential.USERNAME);
				credentials = new String(auxChar); 				
			}
			if (property.equals("WEBSPHERE_PASSWORD") && credentialsProperties.containsKey(MbCredential.WEBSPHERE_PASSWORD)) {
				auxChar = credentialsProperties.get(MbCredential.WEBSPHERE_PASSWORD);
				credentials = new String(auxChar); 				
			}
			if (property.equals("WEBSPHERE_USERNAME") && credentialsProperties.containsKey(MbCredential.WEBSPHERE_USERNAME)) {
				auxChar = credentialsProperties.get(MbCredential.WEBSPHERE_USERNAME);
				credentials = new String(auxChar); 				
			}

		} catch (MbCredentialDeletedException cde) {
			credentials = null;
		} catch (MbException e) {
			credentials = null;
			throw new RuntimeException("Error during credetials lookup", e);
		}

		return credentials;
	}


}
