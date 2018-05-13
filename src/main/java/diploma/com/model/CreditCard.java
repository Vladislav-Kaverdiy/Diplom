package diploma.com.model;

import java.io.Serializable;

public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer creditCardId;
	private Long creditCardNumber;
	private Integer monthExpiration;
	private Integer yearExpiration;
	private Integer cvs;
	private String description;
	private Double balance;
	private Integer userId;
	private boolean blocked;
	private Long bill;

	public Integer getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(Integer creditCardId) {
		this.creditCardId = creditCardId;
	}

	public Long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Integer getMonthExpiration() {
		return monthExpiration;
	}

	public void setMonthExpiration(Integer monthExpiration) {
		this.monthExpiration = monthExpiration;
	}

	public Integer getYearExpiration() {
		return yearExpiration;
	}

	public void setYearExpiration(Integer yearExpiration) {
		this.yearExpiration = yearExpiration;
	}

	public Integer getCvs() {
		return cvs;
	}

	public void setCvs(Integer cvs) {
		this.cvs = cvs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public Long getBill() {
		return bill;
	}

	public void setBill(Long bill) {
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
