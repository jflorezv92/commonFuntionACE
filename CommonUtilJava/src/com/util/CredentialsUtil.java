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
}
