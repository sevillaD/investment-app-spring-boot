package com.investment.stocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investment.stocks.model.Transactions;
import com.investment.stocks.service.ITransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("investment")
@Tag(name="Transactions Controller")
public class TransactionController {
	
	@Autowired
	private ITransactionService transactionService;
	
	 
	// localhost:8000/investments/all-transactions
	
	@GetMapping("all-transactions")
	@Operation(summary="This endpoint returns all the existing transactions")
	public ResponseEntity<?> getAllTransactions(){
		return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
	}
	
	@GetMapping("allTransactions")
	@Operation(summary="This endpoint returns all transactions and shows stock symbol as well")
	public ResponseEntity<?> findAllTransactions(){
		return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
	}
	
	
	@GetMapping("allOpenTransactions")
	@Operation(summary="This endpoint returns all transactions and shows stock symbol as well")
	public ResponseEntity<?> findAllOpenTransactions(String status){
		status = "Open";
		return new ResponseEntity<>(transactionService.findAllOpenTransactions(status), HttpStatus.OK);
	}
	
	
	
	@GetMapping("transaction/{id}")
	@Operation(summary="This endpoint returns a transaction by Id. It does not show company data")
	private ResponseEntity<?> getTransactionById(@PathVariable("id") Long transactionId){
		return new ResponseEntity<>(transactionService.getTransactionById(transactionId), HttpStatus.OK);
	}
	
	@GetMapping("transaction-id/{id}")
	@Operation(summary="This endpoint returns a transaction by Id using a JPQL query instead of the standard JPA repository default method. It does not show company data")
	private ResponseEntity<?> findTransactionById(@PathVariable("id") Long transactionId){
		return new ResponseEntity<>(transactionService.findByTransactionId(transactionId), HttpStatus.OK);
	}
	
	@GetMapping("get-transaction-id/{id}")
	@Operation(summary="This endpoint returns a transaction by Id, however it also returns the company/stock symbol as well")
	private ResponseEntity<?> getTransactionbyTransactionId(@PathVariable("id") Long transactionId){
		return new ResponseEntity<>(transactionService.findTransactionByTransactionId(transactionId), HttpStatus.OK);
	}
	
	
	@PostMapping("/add-transaction")
	@Operation(summary="This endpoint allows us to add a new transaction")
	public ResponseEntity<?> addTransaction(@RequestBody Transactions transaction){
		
		Transactions newTransaction = transactionService.addTransaction(transaction);
		
		return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
		
	}
	
	@PutMapping("update-transaction")
	@Operation(summary="This endpoint updates a transaction")
	public ResponseEntity<?> updateTransaction(@RequestBody Transactions transaction){
		
		return new ResponseEntity<>(transactionService.updateTransactions(transaction), HttpStatus.ACCEPTED);
	}

}
