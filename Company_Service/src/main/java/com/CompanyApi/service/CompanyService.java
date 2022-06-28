package com.CompanyApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CompanyApi.entity.Company;
import com.CompanyApi.repository.CompanyRepository;

@Component
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	public Company addCompany(Company company)
	{
		Company c = companyRepository.save(company);
		return c;
	}
	
	public Optional<Company> getCompanyById(int id)
	{
		Optional<Company> c = companyRepository.findById(id);
		return c;
	}
	
	public Company getCompanyByName(String name)
	{
		Company c = companyRepository.findCompanyByCompanyName(name);
		return c;
	}
	

}
