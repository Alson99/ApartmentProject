package com.als.payment.controller;

import com.als.payment.model.Payment;
import com.als.payment.service.PaymentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping
public class PaymentController {

    @Autowired
    private final PaymentService paymentService;

    @PostMapping(path = "/payment")
    public void orderPaid(@RequestBody Payment payment) {
        paymentService.payOrder(payment);
    }
}
