package com.example.api.domain.payment;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class Payment {
    private String name;
    private BigDecimal  totalValue;
    private String status;
    private String category;
    private String paymentMethod;
    private List<Item> items;
}
