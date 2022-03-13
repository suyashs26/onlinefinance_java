package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRODUCT_DETAILS database table.
 * 
 */
@Entity
@Table(name="PRODUCT_DETAILS")
public class ProductDetail {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="COST")
	private BigDecimal cost;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRODUCT_TYPE")
	private String productType;

//	//bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy="productDetail")
//	private List<Transaction> transactions;

	public ProductDetail() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

//	public List<Transaction> getTransactions() {
//		return this.transactions;
//	}
//
//	public void setTransactions(List<Transaction> transactions) {
//		this.transactions = transactions;
//	}

//	@Override
//	public String toString() {
//		return "ProductDetail [productId=" + productId + ", cost=" + cost + ", productName=" + productName
//				+ ", productType=" + productType + ", transactions=" + transactions + "]";
//	}

//	public Transaction addTransaction(Transaction transaction) {
//		getTransactions().add(transaction);
//		transaction.setProductType(this);
//		return transaction;
//	}
//
//	public Transaction removeTransaction(Transaction transaction) {
//		getTransactions().remove(transaction);
//		transaction.setProductDetail(null);
//
//		return transaction;
//	}

}