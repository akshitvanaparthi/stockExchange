
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

	public List<TimothyBidOrder> findAllByInstrument(TimothyInstrument ti);

//	@Query("SELECT b.price, b.volume FROM TimothyBidOrder b WHERE b.instrument = :instrument ")
//	public List<Object[]> dfindByInstrumentaa(@Param("instrument") TimothyInstrument t);
	
	
//	public TimothyBidOrderDTO(int id, int userId, double price, int volume, int imothyInstrumentId) {
	@Query("SELECT new com.mthree.dto.TimothyBidOrderDTO("
				+ "b.id, b.users.id, b.price, b.volume, b.instrument.id, b.state) "
			+ "FROM TimothyBidOrder b WHERE instrument = :instrument "
			)
	public List<TimothyBidOrderDTO> findBidOrdersDTOByInstrument(@Param("instrument") TimothyInstrument t);

	
}
