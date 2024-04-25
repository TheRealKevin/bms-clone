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
    private int hallId;

    @OneToMany(mappedBy = "hall")
    private List<Show> showList;

    @JoinColumn(name = "theatre_id")
    @ManyToOne
    private Theatre theatre;

}
