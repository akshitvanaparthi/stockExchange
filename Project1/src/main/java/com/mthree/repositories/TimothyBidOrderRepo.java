
package com.mthree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.dto.TimothyBidOrderDTO;
import com.mthree.model.TimothyBidOrder;
import com.mthree.model.TimothyInstrument;

@Repository
public interface TimothyBidOrderRepo extends JpaRepository<TimothyBidOrder, Integer> {

	public List<TimothyBidOrder> findByInstrument(TimothyInstrument ti);

	@Query("SELECT b.price, b.volume FROM TimothyBidOrder b WHERE b.instrument = :instrument ")
	public List<Object[]> dfindByInstrumentaa(@Param("instrument") TimothyInstrument t);
	
//	@Query("SELECT new com.mthree.dto.TimothyBidOrderDTO(b.id, b.userId,  b.price, b.volume, b.Instrument) FROM TimothyBidOrder b")
	@Query("SELECT new com.mthree.dto.TimothyBidOrderDTO(b.id, u.id) FROM TimothyBidOrder b INNER JOIN b.users u ON")
	public List<TimothyBidOrderDTO[]> dfindByInstrumentaaaa(@Param("instrument") TimothyInstrument t);

	
}
