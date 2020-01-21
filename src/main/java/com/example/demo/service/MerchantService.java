package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Merchant;

public interface MerchantService {

	Merchant findByMerchantId(String merchantId);
	
	void save(Merchant merchant);
	
	List<Merchant> findAll();
	
	//名字查詢
	List<Merchant> findByName(String name);
	
	//用SQL找id
	List<Merchant> findSQL(String merchantId);
	
	//查最後一筆
	Merchant findByEnd();
	
	
	
	
}
