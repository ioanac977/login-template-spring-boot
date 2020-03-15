package com.planning.licenta.service;

import com.planning.licenta.entities.User;
import com.planning.licenta.model.UserDTO;

import java.util.List;

public interface UserService {

    User save(UserDTO user);
    List<User> findAll();
    void delete(int id);

    // List<User> findByCaregiver_idCaregiver(Caregiver caregiver_idCaregiver);
//    User findOne(String firstname);

    User findById(int id);

    User findByUsername(String username,String password);

    UserDTO update(UserDTO userDto);

    User findByIdPatient(String idPatient);
}
