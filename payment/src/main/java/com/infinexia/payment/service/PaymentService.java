package com.infinexia.payment.service;

import com.infinexia.payment.dto.PaymentRequest;
import com.infinexia.payment.dto.PaymentResponse;
import com.infinexia.payment.dto.PaymentStatusRequest;
import com.infinexia.payment.dto.PaymentStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentServiceInterface {

    @Value("${infinexia.api.url}")
    private String apiUrl;

    @Value("${infinexia.app.id}")
    private String appId;

    @Value("${infinexia.app.key}")
    private String appKey;

    private final RestTemplate restTemplate;

    @Override
    public PaymentResponse initializePayment(PaymentRequest paymentRequest) {
        HttpHeaders headers = createHeaders();
        HttpEntity<PaymentRequest> entity = new HttpEntity<>(paymentRequest, headers);

        ResponseEntity<PaymentResponse> response = restTemplate.exchange(
                apiUrl + "/initialize",
                HttpMethod.POST,
                entity,
                PaymentResponse.class
        );

        return response.getBody();
    }

    @Override
    public PaymentStatusResponse checkPaymentStatus(PaymentStatusRequest statusRequest) {
        HttpHeaders headers = createHeaders();
        HttpEntity<PaymentStatusRequest> entity = new HttpEntity<>(statusRequest, headers);

        ResponseEntity<PaymentStatusResponse> response = restTemplate.exchange(
                apiUrl + "/check-status",
                HttpMethod.POST,
                entity,
                PaymentStatusResponse.class
        );

        return response.getBody();
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("App-id", appId);
        headers.set("App-key", appKey);
        return headers;
    }

}
