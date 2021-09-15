package com.bidd.app.enitity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_master")
public class TeamMaster {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "team")
	private String team;
	
	@Column(name = "baseAmt")
	private double baseAmt;
	
	@Column(name = "balAmt")
	private double balAmt;
	
	@Column(name = "score")
	private double score;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public double getBaseAmt() {
		return baseAmt;
	}

	public void setBaseAmt(double baseAmt) {
		this.baseAmt = baseAmt;
	}

	public double getBalAmt() {
		return balAmt;
	}

	public void setBalAmt(double balAmt) {
		this.balAmt = balAmt;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	
}
