package com.kevin.bmsclone.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "THEATRE")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreId;

    @JoinColumn(name = "city_id")
    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "theatre")
    private List<Hall> hallsList;
}
