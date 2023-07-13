package com.als.apartment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "t_apartment")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adress;
    private String city;
    private String postalCode;
    private String country;
    private Integer roomNumber;
    private Boolean SwimmingPool;

}
