package com.planning.licenta.controller;

import com.planning.licenta.entities.User;
import com.planning.licenta.model.UserDTO;
import com.planning.licenta.response.ApiResponse;
import com.planning.licenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ApiResponse<User> saveUser(@RequestBody UserDTO user){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @GetMapping
    public ApiResponse<List<User>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @GetMapping("/{idPatient}")
    public ApiResponse<List<User>> getOneByPatientIdU(@PathVariable String idPatient  ){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findByIdPatient(idPatient));
    }

    @GetMapping("/{username}/{password}")
    public ApiResponse<User> getOneByUsername(@PathVariable String username ,@PathVariable String password){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findByUsername(username,password));
    }


    @PutMapping("/{id}")
    public ApiResponse<UserDTO> update(@RequestBody UserDTO userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
