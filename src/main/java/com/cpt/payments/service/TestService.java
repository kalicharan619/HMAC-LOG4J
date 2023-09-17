package com.cpt.payments.service;
import com.cpt.payments.pojo.AddRequest;
import com.cpt.payments.util.HmacSha256Utils;
import com.google.gson.Gson;

public class TestService {
	private String secretKey ="ecom-ct-secret123";
	
	
	
	//public int validataAndProcess(AddRequest request )
	 public int validataAndProcess(AddRequest request , String clientsignature)
	{
		Gson gson=new Gson();
		String jsonRequest=gson.toJson(request);
		
		
		
		System.out.println("jsonrequest" +jsonRequest);
		String generatedSig= HmacSha256Utils.generateSignature(secretKey, jsonRequest);
		System.out.println("GeneratedSig:" +generatedSig);
		
		if(generatedSig.equals(clientsignature)) {
			return request.getNum1()+request.getNum2();
		}
		
		return -1;
	}

}
