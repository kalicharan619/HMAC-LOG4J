package com.cpt.payments;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TestMain {
	
	public static void main(String[] args) {
       
		String secretKey = "ecom-ct-secret123";
		String jsonInput = "{\"data\": \"your_json_data_here\"}";
		try {
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
             Mac mac = Mac.getInstance("HmacSHA256");
             mac.init(keySpec);
             byte[] hmacData = mac.doFinal(jsonInput.getBytes(StandardCharsets.UTF_8));
       
               String signature= Base64.getEncoder().encodeToString(hmacData);
                System.out.println("HMAC-SHA256 Signature: "+signature);
          } catch (NoSuchAlgorithmException | InvalidKeyException e) {
           e.printStackTrace();
       }
	
	}
}


