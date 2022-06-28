package com.TeamApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.TeamApi.entity.Team;
import com.TeamApi.repository.TeamRepository;

@Component
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	public Team addTeam(Team team)
	{
		Team t = (Team) teamRepository.save(team);
		return t;
		
	}
	
	public List<Team> getAllTeam()
	{
		List<Team> list = (List<Team>) teamRepository.findAll();
		
		return list;
	}

}
