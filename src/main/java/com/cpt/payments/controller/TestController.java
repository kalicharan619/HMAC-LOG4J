package com.cpt.payments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.pojo.AddRequest;
import com.cpt.payments.pojo.AddResponce;
import com.cpt.payments.service.TestService;





@RestController
@RequestMapping("/controller")
public class TestController {
	 
	@GetMapping("/hello")
	public String msgController()
    {
    	return "hello world";
    }
	@GetMapping("/addGet")
	public int addGet(@RequestParam(value="num1") int val1, 
			@RequestParam(value="num2") int val2) {
		System.out.println("Calling addGet:" +val1+" val2: " +val2);
		int res= val1+val2;
		System.out.println("result:"  +res);
		return res;
	}
	
	@PostMapping("/addPost")
	public int addPost(@RequestParam(value="num1") int val1, 
			@RequestParam(value="num2") int val2) {
		System.out.println("Calling addPost:" +val1+" val2: " +val2);
		int res= val1+val2;
		System.out.println("result:"  +res);
		return res;
	}
	
	@PostMapping("/processJson")
	@ResponseBody
	public AddResponce processJson(@RequestBody AddRequest request) {
		System.out.println("Calling processJson:" +request);
		int res= request.getNum1() + request.getNum2();
		AddResponce response= new AddResponce();
		response.setResValue(res);
		
		System.out.println("result:"  +res);
		return response;
	}

	@PostMapping("/validateAndProcess")
	@ResponseBody
	//public AddResponce validateAndProcess(@RequestHeader("signature") String signature ,@RequestBody AddRequest request) 
	
	public AddResponce validateAndProcess( @RequestHeader("signature") String signature ,
			@RequestBody AddRequest request)
	{
		
	System.out.println("Calling validateAndProcess:" +request+ "|signature" +signature);
    	
		//System.out.println("Calling validateAndProcess:" +request);
		TestService service= new TestService();
		
		
		int res= service.validataAndProcess(request , signature);
		 
		// int res= service.validataAndProcess(request);
		AddResponce response= new AddResponce();
		response.setResValue(res);
		
		System.out.println("Add response:"  +response);
		return response;
	}

}

