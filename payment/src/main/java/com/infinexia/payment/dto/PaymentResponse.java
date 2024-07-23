package com.infinexia.payment.dto;

import lombok.Data;

@Data
public class PaymentResponse {
    private String payment_url;
    private String token;
    private String code;
    private String status;
}
