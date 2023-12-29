package models;

import models.constants.PaymentMode;
import models.constants.PaymentStatus;

public class Payment extends BaseModel{
    private int amount;
    private PaymentMode paymentMode;
    private String transactionNumber;
    private PaymentStatus paymentStatus;
    private Bill bill;
}
