package com.example.api.service.payments;

import com.example.api.domain.payment.Payment;
import com.example.api.dto.payments.CreatePaymentsDto;

public interface PaymentsService {
    Payment createPayment(CreatePaymentsDto payment);
}
