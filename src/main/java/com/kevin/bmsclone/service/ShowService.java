package com.kevin.bmsclone.service;

import com.kevin.bmsclone.model.dto.ShowDTO;
import com.kevin.bmsclone.model.entity.City;

import java.util.List;
import java.util.Set;

public interface ShowService {

    Set<ShowDTO> fetchAllShows(int cityId);
}
