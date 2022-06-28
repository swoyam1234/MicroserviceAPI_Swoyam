package com.CompanyApi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CompanyApi.entity.Company;
import com.CompanyApi.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/")
	public ResponseEntity<Company> createCompany(@RequestBody Company company)
	{
		Company com = null;
		
		try {
			
			com=this.companyService.addCompany(company);
			return ResponseEntity.of(Optional.of(company));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable("id") int id)
	{
		Optional<Company> com = companyService.getCompanyById(id);
		if(com == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(com);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Company> getCompanyFromName(@PathVariable("name") String name)
	{
		Company com = companyService.getCompanyByName(name);
		if(com == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(com);
		
	}

}
