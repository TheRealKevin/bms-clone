package com.kevin.bmsclone.controller;

import com.kevin.bmsclone.model.dto.BookingDTO;
import com.kevin.bmsclone.model.dto.CityDTO;
import com.kevin.bmsclone.model.dto.MovieDTO;
import com.kevin.bmsclone.model.dto.UserDTO;
import com.kevin.bmsclone.service.BookingService;
import com.kevin.bmsclone.service.AdminService;
import com.kevin.bmsclone.service.MovieService;
import com.kevin.bmsclone.service.ShowService;
import com.kevin.bmsclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ShowService showService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/fetch/city")
    public List<CityDTO> fetchAllCities() {
        return adminService.fetchAllCities();
    }

    @GetMapping("/fetch/movie")
    public List<MovieDTO> fetchAllMovies() {
        return movieService.fetchAllMovies();
    }

    @GetMapping("/fetch/user")
    public List<UserDTO> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/fetch/booking")
    public List<BookingDTO> fetchAllBookings() {
        return bookingService.fetchAllBookings();
    }
}
