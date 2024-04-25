package com.kevin.bmsclone.repository;

import com.kevin.bmsclone.model.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    @Query(value = "SELECT * FROM THEATRE WHERE city_id = ?1", nativeQuery = true)
    List<Theatre> findAllByCityId(int cityId);
}
