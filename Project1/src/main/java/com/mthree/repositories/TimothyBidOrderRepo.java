
package com.mthree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.model.TimothyBidOrder;
import com.mthree.model.TimothyInstrument;

@Repository
public interface TimothyBidOrderRepo extends JpaRepository<TimothyBidOrder,Integer>{

	public List<TimothyBidOrder> findByInstrument(TimothyInstrument ti);
	
	
}
