package com.investment.stocks.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.investment.stocks.model.Transactions;
import com.investment.stocks.projection.ITransactionTrade;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

	/** The below means: Select * from Transactions where transaction_id = ?1 **/
	@Query("SELECT t FROM Transactions t where transaction_id = ?1")
	Optional<Transactions> findByTransactionId(Long transactionId);

	// In this kind of query, if we do not add the alias then it will show values as
	// null
	// The fields in the projection are the fields we will show in the result
	@Query("SELECT t.transactionId as transactionId, "
			+ " c.stockSymbol as stockSymbol, t.transactionAmount as transactionAmount, "
			+ " t.transactionType as transactionType, " + " t.quantity as quantity, " + " t.buyingDate as buyingDate, "
			+ " t.sellingDate as sellingDate, " + " t.price as price, t.sellingPrice as sellingPrice, "
			+ " t.realizedGain as realizedGain," + " t.status as status, " 
			+ " t.createdBy as createdBy," + " t.createdDate as createdDate, "
			+ " t.lastUpdatedBy as lastUpdatedBy, " + " t.lastUpdatedDate as lastUpdatedDate "
			+ " FROM Transactions t left join Company c on (t.companyId = c.companyId) "
			+ " where t.transactionId = :transactionId")
	Optional<ITransactionTrade> findTransactionByTransactionId(@Param("transactionId") Long transactionId);

	// In this kind of query, if we do not add the alias then it will show values as
	// null
	// The fields in the projection are the fields we will show in the result
	@Query("SELECT t.transactionId as transactionId, "
			+ " c.stockSymbol as stockSymbol, t.transactionAmount as transactionAmount, "
			+ " t.transactionType as transactionType, " + " t.quantity as quantity, " + " t.buyingDate as buyingDate, "
			+ " t.sellingDate as sellingDate, " + " t.price as price, t.sellingPrice as sellingPrice, "
			+ " t.realizedGain as realizedGain," + " t.status as status, " 
			+ " t.createdBy as createdBy," + " t.createdDate as createdDate, "
			+ " t.lastUpdatedBy as lastUpdatedBy, " + " t.lastUpdatedDate as lastUpdatedDate "
			+ " FROM Transactions t left join Company c on (t.companyId = c.companyId) ")
	List<ITransactionTrade> findAllTransactions();
	
	
	@Query("SELECT t.transactionId as transactionId, "
			+ " c.stockSymbol as stockSymbol, t.transactionAmount as transactionAmount, "
			+ " t.transactionType as transactionType, " + " t.quantity as quantity, " + " t.buyingDate as buyingDate, "
			+ " t.sellingDate as sellingDate, " + " t.price as price, t.sellingPrice as sellingPrice, "
			+ " t.realizedGain as realizedGain," + " t.status as status, " 
			+ " t.createdBy as createdBy," + " t.createdDate as createdDate, "
			+ " t.lastUpdatedBy as lastUpdatedBy, " + " t.lastUpdatedDate as lastUpdatedDate "
			+ " FROM Transactions t left join Company c on (t.companyId = c.companyId) where t.status = :status ")
	List<ITransactionTrade> findAllOpenTransactions(@Param("status") String status);

}
