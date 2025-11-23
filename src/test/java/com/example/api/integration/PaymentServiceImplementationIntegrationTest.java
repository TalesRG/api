package com.example.api.integration;

import com.example.api.dto.payments.CreatePaymentsDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PaymentServiceImplementationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deve criar um pagamento com sucesso (201) usando H2")
    void shouldCreatePaymentWithSuccess() throws Exception {
        CreatePaymentsDto dto = new CreatePaymentsDto();
        dto.setName("Conta de Luz");
        dto.setTotalValue(BigDecimal.valueOf(199.90));
        dto.setStatus("PENDING");
        dto.setCategory("ELECTRICITY");
        dto.setPaymentMethod("CREDIT_CARD");

        String json = objectMapper.writeValueAsString(dto);

        mockMvc.perform(
                        post("/payments/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Conta de Luz"))
                .andExpect(jsonPath("$.totalValue").value(199.90));
    }
}
