package com.example.api.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private BigDecimal totalValue;
    private String status;
    private String category;
    private String paymentMethod;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ItemEntity> items = new ArrayList<>();
}
