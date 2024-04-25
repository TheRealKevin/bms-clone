package com.kevin.bmsclone.service.impl;

import com.kevin.bmsclone.model.dto.TheatreDTO;
import com.kevin.bmsclone.model.entity.Theatre;
import com.kevin.bmsclone.repository.TheatreRepository;
import com.kevin.bmsclone.service.TheatreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public List<TheatreDTO> fetchAllTheatresInCity(int cityId) {
        List<Theatre> theatreList = theatreRepository.findAllByCityId(cityId);

        return theatreList.stream().map((theatre) -> {
            TheatreDTO theatreDTO = new TheatreDTO();
            BeanUtils.copyProperties(theatre, theatreDTO);
            return theatreDTO;
        }).collect(Collectors.toList());
    }
}
