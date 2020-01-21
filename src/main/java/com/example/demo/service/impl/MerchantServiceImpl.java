package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Merchant;
import com.example.demo.respository.MerchantRespository;
import com.example.demo.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {
	
	@Autowired
	public MerchantRespository merchantRespository;


	@Override
	public void save(Merchant merchant) {
		merchantRespository.save(merchant);
	}
	
	@Override
	public List<Merchant> findAll() {
		return merchantRespository.findAll();
	}

	@Override
	public List<Merchant> findByName(String name) {
		return merchantRespository.findByName(name);
	}

	@Override
	public Merchant findByMerchantId(String merchantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> findSQL(String merchantId) {
		return merchantRespository.findSQL(merchantId);
	}

	@Override
	public Merchant findByEnd() {
		Merchant merchant = merchantRespository.findByEnd();
		return merchant;
	}
	
	

	
}
