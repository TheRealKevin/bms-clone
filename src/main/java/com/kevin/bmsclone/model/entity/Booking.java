package com.kevin.bmsclone.model.entity;

import com.kevin.bmsclone.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "BOOKING")
@Data
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "booking_date")
    private Date bookingDate;

    // TODO : Does BOOKING need to know about the show seats or can we fetch those from application?
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ShowSeat> showSeatList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
