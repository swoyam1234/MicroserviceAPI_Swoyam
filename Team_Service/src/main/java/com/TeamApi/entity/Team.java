package com.TeamApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uuid;
	private int companyId;
	private String teamLeadName;
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getTeamLeadName() {
		return teamLeadName;
	}
	public void setTeamLeadName(String teamLeadName) {
		this.teamLeadName = teamLeadName;
	}
	public Team(int uuid, int companyId, String teamLeadName) {
		super();
		this.uuid = uuid;
		this.companyId = companyId;
		this.teamLeadName = teamLeadName;
	}
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Team [uuid=" + uuid + ", companyId=" + companyId + ", teamLeadName=" + teamLeadName + "]";
	}
	
	

}
