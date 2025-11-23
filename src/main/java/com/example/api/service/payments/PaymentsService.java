package com.example.api.service.payments;

import com.example.api.domain.payment.Payment;
import com.example.api.dto.payments.CreatePaymentResponseDto;
import com.example.api.dto.payments.CreatePaymentsDto;
import com.example.api.entity.PaymentEntity;

public interface PaymentsService {
    CreatePaymentResponseDto createPayment(CreatePaymentsDto payment);
}
