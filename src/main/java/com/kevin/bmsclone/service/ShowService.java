package com.kevin.bmsclone.service;

import com.kevin.bmsclone.model.dto.ShowDTO;
import com.kevin.bmsclone.model.request.CreateShowRequest;
import com.kevin.bmsclone.model.response.ShowResponse;

import java.util.List;

public interface ShowService {

    List<ShowDTO> fetchAllShows(int cityId);

    ShowResponse createShow(CreateShowRequest createShowRequest);

}
