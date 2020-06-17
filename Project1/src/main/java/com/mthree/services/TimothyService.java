package com.mthree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.dto.TimothyBidOrderDTO;
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
	
	
	
	//fins instrument
	public Optional<TimothyInstrument> getInstrumentById(int id){
		return timothyInstrumentRepo.findById(id);
	}
	
	
	//find all bidOrder by instrument
	public List<TimothyBidOrder> getBidOrdersByInstrument(TimothyInstrument t){
		return timothyBidOrderRepo.findAllByInstrument(t);
	}
	
	
	//find all bidOrder by instrument DTO!!
	public List<TimothyBidOrderDTO> getBidOrdersDTOByInstrument(TimothyInstrument t){
		return timothyBidOrderRepo.findBidOrdersDTOByInstrument(t);

	}
}
