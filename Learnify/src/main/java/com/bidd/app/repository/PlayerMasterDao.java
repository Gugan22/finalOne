package com.bidd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bidd.app.enitity.PlayerMaster;
import com.bidd.app.enitity.TeamMaster;

public interface PlayerMasterDao extends CrudRepository<PlayerMaster, Integer>{

	@Query("SELECT p FROM PlayerMaster p WHERE p.id IN (:ids)")
	public List<PlayerMaster> findById(@Param("ids") String id);
	
	
}
