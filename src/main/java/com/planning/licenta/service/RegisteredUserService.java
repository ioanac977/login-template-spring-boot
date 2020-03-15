package com.planning.licenta.service;

import com.planning.licenta.entities.RegisteredUser;
import com.planning.licenta.model.RegisteredUserDTO;

import java.util.List;

public interface RegisteredUserService {
    RegisteredUser save(RegisteredUserDTO registeredUser);
    List<RegisteredUser> findAll();
    void delete(int id);

    // List<RegisteredUser> findByCaregiver_idCaregiver(Caregiver caregiver_idCaregiver);
//    RegisteredUser findOne(String firstname);

    RegisteredUser findById(int id);

    RegisteredUser findByRegisteredUsername(String registeredUsername,String password);

    RegisteredUserDTO update(RegisteredUserDTO registeredUserDto);

    RegisteredUser findByIdPatient(String idPatient);
}
