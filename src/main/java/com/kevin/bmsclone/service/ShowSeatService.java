package com.kevin.bmsclone.service;

import com.kevin.bmsclone.model.entity.Hall;
import com.kevin.bmsclone.model.entity.Show;

public interface ShowSeatService {

    void createShowSeats(Hall hall, double price, Show show);

}
