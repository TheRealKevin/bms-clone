package com.kevin.bmsclone.model.dto;

import com.kevin.bmsclone.model.entity.Theatre;
import lombok.Data;

import java.util.List;

@Data
public class CityDTO {

    private int cityId;

    private String name;

    private List<Theatre> theatreList;
}
