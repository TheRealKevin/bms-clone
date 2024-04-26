package com.kevin.bmsclone.repository;

import com.kevin.bmsclone.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
