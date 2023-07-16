package com.als.payment.service;

import com.als.payment.exceptions.PaymentExistsException;
import com.als.payment.exceptions.PaymentImpossibleException;
import com.als.payment.model.Payment;
import com.als.payment.repository.PaymentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class PaymentService {

    @Autowired
    private final PaymentRepository paymentRepository;

    public void payOrder(Payment payment) {
        Payment paymentExists = paymentRepository.findByIdPayment(payment.getOrderId());
        if (paymentExists != null ) throw  new PaymentExistsException("This order is already paid");

        Payment newPayment = paymentRepository.save(payment);
        if (newPayment == null) throw new PaymentImpossibleException("Error, Can not pay please try again!");

        // Will call microservice right here later on
        new ResponseEntity<Payment>(newPayment, HttpStatus.CREATED);
    }
}
