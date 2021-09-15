package com.bidd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bidd.app.enitity.TeamMaster;



public interface TeamMasterDao extends CrudRepository<TeamMaster, Integer>{

	@Query("SELECT p FROM Playermaster p WHERE p.id IN (:ids)")
	public List<TeamMaster> findById(@Param("ids") String id);
	
	
}
