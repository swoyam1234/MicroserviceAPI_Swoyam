package com.TeamApi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.TeamApi.entity.Team;
import com.TeamApi.service.TeamService;
import com.TeamApi.vo.Company;
import com.TeamApi.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/")
	public ResponseEntity<Team> createTeam(@RequestBody Team team)
	{
		Team t = null;
		
		try {
			
			t=this.teamService.addTeam(team);
			return ResponseEntity.of(Optional.of(team));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/allteam")
	public ResponseEntity<List<ResponseTemplateVO>> getTeams()
	{
		List<ResponseTemplateVO> list = new ArrayList<ResponseTemplateVO>();
		List<Team> tList = teamService.getAllTeam();
		
		if(tList.size() <= 0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			
			tList.forEach(
		            (temp) -> { 
		            	
		            	Company company = restTemplate.getForObject("http://COMPANY-SERVICE/company/id/"+temp.getCompanyId(), Company.class);
		            	ResponseTemplateVO vo = new ResponseTemplateVO(company, temp);
		            	list.add(vo);
		            });
		
		return ResponseEntity.of(Optional.of(list));
		}
	}
	

}
