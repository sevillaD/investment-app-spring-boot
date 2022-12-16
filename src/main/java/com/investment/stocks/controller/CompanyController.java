package com.investment.stocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investment.stocks.model.Company;
import com.investment.stocks.service.CompanyServiceImpl;
import com.investment.stocks.service.ICompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("investment")
@Tag(name="Companies Controller")
public class CompanyController {
	
	@Autowired
	private ICompanyService companyService;
	
	
	// localhost:8000/investment/all-companies
	
	@GetMapping("/all-companies")
	@Operation(summary="This endpoint will return all companies")
	public ResponseEntity<?> findAllCompanies(){
		
		return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
		
	}
	
	// localhost:8000/investment/company/id
	
	@GetMapping("/company/{id}")
	@Operation(summary="This endpoint returns a company based on its ID")
	public ResponseEntity<?> findCompanyById(@PathVariable("id") Long companyId){
		
		return new ResponseEntity<>(companyService.getCompanyById(companyId), HttpStatus.OK);
		
	}
	
	//localhost:8000/investment/add-company
	
	@PostMapping("/add-company")
	@Operation(summary="This endpoint creates a new company")
	public ResponseEntity<?> addCompany(@RequestBody Company company){
		
		Company newCompany = companyService.addCompany(company);
		
		return new ResponseEntity<>(newCompany, HttpStatus.CREATED);
	}
	
	//localhost:8000/investment/update-company
	
	@PutMapping("/update-company")
	@Operation(summary="This endpoint updates a company")
	public ResponseEntity<?> updateCompany(@RequestBody Company company){
		
		Company companyToUpdate = companyService.updateCompany(company);
		
		return new ResponseEntity<>(companyToUpdate, HttpStatus.OK);
	}
	
	//localhost:8000/investment/delete-company/5
	
	@DeleteMapping("/delete-company/{id}")
	@Operation(summary="This endpoint deletes a company by ID")
	public void deleteCompany(@PathVariable("id") Long companyId) {
		
		companyService.deleteCompany(companyId);
		
	}
	
	

}
