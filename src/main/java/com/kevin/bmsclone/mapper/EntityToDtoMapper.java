package com.kevin.bmsclone.mapper;

import com.kevin.bmsclone.model.dto.CityDTO;
import com.kevin.bmsclone.model.dto.MovieDTO;
import com.kevin.bmsclone.model.entity.City;
import com.kevin.bmsclone.model.entity.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityToDtoMapper {

    @Autowired
    private ModelMapper mapper;

    public CityDTO convertToDto(City city) {
        CityDTO cityDTO = mapper.map(city, CityDTO.class);
        return cityDTO;
    }

    public MovieDTO convertToDto(Movie movie) {
        MovieDTO movieDTO = mapper.map(movie, MovieDTO.class);
        return movieDTO;
    }
}
