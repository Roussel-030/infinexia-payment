package com.infinexia.payment.service;

import com.infinexia.payment.dto.PaymentRequest;
import com.infinexia.payment.dto.PaymentResponse;
import com.infinexia.payment.dto.PaymentStatusRequest;
import com.infinexia.payment.dto.PaymentStatusResponse;

public interface PaymentServiceInterface {
    PaymentResponse initializePayment(PaymentRequest paymentRequest);
    PaymentStatusResponse checkPaymentStatus(PaymentStatusRequest statusRequest);
}
