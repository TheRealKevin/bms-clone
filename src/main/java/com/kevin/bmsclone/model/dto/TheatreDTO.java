package com.kevin.bmsclone.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class TheatreDTO {

    private int theatreId;

    private List<HallDTO> hallsList;
}
