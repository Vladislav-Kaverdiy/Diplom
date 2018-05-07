package source.it.com.model;

import java.io.Serializable;

public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;

	private int creditCardId;
	private long creditCardNumber;
	private int monthExpiration;
	private int yearExpiration;
	private int cvs;
	private String description;
	private double balance;
	private int userId;
	private boolean blocked;
	private long bill;

	public int getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getMonthExpiration() {
		return monthExpiration;
	}

	public void setMonthExpiration(int monthExpiration) {
		this.monthExpiration = monthExpiration;
	}

	public int getYearExpiration() {
		return yearExpiration;
	}

	public void setYearExpiration(int yearExpiration) {
		this.yearExpiration = yearExpiration;
	}

	public int getCvs() {
		return cvs;
	}

	public void setCvs(int cvs) {
		this.cvs = cvs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public long getBill() {
		return bill;
	}

	public void setBill(long bill) {
		this.bill = bill;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CreditCard [creditCardId=" + creditCardId
				+ ", creditCardNumber=" + creditCardNumber
				+ ", monthExpiration=" + monthExpiration + ", yearExpiration="
				+ yearExpiration + ", cvs=" + cvs + ", description="
				+ description + ", balance=" + balance + ", userId=" + userId
				+ ", blocked=" + blocked + ", bill=" + bill + "]";
	}

}
