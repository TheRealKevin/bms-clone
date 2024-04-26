package com.kevin.bmsclone.model.dto;

import com.kevin.bmsclone.model.entity.Theatre;
import lombok.Data;

import java.util.List;

@Data
public class HallDTO {

    private int hallId;

    private List<ShowDTO> showList;

}
