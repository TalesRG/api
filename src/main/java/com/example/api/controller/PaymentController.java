package com.example.api.controller;

import com.example.api.application.payments.PaymentServiceImplementation;
import com.example.api.dto.payments.CreatePaymentResponseDto;
import com.example.api.dto.payments.CreatePaymentsDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    PaymentServiceImplementation paymentService;

    @Autowired
    PaymentController(PaymentServiceImplementation paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreatePaymentResponseDto> createPayment(@Valid @RequestBody CreatePaymentsDto payment){
        var responseDto = this.paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
