package com.kevin.bmsclone.controller;

import com.kevin.bmsclone.model.dto.CityDTO;
import com.kevin.bmsclone.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/fetchCities")
    public List<CityDTO> fetchAllCities() {
        return adminService.fetchAllCities();
    }
}
