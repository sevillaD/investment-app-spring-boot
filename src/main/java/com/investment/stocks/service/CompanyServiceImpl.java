package com.investment.stocks.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investment.stocks.model.Company;
import com.investment.stocks.model.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private CompanyRepository repo;

	@Override
	public List<Company> getAllCompanies() {

		return repo.findAll();
	}
	


	@Override
	public Optional<Company> getCompanyById(Long companyId) {

		Optional<Company> company = repo.findById(companyId);

		return company;
	}

	@Override
	public Company addCompany(Company company) {
		
		LocalDateTime createdDate = LocalDateTime.now();
		company.setCreatedDate(createdDate);

		return repo.save(company);
	}

	@Override
	public Company updateCompany(Company company) {

		return repo.save(company);
	}

	@Override
	public void deleteCompany(Long companyId) {

		repo.deleteById(companyId);

	}

}
