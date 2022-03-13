package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MONTHLY_TRANSACTION database table.
 * 
 */
@Entity
@Table(name="MONTHLY_TRANSACTION")
public class MonthlyTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MTXN_ID")
	private int mtxnId;

	@Column(name="MONTHLY_INSTALLMENT")
	private BigDecimal monthlyInstallment;

	@Temporal(TemporalType.DATE)
	@Column(name="MTXN_DATE")
	private Date mtxnDate;

	@Column(name="MTXN_STATUS")
	private String mtxnStatus;

	//bi-directional many-to-one association to Transaction
	@ManyToOne
	@JoinColumn(name="TXN_ID")
	private Transaction transaction;

	public MonthlyTransaction() {
	}

	public int getMtxnId() {
		return this.mtxnId;
	}

	public void setMtxnId(int mtxnId) {
		this.mtxnId = mtxnId;
	}

	public BigDecimal getMonthlyInstallment() {
		return this.monthlyInstallment;
	}

	public void setMonthlyInstallment(BigDecimal monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}

	public Date getMtxnDate() {
		return this.mtxnDate;
	}

	public void setMtxnDate(Date mtxnDate) {
		this.mtxnDate = mtxnDate;
	}

	public String getMtxnStatus() {
		return this.mtxnStatus;
	}

	public void setMtxnStatus(String mtxnStatus) {
		this.mtxnStatus = mtxnStatus;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "MonthlyTransaction [mtxnId=" + mtxnId + ", monthlyInstallment=" + monthlyInstallment + ", mtxnDate="
				+ mtxnDate + ", mtxnStatus=" + mtxnStatus + ", transaction=" + transaction + "]";
	}

}