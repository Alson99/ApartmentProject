package com.als.administration.service;

import com.als.administration.exception.AdminException;
import com.als.administration.model.Admin;
import com.als.administration.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLEngineResult;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdmin {

    @Autowired
    private AdminRepository adminRepository;

    ResponseEntity<Admin> getAdmin() {
        Admin admin = new Admin();
        admin.setId(admin.getId());
        admin.setName(admin.getName());
        admin.setCode(admin.getCode());
        return new ResponseEntity<>(admin, HttpStatusCode.valueOf(200));
    }

    ResponseEntity <?> getAdminById(Long id) throws AdminException {
        Optional<Admin> admin = adminRepository.findById(id);
        if (!admin.isPresent()) {
            throw new AdminException("Not found this Admin !");
        }
        return new ResponseEntity<>(admin, HttpStatusCode.valueOf(200));
    }
}
