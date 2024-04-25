package com.kevin.bmsclone.controller;

import com.kevin.bmsclone.model.dto.ShowDTO;
import com.kevin.bmsclone.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/fetchShows/{cityId}")
    Set<ShowDTO> getAllShows(@PathVariable int cityId) {
        return showService.fetchAllShows(cityId);
    }
}
