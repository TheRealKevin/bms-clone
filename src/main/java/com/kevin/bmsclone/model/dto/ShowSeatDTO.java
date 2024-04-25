package com.kevin.bmsclone.model.dto;

import com.kevin.bmsclone.model.entity.Show;
import lombok.Data;

@Data
public class ShowSeatDTO {

    private int showSeatId;

    private boolean reserved;

    private double price;

    private Show show;
}
