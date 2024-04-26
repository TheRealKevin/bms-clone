package com.kevin.bmsclone.service.impl;

import com.kevin.bmsclone.mapper.EntityToDtoMapper;
import com.kevin.bmsclone.model.dto.MovieDTO;
import com.kevin.bmsclone.model.entity.Movie;
import com.kevin.bmsclone.repository.MovieRepository;
import com.kevin.bmsclone.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private EntityToDtoMapper mapper;

    @Override
    public List<MovieDTO> fetchAllMovies() {
        List<Movie> movieList = movieRepository.findAll();

        return movieList.stream().map(movie -> {
            MovieDTO movieDTO = mapper.convertToDto(movie);
            return movieDTO;
        }).collect(Collectors.toList());
    }

}
