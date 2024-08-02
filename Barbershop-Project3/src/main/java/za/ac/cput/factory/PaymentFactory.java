package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.Date;

public class PaymentFactory {
    public static Payment buildPayment(String paymentId, String paymentDescription, LocalDate paymentDate, int paymentAmount){
        if (Helper.isNullOrEmpty(paymentId) || Helper.isNullOrEmpty(paymentDescription) )
            return null;
        if (paymentAmount < 0)
            return null;
        if ( paymentDate == LocalDate.now())
            return null;
        return new Payment.Builder().setPaymentId(paymentId)
                .setPaymentAmount(paymentAmount)
                .setPaymentDate(paymentDate)
                .setPaymentDescription(paymentDescription)
                .build();
    }
    public static Payment buildPayment(String paymentDescription, LocalDate paymentDate, int paymentAmount){
       if (Helper.isNullOrEmpty(paymentDescription) ||  !Helper.dateIsValid(paymentDate) )
            return null;
        if (paymentAmount < 0)
            return null;
 String paymentId = Helper.generateId();

        return new Payment.Builder().setPaymentId(paymentId)
                .setPaymentAmount(paymentAmount)
                .setPaymentDate(paymentDate)
                .setPaymentDescription(paymentDescription)
                .build();
    }
}
