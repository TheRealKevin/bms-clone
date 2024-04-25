package com.kevin.bmsclone.model.entity;

import com.kevin.bmsclone.enums.Genre;
import com.kevin.bmsclone.enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.sql.Date;

@Data
@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieId;

    private String title;

    private int duration;

    private Genre genre;

    private Date releaseData;

    private Language language;

    @OneToMany(mappedBy = "movie")
    private List<Show> showList;
}
