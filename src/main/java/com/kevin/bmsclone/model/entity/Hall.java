package com.kevin.bmsclone.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "HALL")
@Data
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int hallId;

    @Column(name = "total_rows")
    private int totalRows;

    @Column(name = "total_seats")
    private int totalSeats;

    @Column(name = "seating_capacity")
    private int seatingCapacity;

    // TODO : Does HALL need to know about the SHOW it's playing in from DB?
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Show> showList;
}
