package com.kevin.bmsclone.model.entity;

import com.kevin.bmsclone.enums.Genre;
import com.kevin.bmsclone.enums.Language;
import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

import java.sql.Date;

@Data
@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long movieId;

    private String title;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(name = "release_date")
    private Date releaseDate;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movie_id")
    private List<Show> showList;
}
