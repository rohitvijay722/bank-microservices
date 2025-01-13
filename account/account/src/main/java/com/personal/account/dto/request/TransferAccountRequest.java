package com.personal.account.dto.request;

public class TransferAccountRequest {
	
	private long payerAccountNum;
	private long payeeAccountNum;
	private double amount;
	private String mpin;
	public long getPayerAccountNum() {
		return payerAccountNum;
	}
	public void setPayerAccountNum(long payerAccountNum) {
		this.payerAccountNum = payerAccountNum;
	}
	public long getPayeeAccountNum() {
		return payeeAccountNum;
	}
	public void setPayeeAccountNum(long payeeAccountNum) {
		this.payeeAccountNum = payeeAccountNum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMpin() {
		return mpin;
	}
	public void setMpin(String mpin) {
		this.mpin = mpin;
	}

	
}
