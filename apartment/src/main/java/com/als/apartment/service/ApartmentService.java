package com.als.apartment.service;

import com.als.apartment.model.Apartment;
import com.als.apartment.repository.ApartmentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Data
public class ApartmentService {

    @Autowired
    private final ApartmentRepository apartmentRepository;


    public List<Apartment> getApartments() {
        return apartmentRepository.findAll();
    }

    public Optional<Apartment> getOneApartment(Long id) {
        return apartmentRepository.findById(id);
    }

    public void addApartment(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

   public void deleteApartment(Long id) {
        boolean exists = apartmentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Apartment with " + id + "does not exist");
        }
        apartmentRepository.deleteById(id);

   }

   public Apartment findApartmentByName(String name) {
         return apartmentRepository.findByName(name);
   }

   @Transactional
   public void updateApartment(Long id,
                               String name,
                               String address,
                               String city,
                               String country,
                               String postalCode,
                               Integer numberRoom) {
        Apartment apartment = apartmentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Apartment with"+ id +"does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(apartment.getName(), name)) {
            apartment.setName(name);
        }

        if (address != null && address.length() > 0 && !Objects.equals(apartment.getAddress(), address)){
            apartment.setAddress(address);
        }
       if (city != null && city.length() > 0 && !Objects.equals(apartment.getCity(), city)){
           apartment.setCity(city);
       }
       if (country != null && country.length() > 0 && !Objects.equals(apartment.getCountry(), country)){
           apartment.setCountry(country);
       }
       if (postalCode != null && postalCode.length() > 0 && !Objects.equals(apartment.getPostalCode(), postalCode)){
           apartment.setPostalCode(postalCode);
       }
       if (numberRoom != null && numberRoom > 0 && !Objects.equals(apartment.getRoomNumber(), numberRoom)){
           apartment.setRoomNumber(numberRoom);
       }

   }


}
