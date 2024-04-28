package com.kevin.bmsclone.service.impl;

import com.kevin.bmsclone.enums.ResponseCode;
import com.kevin.bmsclone.exception.ShowException;
import com.kevin.bmsclone.mapper.ResponseMapper;
import com.kevin.bmsclone.model.dto.HallDTO;
import com.kevin.bmsclone.model.dto.ShowDTO;
import com.kevin.bmsclone.model.dto.TheatreDTO;
import com.kevin.bmsclone.model.entity.*;
import com.kevin.bmsclone.model.request.CreateShowRequest;
import com.kevin.bmsclone.model.response.ShowResponse;
import com.kevin.bmsclone.repository.HallRepository;
import com.kevin.bmsclone.repository.MovieRepository;
import com.kevin.bmsclone.repository.ShowRepository;
import com.kevin.bmsclone.service.ShowSeatService;
import com.kevin.bmsclone.service.ShowService;
import com.kevin.bmsclone.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatService showSeatService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private ResponseMapper responseMapper;

    @Override
    public List<ShowDTO> fetchAllShows(int cityId) {
        List<TheatreDTO> theatreList = theatreService.fetchAllTheatresInCity(cityId);

        List<ShowDTO> showList = new ArrayList<>();
        // TODO : Fix this!!
        for (TheatreDTO theatreDTO : theatreList) {
            List<HallDTO> hallList = theatreDTO.getHallsList();

        }

        return showList;
    }

    @Override
    public ShowResponse createShow(CreateShowRequest createShowRequest) {

        try {
            Optional<Movie> optionalMovie = movieRepository.findById(createShowRequest.getMovieId());

            if (optionalMovie.isEmpty()) {
                throw new ShowException(ResponseCode.NO_SHOW_AVAILABLE);
            }

            Optional<Hall> optionalHall = hallRepository.findById(createShowRequest.getHallId());

            if (optionalHall.isEmpty()) {
                throw new ShowException(ResponseCode.INTERNAL_SERVER_ERROR);
            }

            Show show = new Show();
            show.setShowDate(createShowRequest.getShowDate());
            show.setShowTime(createShowRequest.getShowTime());
            show.setHall(optionalHall.get());
            show.setMovie(optionalMovie.get());

            Show persistedShow = showRepository.save(show);

            // Creates show seats for this particular show
            showSeatService.createShowSeats(optionalHall.get(), createShowRequest.getSeatPrice(), persistedShow);

            return responseMapper.mapShowResponse(persistedShow.getShowId(), ResponseCode.SUCCESS);

        } catch (ShowException ex) {
            return responseMapper.mapCreateShowResponse(ResponseCode.MOVIE_NOT_PLAYING);
        }

    }
}
