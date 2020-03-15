package com.planning.licenta.dao;

import com.planning.licenta.entities.Admin;
import com.planning.licenta.entities.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserDAO extends JpaRepository<RegisteredUser, Integer> {

//    Caregiver findByFirstName(String firstName);

}