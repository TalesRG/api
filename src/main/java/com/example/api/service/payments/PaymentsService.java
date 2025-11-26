package com.example.api.service.payments;

import com.example.api.dto.payments.CreatePaymentResponseDto;
import com.example.api.dto.payments.CreatePaymentsDto;
import com.example.api.entity.PaymentEntity;

import java.util.ArrayList;
import java.util.List;

public interface PaymentsService {
    CreatePaymentResponseDto createPayment(CreatePaymentsDto payment);
    List<CreatePaymentResponseDto> getAllPayments();
}
