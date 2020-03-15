package com.planning.licenta.service;

import com.planning.licenta.entities.Admin;
import com.planning.licenta.model.AdminDTO;

import java.util.List;

public interface AdminService {

    Admin save(AdminDTO admin);
    List<Admin> findAll();
    void delete(int id);

    // List<Admin> findByCaregiver_idCaregiver(Caregiver caregiver_idCaregiver);
//    Admin findOne(String firstname);

    Admin findById(int id);

    AdminDTO update(AdminDTO adminDto);

//    Admin findByIdPatient(String idPatient);
}
