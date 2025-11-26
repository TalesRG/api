package com.example.api.dto.payments;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class CreatePaymentResponseDto implements Serializable {
    private String id;
    private String name;
    private String status;
    private String category;
    private String paymentMethod;
    private BigDecimal totalValue;
}
