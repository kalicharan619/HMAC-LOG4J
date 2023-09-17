package com.cpt.payments.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha256Utils {

	private HmacSha256Utils()
	{
		
	}
	
	public static String generateSignature(String secretKey , String jsonInput) {
		 String signature = null;
		   
		try {
			//Create a SecterKeySpec object from the secret key
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
			
			//Initilaize the HMAC-SHA256 Mac instance
			Mac mac = Mac.getInstance("HmacSHA256");
       	    mac.init(secretKeySpec);
       	 
       	    //Compute the HMAC-SHA256 signature
       	    byte[] hmacBytes = mac.doFinal(jsonInput.getBytes(StandardCharsets.UTF_8));
       	  
       	    //Encode the signature in Base64
       	     signature = Base64.getEncoder().encodeToString(hmacBytes);
       	  System.out.println("HMAC-SHA256 signature"  +signature);
		
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
	      
	   
		
		return signature;
}
}
