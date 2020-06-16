package com.mthree.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.model.TimothyBidOrder;
import com.mthree.repositories.TimothyBidOrderRepo;

@Service
public class TimothyService {
	@Autowired
	TimothyBidOrderRepo timothyBidOrderRepo ;
	
	
	public List<TimothyBidOrder> getBidOrder() {
		System.out.println("reday to execute findall");
//		return timothyBidOrderRepo.findByInstrument(1);
//		return timothyBidOrderRepo.findAllById(Arrays.asList(new Integer[] { 1 }));
		return timothyBidOrderRepo.findAll();
	}
}
