package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "TRANSACTION" database table.
 * 
 */
@Entity
@Table(name="TRANSACTION")
public class Transaction  {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TXN_ID")
	private int txnId;

	@Column(name="EMI_PERIOD")
	private String emiPeriod;
	@Column(name= "PAID")
	private BigDecimal paid;

	@Column(name="PROCESSING_FEE")
	private BigDecimal processingFee;

	@Temporal(TemporalType.DATE)
	@Column(name="TXN_DATE")
	private Date txnDate;

	@Column(name="TXN_STATUS")
	private String txnStatus;

	//bi-directional many-to-one association to MonthlyTransaction
//	@OneToMany(mappedBy="transaction")
//	private List<MonthlyTransaction> monthlyTransactions;

	//bi-directional many-to-one association to ProductDetail
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private ProductDetail productDetail;

	//bi-directional many-to-one association to UserInformation
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserInformation userInformation;

	public Transaction() {
		super();
	}

	public Transaction(int txnId, String emiPeriod, BigDecimal paid, BigDecimal processingFee, Date txnDate,
			String txnStatus, List<MonthlyTransaction> monthlyTransactions, ProductDetail productDetail,
			UserInformation userInformation) {
		super();
		this.txnId = txnId;
		this.emiPeriod = emiPeriod;
		this.paid = paid;
		this.processingFee = processingFee;
		this.txnDate = txnDate;
		this.txnStatus = txnStatus;
		//this.monthlyTransactions = monthlyTransactions;
		this.productDetail = productDetail;
		this.userInformation = userInformation;
	}

	public int getTxnId() {
		return this.txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	public String getEmiPeriod() {
		return this.emiPeriod;
	}

	public void setEmiPeriod(String emiPeriod) {
		this.emiPeriod = emiPeriod;
	}

	public BigDecimal getPaid() {
		return this.paid;
	}

	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}

	public BigDecimal getProcessingFee() {
		return this.processingFee;
	}

	public void setProcessingFee(BigDecimal processingFee) {
		this.processingFee = processingFee;
	}

	public Date getTxnDate() {
		return this.txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	public String getTxnStatus() {
		return this.txnStatus;
	}

	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}

//	public List<MonthlyTransaction> getMonthlyTransactions() {
//		return this.monthlyTransactions;
//	}
//
//	public void setMonthlyTransactions(List<MonthlyTransaction> monthlyTransactions) {
//		this.monthlyTransactions = monthlyTransactions;
//	}

//	public MonthlyTransaction addMonthlyTransaction(MonthlyTransaction monthlyTransaction) {
//		getMonthlyTransactions().add(monthlyTransaction);
//		monthlyTransaction.setTransaction(this);
//
//		return monthlyTransaction;
//	}
//
//	public MonthlyTransaction removeMonthlyTransaction(MonthlyTransaction monthlyTransaction) {
//		getMonthlyTransactions().remove(monthlyTransaction);
//		monthlyTransaction.setTransaction(null);
//
//		return monthlyTransaction;
//	}

	public ProductDetail getProductDetail() {
		return this.productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public UserInformation getUserInformation() {
		return this.userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
//
//	@Override
//	public String toString() {
//		return "Transaction [txnId=" + txnId + ", emiPeriod=" + emiPeriod + ", paid=" + paid + ", processingFee="
//				+ processingFee + ", txnDate=" + txnDate + ", txnStatus=" + txnStatus + ", monthlyTransactions="
//				+ monthlyTransactions + ", productDetail=" + productDetail + ", userInformation=" + userInformation
//				+ "]";
//	}

}