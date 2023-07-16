package com.als.order.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;


@Data
@Table(name = "t_order")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ApartmentId;

    private Date dataOrder;

    private Integer quantitee;

    private Boolean OrderPayed;

}
