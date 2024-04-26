package com.kevin.bmsclone.model.dto;

import com.kevin.bmsclone.enums.Genre;
import com.kevin.bmsclone.enums.Language;
import com.kevin.bmsclone.model.entity.Show;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class MovieDTO {

    private long movieId;

    private String title;

    private int duration;

    private Genre genre;

    private Date releaseDate;

    private Language language;

    private List<ShowDTO> showList;

}
