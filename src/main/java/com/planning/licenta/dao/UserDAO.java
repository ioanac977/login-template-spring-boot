package com.planning.licenta.dao;

import com.planning.licenta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
//    public  User findByIdPatient(String idPatient);



}