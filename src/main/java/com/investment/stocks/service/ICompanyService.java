package com.investment.stocks.service;

import java.util.List;
import java.util.Optional;

import com.investment.stocks.model.Company;

public interface ICompanyService {
	
	
	List<Company> getAllCompanies();
	
	Optional<Company> getCompanyById(Long companyId);
	
	Company addCompany(Company company);
	
	Company updateCompany(Company company);
	
	void deleteCompany(Long companyId);
	

}
