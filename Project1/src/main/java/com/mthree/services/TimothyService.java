package com.mthree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.model.TimothyBidOrder;
import com.mthree.model.TimothyInstrument;
import com.mthree.repositories.TimothyBidOrderRepo;
import com.mthree.repositories.TimothyInstrumentRepo;

@Service
public class TimothyService {
	@Autowired
	TimothyBidOrderRepo timothyBidOrderRepo ;
	
	@Autowired
	TimothyInstrumentRepo timothyInstrumentRepo;
	
	
	public List<TimothyBidOrder> getBidOrder() {
		System.out.println("reday to execute findall");
//		return timothyBidOrderRepo.findByInstrument(1);
//		return timothyBidOrderRepo.findAllById(Arrays.asList(new Integer[] { 1 }));
		return timothyBidOrderRepo.findAll();
	}
	
	
	public List<TimothyInstrument> getAllInstrument(){

				
				
		return timothyInstrumentRepo.findAll();
	}
	
	public Optional<TimothyInstrument> getInstrumentById(int id){
		System.out.println("ASDASD");
		return null;
//		return timothyInstrumentRepo.findById(id);
	}


//	public List<TimothyBidOrder> getBidOrder2(TimothyInstrument t) {
//		System.out.println("reday to execute findall");
//		return timothyBidOrderRepo.findByInstrument(t);
//	}
}
