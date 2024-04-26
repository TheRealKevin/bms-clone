package com.kevin.bmsclone.service.impl;

import com.kevin.bmsclone.mapper.EntityToDtoMapper;
import com.kevin.bmsclone.model.dto.CityDTO;
import com.kevin.bmsclone.model.entity.City;
import com.kevin.bmsclone.repository.CityRepository;
import com.kevin.bmsclone.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private EntityToDtoMapper mapper;

    @Override
    public List<CityDTO> fetchAllCities() {
        List<City> cityList = cityRepository.findAll();

        return cityList.stream().map(city -> {
            CityDTO cityDTO = mapper.convertToDto(city);
            return cityDTO;
        }).collect(Collectors.toList());
    }
}
