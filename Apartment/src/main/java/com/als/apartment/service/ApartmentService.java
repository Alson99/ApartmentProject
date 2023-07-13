package com.als.apartment.service;

import com.als.apartment.model.Apartment;
import com.als.apartment.repository.ApartmentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ApartmentService {

    @Autowired
    private final ApartmentRepository apartmentRepository;


    public List<Apartment> getApartments() {
        return apartmentRepository.findAll();
    }

    public Optional<Apartment> findApartment(Long id) {
        return apartmentRepository.findById(id);
    }

    public Apartment findApartmentByName(String name) {
        return apartmentRepository.findByName(name);
    }

    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

}
