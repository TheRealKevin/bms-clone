package com.kevin.bmsclone.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "SHOWS")
@Data
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int showId;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "show_id")
//    private Movie movie;

    @Column(name = "show_date")
    private Date showDate;

    @Column(name = "show_time")
    private Time showTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "show_id")
    private List<ShowSeat> showSeatList;
}
