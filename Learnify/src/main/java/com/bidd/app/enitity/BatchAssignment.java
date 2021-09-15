package com.bidd.app.enitity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="batch_assignment")
public class BatchAssignment {

	
	@Id
	@Column(name = "user_id",unique=true, nullable=false)
	private String userId;
	
	@Id
	@Column(name = "team_id",unique=true, nullable=false)
	private String teamId;
	
	@Id
	@Column(name = "batch_id",unique=true, nullable=false)
	private String batchId;
	
	@Column(name = "date")
	private Date gameDate;
	
	@Column(name = "gameOn")
	private boolean isOn;
	
	@Column(name = "slot")
	private String slot;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	
}
