package com.als.apartment.controller;

import com.als.apartment.model.Apartment;
import com.als.apartment.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/apartments")
public class ApartmentController {

    @Autowired
    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping(path = "/apartments/allApartments")
    public List<Apartment> getAllApartments() {
        return apartmentService.getApartments();
    }

    @PostMapping
    public void registerApartment(@RequestBody Apartment apartment) {
        apartmentService.addApartment(apartment);
    }

    @DeleteMapping(path = "/apartments/{id}")
    public void deleteApartment(@PathVariable("id") Long id) {
        apartmentService.deleteApartment(id);
    }

    @PutMapping(path = "apartments/{id}")
    public void updateApartment(@PathVariable("id") Long id,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String address,
                                @RequestParam(required = false) String city,
                                @RequestParam(required = false) String country,
                                @RequestParam(required = false) String postalCode,
                                @RequestParam(required = false) Integer numberRoom) {
        apartmentService.updateApartment(id, name, address, city, country, postalCode, numberRoom);
    }

    @GetMapping(path = "/apartments/name")
    public Apartment getApartmentByName(@RequestBody String name) {
        return apartmentService.findApartmentByName(name);
    }

}
