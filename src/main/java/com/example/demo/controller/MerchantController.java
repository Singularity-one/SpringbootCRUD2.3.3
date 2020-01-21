package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponse;
import com.example.demo.dto.CustomerResponseBody;
import com.example.demo.dto.MerchantRequest;
import com.example.demo.dto.MerchantResponse;
import com.example.demo.dto.MerchantResponseBody;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Merchant;
import com.example.demo.respository.MerchantRespository;
import com.example.demo.service.MerchantService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired public MerchantService merchantService;
	
	@Autowired
	public MerchantRespository merchantRespository;
	

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse findAll() {
		System.out.println("findAll");

		MerchantResponse response = new MerchantResponse();
		List<Merchant> dataList = merchantService.findAll();
		MerchantResponseBody body = new MerchantResponseBody();
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;
	}
	
	//名子查詢
	@PostMapping(value = "/findByName", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse findByName(@RequestBody MerchantRequest request) {
				System.out.println("findByName");
				System.out.println(request.getBody().getName());

				MerchantResponse response = new MerchantResponse();

				List<Merchant> dataList = merchantService.findByName(request.getBody().getName());
				MerchantResponseBody body = new MerchantResponseBody();
				body.setReturnCode("0000");
				body.setDataList(dataList);
				response.setBody(body);

				return response;

	}
	
	
	
	//查詢ID
	@PostMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse findById(@RequestBody MerchantRequest request) {
				System.out.println("findById");
				System.out.println(request.getBody().getMerchantId());

				MerchantResponse response = new MerchantResponse();

				List<Merchant> dataList = merchantRespository.findSQL(request.getBody().getMerchantId());
				
				Merchant merchant=dataList.get(0);
				String str = new String(merchant.getPic());//把byte[]轉回String
				
				MerchantResponseBody body = new MerchantResponseBody();
				body.setReturnCode("0000");
				body.setDataList(dataList);
				body.setPic(str);
				
				
				response.setBody(body);

				return response;

	}
	
	
	//新增
	@PostMapping(value = "/save2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse save2(@RequestBody MerchantRequest request) {
		
		System.out.println(request);
		System.out.println("save2");
		
		System.out.println("指定id"+request.getBody().getMerchantId());
		System.out.println("指定name"+request.getBody().getName());
		System.out.println("指定tel"+request.getBody().getTel());
		System.out.println("指定img"+request.getBody().getPic());
		System.out.println("指定imgby"+request.getBody().getPic().getBytes());

		Merchant merchant = new Merchant();
		
		//String img ="PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==";
		
		//byte[] pic=null;
		byte[] pic =request.getBody().getPic().getBytes();
		
		String str = new String(pic);//把byte[]轉回String
		//System.out.println("確認是否正常"+str);
		
		merchant.setMerchantId(request.getBody().getMerchantId());
		merchant.setName(request.getBody().getName());
		merchant.setTel(request.getBody().getTel());
		merchant.setAddr(request.getBody().getAddr());
		
		merchant.setPic(pic);
		
		merchantService.save(merchant);
		
		MerchantResponse response = new MerchantResponse();
		MerchantResponseBody body = new MerchantResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);
		body.setPic(str);

		return response;
	}
	
	//新增
	@PostMapping(value = "/save3", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MerchantResponse save3(@RequestBody MerchantRequest request) {
		
		System.out.println(request);
		System.out.println("save3");
		
		System.out.println("指定name"+request.getBody().getName());
		System.out.println("指定tel"+request.getBody().getTel());


		Merchant merchant = new Merchant();
		

		
		//得到最後一筆ID
		Merchant merchant2 = new Merchant();
		merchant2 = merchantService.findByEnd();
		int id = Integer.valueOf(merchant2.getMerchantId());
		System.out.println(id);
		String merchantId =String.valueOf(id+1);
		System.out.println(merchantId);
		
		
		byte[] pic =request.getBody().getPic().getBytes();
//		String str = new String(pic);//把byte[]轉回String
//		System.out.println("確認是否正常"+str);
		
		merchant.setMerchantId(merchantId);
		merchant.setName(request.getBody().getName());
		merchant.setTel(request.getBody().getTel());
		merchant.setAddr(request.getBody().getAddr());
		merchant.setPic(pic);
		
		System.out.println("指定img"+merchant.getMerchantId());
		System.out.println("指定img"+merchant.getPic());
		
		merchantService.save(merchant);
		
		MerchantResponse response = new MerchantResponse();
		MerchantResponseBody body = new MerchantResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);

		return response;
	}
	
	
	//修改
	@PostMapping(value = "/updata", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public  MerchantResponse updata(@RequestBody MerchantRequest request) {
		System.out.println(request);
		System.out.println("updata");
		System.out.println("得到id"+request.getBody().getMerchantId());

		MerchantResponse response = new  MerchantResponse();
		Merchant merchant = new Merchant();
		
		if(request.getBody().getPic()==null || request.getBody().getPic().length()<= 0) {
			byte[] pic1 =new byte[0];
			merchant.setPic(pic1);
		}else {
			byte[] pic =request.getBody().getPic().getBytes();
			merchant.setPic(pic);
		}
		

		merchant.setMerchantId(request.getBody().getMerchantId());
		merchant.setName(request.getBody().getName());
		merchant.setTel(request.getBody().getTel());
		merchant.setAddr(request.getBody().getAddr());

		
		
		merchantService.save(merchant);
		MerchantResponseBody body = new MerchantResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);

		return response;
	}
	


	
	

	
	
	


}
