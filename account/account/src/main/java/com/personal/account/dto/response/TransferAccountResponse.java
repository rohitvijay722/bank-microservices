package com.personal.account.dto.response;

public class TransferAccountResponse {
	
	private String message;
	private double transferredAmount;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getTransferredAmount() {
		return transferredAmount;
	}
	public void setTransferredAmount(double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}
	
	

}
