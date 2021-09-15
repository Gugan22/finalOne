package com.bidd.app.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="live_players")
public class LivePlayers {

	@Id
	@Column(name = "batch_id",unique=true, nullable=false)
	private String batchId;
	
	@Id
	@Column(name = "player_id",unique=true, nullable=false)
	private String playerId;
	
	@Column(name = "slot")
	private String slot;

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	
}
