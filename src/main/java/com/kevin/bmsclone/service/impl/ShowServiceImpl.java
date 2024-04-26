package com.kevin.bmsclone.service.impl;

import com.kevin.bmsclone.model.dto.HallDTO;
import com.kevin.bmsclone.model.dto.MovieDTO;
import com.kevin.bmsclone.model.dto.ShowDTO;
import com.kevin.bmsclone.model.dto.TheatreDTO;
import com.kevin.bmsclone.model.entity.Show;
import com.kevin.bmsclone.model.entity.Theatre;
import com.kevin.bmsclone.repository.MovieRepository;
import com.kevin.bmsclone.repository.ShowRepository;
import com.kevin.bmsclone.repository.TheatreRepository;
import com.kevin.bmsclone.service.ShowService;
import com.kevin.bmsclone.service.TheatreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreService theatreService;

    @Override
    public Set<ShowDTO> fetchAllShows(int cityId) {
        List<TheatreDTO> theatreList = theatreService.fetchAllTheatresInCity(cityId);

        Set<ShowDTO> showSet = new HashSet<>();

        for (TheatreDTO theatreDTO : theatreList) {
            List<HallDTO> hallList = theatreDTO.getHallsList();

            for (HallDTO hallDTO : hallList) {
                showSet.addAll(hallDTO.getShowList());
            }
        }

        return showSet;
    }
}
