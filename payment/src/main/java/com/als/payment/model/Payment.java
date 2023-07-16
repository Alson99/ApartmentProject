package com.als.payment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Payment {

    @Id
    private Long id;
    @Column(unique = true)
    private Long OrderId;
    private Integer price;
    private Long cardNumber;
}
