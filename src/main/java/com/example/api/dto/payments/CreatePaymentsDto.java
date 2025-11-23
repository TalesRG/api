package com.example.api.dto.payments;

import com.example.api.domain.payment.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Exemplo de JSON para esta classe (CreatePaymentsDto):
 *
  {
    "name": "Conta de Luz",
   "totalValue": 199.90,
   "status": "PENDING",
 "category": "ELECTRICITY",
 "paymentMethod": "CREDIT_CARD"
  }

 * Observações:
 * - totalValue é numérico (use ponto para separador decimal).
 * - status, category e paymentMethod são strings livres aqui; ajuste conforme regras do seu domínio.
 */
@Data
public class CreatePaymentsDto {
    @NotBlank(message = "O nome não pode ser nulo")
    private String name;
    @NotNull(message = "O totalValue não pode ser nulo")
    private BigDecimal totalValue;
    @NotBlank(message = "O status não pode ser nulo")
    private String status;
    @NotBlank(message = "O category não pode ser nulo")
    private String category;
    @NotBlank(message = "O paymentMethod não pode ser nulo")
    private String paymentMethod;
}
