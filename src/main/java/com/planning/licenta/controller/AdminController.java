package com.planning.licenta.controller;

import com.planning.licenta.entities.Admin;
import com.planning.licenta.model.AdminDTO;
import com.planning.licenta.response.ApiResponse;
import com.planning.licenta.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PostMapping
    public ApiResponse<Admin> saveAdmin(@RequestBody AdminDTO admin){
        return new ApiResponse<>(HttpStatus.OK.value(), "Admin saved successfully.",adminService.save(admin));
    }

    @GetMapping
    public ApiResponse<List<Admin>> listAdmin(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Admin list fetched successfully.",adminService.findAll());
    }

    @PutMapping("/{id}")
    public ApiResponse<AdminDTO> update(@RequestBody AdminDTO adminDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Admin updated successfully.",adminService.update(adminDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        adminService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Admin deleted successfully.", null);
    }



}
