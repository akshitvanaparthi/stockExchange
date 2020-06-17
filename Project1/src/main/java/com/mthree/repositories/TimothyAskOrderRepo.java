
package com.mthree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.dto.TimothyAskOrderDTO;
import com.mthree.model.TimothyAskOrder;
import com.mthree.model.TimothyInstrument;

@Repository
public interface TimothyAskOrderRepo extends JpaRepository<TimothyAskOrder,Integer>{
	@Query("SELECT new com.mthree.dto.TimothyAskOrderDTO("
			+ "a.id, a.users.id, a.price, a.volume, a.instrument.id, a.state) "
		+ "FROM TimothyAskOrder a WHERE instrument = :instrument "
		)
public List<TimothyAskOrderDTO> findAskOrdersDTOByInstrument(@Param("instrument") TimothyInstrument t);

}
