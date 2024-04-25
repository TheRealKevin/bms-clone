package com.kevin.bmsclone.service;

import com.kevin.bmsclone.model.dto.TheatreDTO;

import java.util.List;

public interface TheatreService {

    List<TheatreDTO> fetchAllTheatresInCity(int cityId);
}
