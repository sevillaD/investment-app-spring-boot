package com.investment.stocks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.investment.stocks.model.Transactions;
import com.investment.stocks.projection.ITransactionTrade;

public interface ITransactionService {
	
	List<Transactions> getAllTransactions();
	
	Optional<Transactions> getTransactionById(Long transactionId);
	
	Optional<Transactions> findByTransactionId(Long transactionId);
	
	Optional<ITransactionTrade> findTransactionByTransactionId(Long transactionId);
	
	Transactions addTransaction(Transactions transaction);
	
	List<ITransactionTrade> findAllTransactions();
	
	List<ITransactionTrade> findAllOpenTransactions(String status);
	
	Transactions updateTransactions(Transactions transaction);


}
