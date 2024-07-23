package com.infinexia.payment.controller;

import com.infinexia.payment.dto.PaymentRequest;
import com.infinexia.payment.dto.PaymentResponse;
import com.infinexia.payment.dto.PaymentStatusRequest;
import com.infinexia.payment.dto.PaymentStatusResponse;
import com.infinexia.payment.service.PaymentServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "payment")
public class PaymentController {

    private final PaymentServiceInterface paymentService;

    @PostMapping(path = "initialize")
    public ResponseEntity<PaymentResponse> initializePayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse response = paymentService.initializePayment(paymentRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "check-status")
    public ResponseEntity<PaymentStatusResponse> checkPaymentStatus(@RequestBody PaymentStatusRequest statusRequest) {
        PaymentStatusResponse response = paymentService.checkPaymentStatus(statusRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
