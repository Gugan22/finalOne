package com.bidd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bidd.app.enitity.LivePlayers;
import com.bidd.app.enitity.UserMaster;

public interface LivePlayersDao extends CrudRepository<LivePlayers, Integer>{

	@Query("SELECT p FROM LivePlayers p WHERE p.batchId IN (:ids)")
	public List<LivePlayers> findByBatchId(@Param("ids") String mail);
	
	@Query("SELECT p FROM LivePlayers p WHERE p.playerId IN (:ids)")
	public List<LivePlayers> findByplayerId(@Param("ids") String mail);
	
	@Modifying
	@Query("DELETE FROM LivePlayers u where u.batchId = :id")
	void deletePlayerByBatch (  @Param(value = "id") String id);

}
