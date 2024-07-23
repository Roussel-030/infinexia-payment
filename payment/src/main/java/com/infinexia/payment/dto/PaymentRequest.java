package com.infinexia.payment.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private String transaction_id;
    private String wallet;
    private double amount;
    private String currency;
    private String call_back_url;
    private String success_url;
    private String fail_url;
    private String description;
    private String payee_name;
    private String reference;
}
