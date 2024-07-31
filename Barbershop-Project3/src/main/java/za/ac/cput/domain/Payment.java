package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment {
   @Id
    private String paymentId;
    private String paymentDescription;
    private LocalDate paymentDate;
    private int paymentAmount;

    protected Payment() {
    }

    public Payment(Builder builder){
        this.paymentId = builder.paymentId;
        this.paymentAmount = builder.paymentAmount;
        this.paymentDescription = builder.paymentDescription;
        this.paymentDate = builder.paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentAmount == payment.paymentAmount && Objects.equals(paymentId, payment.paymentId) && Objects.equals(paymentDescription, payment.paymentDescription) && Objects.equals(paymentDate, payment.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, paymentDescription, paymentDate, paymentAmount);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", paymentDescription='" + paymentDescription + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
    public static class Builder{
        private String paymentId;
        private String paymentDescription;
        private LocalDate paymentDate;
        private int paymentAmount;



    public Builder setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public Builder setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
        return this;
    }

    public Builder setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public Builder setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public Builder copy(Payment payment) {
        this.paymentId = payment.paymentId;
        this.paymentAmount = payment.paymentAmount;
        this.paymentDescription = payment.paymentDescription;
        this.paymentDate = payment.paymentDate;
        return this;
    }
    public Payment build() {return new Payment(this ) ;}
}
}