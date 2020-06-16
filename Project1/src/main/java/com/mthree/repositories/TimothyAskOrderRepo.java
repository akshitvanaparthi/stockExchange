
package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.model.TimothyAskOrder;

@Repository
public interface TimothyAskOrderRepo extends JpaRepository<TimothyAskOrder,Integer>{

}
