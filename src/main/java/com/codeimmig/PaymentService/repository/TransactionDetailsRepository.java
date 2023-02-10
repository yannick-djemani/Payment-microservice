package com.codeimmig.PaymentService.repository;

import com.codeimmig.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {
    TransactionDetails findByOrderId(long orderId);
}
