package com.kevin.bmsclone.model.entity;

import com.kevin.bmsclone.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SHOW_SEAT")
@Data
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int showSeatId;

    @Column(name = "seat_row")
    private char seatRow;

    @Column(name = "seat_number")
    private int seatNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private SeatStatus seatStatus;

    private double price;

    @JoinColumn(name = "show_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Show show;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
