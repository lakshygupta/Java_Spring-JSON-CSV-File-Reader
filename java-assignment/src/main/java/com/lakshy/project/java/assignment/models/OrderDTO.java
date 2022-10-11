package com.lakshy.project.java.assignment.models;

public class OrderDTO {
	private static int idr = 1;
	private int id;
	private int orderId;
	private double amount;
	private String currency;
	private String comment;
	private String filename;
	private int line;
	private String result;
	
	public int getId() {
		return idr;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void incrId() {
		this.idr++;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "{id=" + id + ", orderId=" + orderId + ", amount=" + amount + ", currency=" + currency + ", comment=" + comment
				+ ", filename=" + filename + ", line=" + line + ", result=" + result + "}";
	}
	
	
}
