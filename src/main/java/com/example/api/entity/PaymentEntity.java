package com.example.api.entity;

import com.example.api.domain.payment.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        private String name;
        private BigDecimal totalValue;
        private String status;
        private String category;
        private String paymentMethod;
        private List<Item> items;
}
