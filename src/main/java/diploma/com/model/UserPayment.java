package diploma.com.model;

import java.io.Serializable;
import java.util.Date;

public class UserPayment implements Serializable {
    private Integer paymentId;
    private Date creationDate;
    private boolean state;
    private Integer creditCardId;
    private Double sum;
    private String description;
    private Long recipientBill;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Integer creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRecipientBill() {
        return recipientBill;
    }

    public void setRecipientBill(Long recipientBill) {
        this.recipientBill = recipientBill;
    }

    @Override
    public String toString() {
        return "UserPaymentDao{" +
                "paymentId=" + paymentId +
                ", creationDate=" + creationDate +
                ", state=" + state +
                ", creditCardId=" + creditCardId +
                ", sum=" + sum +
                ", description='" + description + '\'' +
                ", recipientBill=" + recipientBill +
                '}';
    }
}
