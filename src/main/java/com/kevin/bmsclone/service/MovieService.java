package com.kevin.bmsclone.service;

import com.kevin.bmsclone.model.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> fetchAllMovies();
}
