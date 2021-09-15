package com.bidd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bidd.app.enitity.UserMaster;

public interface UserMasterDao extends CrudRepository<UserMaster, Integer> {
	
	@Query("SELECT p FROM UserMaster p WHERE p.mail IN (:ids)")
	public List<UserMaster> findById(@Param("ids") String mail);
	
}
