package com.investment.stocks.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.investment.stocks.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
