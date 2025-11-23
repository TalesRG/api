package com.example.api.application.payments;

import com.example.api.dto.payments.CreatePaymentResponseDto;
import com.example.api.dto.payments.CreatePaymentsDto;
import com.example.api.entity.PaymentEntity;
import com.example.api.repository.PaymentRepository;
import com.example.api.service.payments.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplementation implements PaymentsService {

    PaymentRepository paymentRepository;

    @Autowired
    PaymentServiceImplementation(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public CreatePaymentResponseDto createPayment(CreatePaymentsDto payment) {
        try {
            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setName(payment.getName());
            paymentEntity.setTotalValue(payment.getTotalValue());
            paymentEntity.setStatus(payment.getStatus());
            paymentEntity.setCategory(payment.getCategory());
            paymentEntity.setPaymentMethod(payment.getPaymentMethod());
            PaymentEntity saved = paymentRepository.save(paymentEntity);

            return  CreatePaymentResponseDto.builder()
                    .id(saved.getId())
                    .name(saved.getName())
                    .status(saved.getStatus())
                    .category(saved.getCategory())
                    .paymentMethod(saved.getPaymentMethod())
                    .totalValue(saved.getTotalValue()).build();
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar pagamento", e);
        }
    }
}
