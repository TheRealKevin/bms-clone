package com.kevin.bmsclone.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "SHOW")
@Data
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private Date showDate;

    private Time showTime;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeatList;
}
