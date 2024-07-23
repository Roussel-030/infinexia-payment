package com.infinexia.payment.dto;

import lombok.Data;

@Data
public class TransactionDetails {
    private String transaction_id;
    private String status;
    private String token;
    private String wallet;
    private double amount;
    private String currency;
    private String reference;
}
