package com.bidd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bidd.app.enitity.BatchAssignment;
import com.bidd.app.enitity.PlayerMaster;

public interface BatchAssignmentDao extends CrudRepository<BatchAssignment, Integer>{

	@Query("SELECT p FROM BatchAssignment p WHERE p.userId IN (:ids)")
	public List<BatchAssignment> findByUserId(@Param("ids") String id);
	
	
	@Query("SELECT p FROM BatchAssignment p WHERE p.teamId IN (:ids)")
	public List<BatchAssignment> findByTeamId(@Param("ids") String id);
	
	
	@Query("SELECT p FROM BatchAssignment p WHERE p.batchId IN (:ids)")
	public List<BatchAssignment> findByBatchId(@Param("ids") String id);
	
	
	@Modifying
	@Query("update BatchAssignment u set  u.isOn = :bal where u.batchId = :id")
	void updateFinalPriceNTeam ( @Param(value = "bal") String bal , @Param(value = "id") String id);

}
