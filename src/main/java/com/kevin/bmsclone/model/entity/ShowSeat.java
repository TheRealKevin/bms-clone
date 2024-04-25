package com.kevin.bmsclone.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SHOW_SEAT")
@Data
public class ShowSeat extends Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showSeatId;

    private boolean reserved;

    private double price;

    @JoinColumn(name = "show_id")
    @ManyToOne
    private Show show;
}
