package com.CompanyApi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uuid;
	
	private String companyName;
	private String companyCEO;
	private String companyAddress;
	private Date inceptionDate;
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public Date getInceptionDate() {
		return inceptionDate;
	}
	public void setInceptionDate(Date inceptionDate) {
		this.inceptionDate = inceptionDate;
	}
	public Company(int uuid, String companyName, String companyCEO, String companyAddress, Date inceptionDate) {
		super();
		this.uuid = uuid;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyAddress = companyAddress;
		this.inceptionDate = inceptionDate;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Company [uuid=" + uuid + ", companyName=" + companyName + ", companyCEO=" + companyCEO
				+ ", companyAddress=" + companyAddress + ", inceptionDate=" + inceptionDate + "]";
	}
	
	
	
	

}
