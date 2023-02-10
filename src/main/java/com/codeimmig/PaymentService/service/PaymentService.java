package com.codeimmig.PaymentService.service;

import com.codeimmig.PaymentService.model.PaymentRequest;
import com.codeimmig.PaymentService.model.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
