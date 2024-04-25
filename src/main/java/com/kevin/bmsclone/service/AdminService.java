package com.kevin.bmsclone.service;

import com.kevin.bmsclone.model.dto.CityDTO;

import java.util.List;

public interface AdminService {

    List<CityDTO> fetchAllCities();
}
