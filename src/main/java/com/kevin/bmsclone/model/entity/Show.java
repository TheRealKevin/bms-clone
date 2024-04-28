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

    // TODO : Does SHOWS need to know about MOVIE it's playing or can we process that thru application
    @ManyToOne(cascade = CascadeType.ALL)
    private Movie movie;

    @Column(name = "show_date")
    private Date showDate;

    @Column(name = "show_time")
    private Time showTime;

    // TODO : Does SHOWS need to know about the HALL it's playing in? IMO YESS
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    // TODO : Does SHOWS need to know about the SHOW_SEAT it has or or can we process that thru application?
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ShowSeat> showSeatList;


    // TODO : Does SHOWS need to know about the BOOKING it has or or can we process that thru application?
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "show_id")
//    private List<Booking> bookingList;
}
