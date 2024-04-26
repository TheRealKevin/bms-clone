package com.kevin.bmsclone.model.dto;

import com.kevin.bmsclone.model.entity.Hall;
import com.kevin.bmsclone.model.entity.Movie;
import com.kevin.bmsclone.model.entity.ShowSeat;
import com.kevin.bmsclone.model.entity.Theatre;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
public class ShowDTO {

    private int showId;

    private Date showDate;

    private Time showTime;

    private List<ShowSeatDTO> showSeatList;
}
