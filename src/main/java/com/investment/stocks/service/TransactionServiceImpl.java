package com.investment.stocks.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.investment.stocks.model.Transactions;
import com.investment.stocks.model.repository.CompanyRepository;
import com.investment.stocks.model.repository.TransactionRepository;
import com.investment.stocks.projection.ITransactionTrade;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private TransactionRepository repo;

	@Autowired
	private CompanyRepository companyRepo;

	@Override
	public List<Transactions> getAllTransactions() {

		return repo.findAll();
	}

	@Override
	public Optional<Transactions> getTransactionById(Long transactionId) {

		return repo.findById(transactionId);
	}

	@Override
	public Optional<Transactions> findByTransactionId(Long transactionId) {
		
		return repo.findByTransactionId(transactionId);
	}

	@Override
	public Optional<ITransactionTrade> findTransactionByTransactionId(Long transactionId) {

		return repo.findTransactionByTransactionId(transactionId);
	}

	@Override
	public Transactions addTransaction(Transactions transaction) {
		
		LocalDateTime createdDate = LocalDateTime.now();
		double transactionAmount = transaction.getPrice() * transaction.getQuantity();
		String status = "Open";

		transaction.setTransactionAmount(transactionAmount);
		transaction.setCreatedDate(createdDate);
		transaction.setStatus(status);

		return repo.save(transaction);
	}

	@Override
	public List<ITransactionTrade> findAllTransactions() {

		return repo.findAllTransactions();
	}

	@Override
	public Transactions updateTransactions(Transactions transaction) {
		
		LocalDate sellingDate = transaction.getSellingDate();
		double sellingPrice = transaction.getSellingPrice();

		if (sellingPrice != 0) {

			double realizedGain = (sellingPrice * transaction.getQuantity()) - transaction.getTransactionAmount();
			transaction.setRealizedGain(realizedGain);
		}
		
		transaction.setSellingDate(sellingDate);

		return repo.save(transaction);
	}

	@Override
	public List<ITransactionTrade> findAllOpenTransactions(String status) {
				
		return repo.findAllOpenTransactions(status);
	}

}
