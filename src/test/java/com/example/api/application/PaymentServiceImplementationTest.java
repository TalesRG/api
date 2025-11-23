package com.example.api.application;

import com.example.api.application.payments.PaymentServiceImplementation;
import com.example.api.dto.payments.CreatePaymentResponseDto;
import com.example.api.dto.payments.CreatePaymentsDto;
import com.example.api.entity.PaymentEntity;
import com.example.api.repository.PaymentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplementationTest {
    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImplementation paymentService;

    @Test
    public void shouldCreatePayment(){
        CreatePaymentsDto responseDto = new CreatePaymentsDto();
        responseDto.setName("teste");
        responseDto.setTotalValue(new java.math.BigDecimal("100"));
        responseDto.setPaymentMethod("BOLETO");
        responseDto.setStatus("PENDING");
        responseDto.setCategory("ELECTRICITY");

        PaymentEntity savedEntity = new PaymentEntity();
        savedEntity.setId("123");
        savedEntity.setName(responseDto.getName());
        savedEntity.setTotalValue(responseDto.getTotalValue());
        savedEntity.setStatus(responseDto.getStatus());
        savedEntity.setCategory(responseDto.getCategory());
        savedEntity.setPaymentMethod(responseDto.getPaymentMethod());

        when(paymentRepository.save(any(PaymentEntity.class))).thenReturn(savedEntity);

        CreatePaymentResponseDto createPaymentResponseDto = paymentService.createPayment(responseDto);

        ArgumentCaptor<PaymentEntity> captor = ArgumentCaptor.forClass(PaymentEntity.class);
        verify(paymentRepository,times(1)).save(captor.capture());

        PaymentEntity entitySent = captor.getValue();
        Assertions.assertThat(entitySent.getName()).isEqualTo("teste");
        Assertions.assertThat(createPaymentResponseDto.getId()).isEqualTo("123");

    }
}
