package com.kevin.bmsclone.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class HallDTO {

    private int hallId;

    private int totalRows;

    private int totalSeats;

    private int seatingCapacity;

//    private List<ShowDTO> showList;

}
