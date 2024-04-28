package com.kevin.bmsclone.model.entity;

import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(name = "contact_number")
    private String contactNumber;

    // TODO : Does USER Table need to know it's booking or can we fetch that from BOOKING table via Application?
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Booking> bookingList;
}
