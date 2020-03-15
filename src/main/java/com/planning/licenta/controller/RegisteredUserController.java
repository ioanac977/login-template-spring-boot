package com.planning.licenta.controller;

import com.planning.licenta.entities.RegisteredUser;
import com.planning.licenta.model.RegisteredUserDTO;
import com.planning.licenta.response.ApiResponse;
import com.planning.licenta.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/registeredUser")
public class RegisteredUserController {

    @Autowired
    private RegisteredUserService registeredUserService;
    @PostMapping
    public ApiResponse<RegisteredUser> saveRegisteredUser(@RequestBody RegisteredUserDTO registeredUser){
        return new ApiResponse<>(HttpStatus.OK.value(), "RegisteredUser saved successfully.",registeredUserService.save(registeredUser));
    }

    @GetMapping
    public ApiResponse<List<RegisteredUser>> listRegisteredUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "RegisteredUser list fetched successfully.",registeredUserService.findAll());
    }

    @PutMapping("/{id}")
    public ApiResponse<RegisteredUserDTO> update(@RequestBody RegisteredUserDTO registeredUserDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "RegisteredUser updated successfully.",registeredUserService.update(registeredUserDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        registeredUserService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "RegisteredUser deleted successfully.", null);
    }



}
