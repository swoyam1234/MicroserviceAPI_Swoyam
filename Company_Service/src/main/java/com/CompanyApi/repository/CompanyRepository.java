package com.CompanyApi.repository;


import org.springframework.data.repository.CrudRepository;

import com.CompanyApi.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	public Company findCompanyByCompanyName(String name);

}
