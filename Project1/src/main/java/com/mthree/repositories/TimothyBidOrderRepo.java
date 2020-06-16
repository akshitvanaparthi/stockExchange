
package com.mthree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mthree.model.TimothyBidOrder;

@Repository
public interface TimothyBidOrderRepo extends JpaRepository<TimothyBidOrder,Integer>{

//	public List<TimothyBidOrder> findByInstrument(int i);
	
}
