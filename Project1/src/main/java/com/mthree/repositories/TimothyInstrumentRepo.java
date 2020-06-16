package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.model.TimothyInstrument;

@Repository
public interface TimothyInstrumentRepo extends JpaRepository<TimothyInstrument,Integer>{

}
