package ru.otus.popovab.l021;

import java.math.BigDecimal;

public class Payment {

    private int id;
    private BigDecimal amount;
    private int currency;
    private String agreement;
    private char status;


    public void setPaymentId(int id){
        this.id = id;
    }

    public void setPaymentAmount(BigDecimal amount){
        this.amount = amount;
    }

    public void setPaymentCurrency(int currency){
        this.currency = currency;
    }

    public void setPaymentAgreement(String agreement){
        this.agreement = agreement;
    }

    public void setPaymentStatus(char status){
        this.status = status;
    }
}
