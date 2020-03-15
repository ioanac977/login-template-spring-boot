package com.planning.licenta.dao;

import com.planning.licenta.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {

//    Caregiver findByFirstName(String firstName);

}