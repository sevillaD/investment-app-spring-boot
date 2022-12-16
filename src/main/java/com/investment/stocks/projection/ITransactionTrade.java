package com.investment.stocks.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ITransactionTrade {
	
	String getStockSymbol();
	
	Long getTransactionId();
	
	double getTransactionAmount();
	
	String getTransactionType();
	
	Integer getQuantity();
	
	LocalDate getBuyingDate();
	
	LocalDate getSellingDate();
	
	double getPrice();
	
	double getSellingPrice();
	
	double getRealizedGain();
	
	String getStatus();
	
	String getCreatedBy();
	
	LocalDateTime getCreatedDate();
	
	String getLastUpdatedBy();
	
	LocalDateTime getLastUpdatedDate();

}
