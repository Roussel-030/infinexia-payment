package com.infinexia.payment.dto;

import lombok.Data;

@Data
public class PaymentStatusResponse {
    private String transaction_id;
    private String status;
    private TransactionDetails transaction;
}
