package com.kevin.bmsclone.repository;

import com.kevin.bmsclone.model.entity.Show;
import com.kevin.bmsclone.model.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    List<ShowSeat> findByShow(Show show);

}
