package com.codeimmig.PaymentService.service;

import com.codeimmig.PaymentService.entity.TransactionDetails;
import com.codeimmig.PaymentService.model.PaymentMode;
import com.codeimmig.PaymentService.model.PaymentRequest;
import com.codeimmig.PaymentService.model.PaymentResponse;
import com.codeimmig.PaymentService.repository.TransactionDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class PaymentServiceImpl  implements  PaymentService{
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;
    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording payment Details :{}:", paymentRequest);
        TransactionDetails transactionDetails=TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReference())
                .amount(paymentRequest.getAmount())
                .build();
        transactionDetailsRepository.save(transactionDetails);
        log.info("Transaction completed with id {} :",transactionDetails.getId());
        return  transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(String orderId) {
        log.info(" getting details  payment details  for orderId : {}",orderId);
        TransactionDetails transactionDetails=transactionDetailsRepository.findByOrderId(Long.valueOf(orderId));
        PaymentResponse paymentResponse=PaymentResponse
                .builder()
                .paymentId(transactionDetails.getId())
                .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                .paymentyDate(transactionDetails.getPaymentDate())
                .oderId(transactionDetails.getOrderId())
                .status(transactionDetails.getPaymentStatus())
                .amount(transactionDetails.getAmount())
                .build();
        return paymentResponse;
    }
}
