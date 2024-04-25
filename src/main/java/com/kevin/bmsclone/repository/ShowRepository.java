package com.kevin.bmsclone.repository;

import com.kevin.bmsclone.model.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {

}
