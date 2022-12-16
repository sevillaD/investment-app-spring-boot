package com.investment.stocks.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	@Column(name = "transaction_type")
	private String transactionType;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price")
	private double price;

	@Column(name = "transaction_amount")
	private double transactionAmount;

	@Column(name = "buying_date")
	private LocalDate buyingDate;

	@Column(name = "selling_date")
	private LocalDate sellingDate;

	@Column(name = "selling_price")
	private double sellingPrice;

	@Column(name = "realized_gain")
	private double realizedGain;

	@Column(name = "status")
	private String status;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	@Column(name = "last_updated_date")
	private LocalDateTime lastUpdatedDate;

	@Column(name = "company_id")
	private Integer companyId;

	public Transactions() {

	}

	public Transactions(String transactionType, Integer quantity, double price, double transactionAmount,
			LocalDate buyingDate, LocalDate sellingDate, double sellingPrice, double realizedGain, String status,
			String createdBy, LocalDateTime createdDate, String lastUpdatedBy, LocalDateTime lastUpdatedDate,
			Integer companyId) {
		super();
		this.transactionType = transactionType;
		this.quantity = quantity;
		this.price = price;
		this.transactionAmount = transactionAmount;
		this.buyingDate = buyingDate;
		this.sellingDate = sellingDate;
		this.sellingPrice = sellingPrice;
		this.realizedGain = realizedGain;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
		this.companyId = companyId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDate getBuyingDate() {
		return buyingDate;
	}

	public void setBuyingDate(LocalDate buyingDate) {
		this.buyingDate = buyingDate;
	}

	public LocalDate getSellingDate() {
		return sellingDate;
	}

	public void setSellingDate(LocalDate sellingDate) {
		this.sellingDate = sellingDate;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getRealizedGain() {
		return realizedGain;
	}

	public void setRealizedGain(double realizedGain) {
		this.realizedGain = realizedGain;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", transactionType=" + transactionType + ", quantity="
				+ quantity + ", price=" + price + ", transactionAmount=" + transactionAmount + ", buyingDate="
				+ buyingDate + ", sellingDate=" + sellingDate + ", sellingPrice=" + sellingPrice + ", realizedGain="
				+ realizedGain + ", status=" + status + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", companyId="
				+ companyId + "]";
	}

}
