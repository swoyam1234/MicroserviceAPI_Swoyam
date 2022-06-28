package com.TeamApi.vo;

import com.TeamApi.entity.Team;

public class ResponseTemplateVO {
	
	private Company company;
	private Team team;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public ResponseTemplateVO(Company company, Team team) {
		super();
		this.company = company;
		this.team = team;
	}
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
