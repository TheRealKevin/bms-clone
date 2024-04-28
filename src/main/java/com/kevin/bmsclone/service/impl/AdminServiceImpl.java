package com.kevin.bmsclone.service.impl;

import com.kevin.bmsclone.mapper.DtoMapper;
import com.kevin.bmsclone.model.dto.CityDTO;
import com.kevin.bmsclone.model.entity.City;
import com.kevin.bmsclone.repository.CityRepository;
import com.kevin.bmsclone.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DtoMapper mapper;

    @Override
    public List<CityDTO> fetchAllCities() {
        List<City> cityList = cityRepository.findAll();

        return cityList.stream().map(city -> {
            CityDTO cityDTO = mapper.convertToDto(city);
            return cityDTO;
        }).collect(Collectors.toList());
    }
}
