package com.kevin.bmsclone.controller;

import com.kevin.bmsclone.model.dto.ShowDTO;
import com.kevin.bmsclone.model.request.CreateShowRequest;
import com.kevin.bmsclone.model.response.ShowResponse;
import com.kevin.bmsclone.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/fetch/{cityId}")
    public List<ShowDTO> getAllShows(@PathVariable int cityId) {
        return showService.fetchAllShows(cityId);
    }

    @PostMapping("/create")
    public ShowResponse createShow(@RequestBody CreateShowRequest createShowRequest) {
        return showService.createShow(createShowRequest);
    }
}
