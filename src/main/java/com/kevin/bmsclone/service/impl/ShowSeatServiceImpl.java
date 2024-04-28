package com.kevin.bmsclone.service.impl;

import com.kevin.bmsclone.enums.SeatStatus;
import com.kevin.bmsclone.model.entity.Hall;
import com.kevin.bmsclone.model.entity.Show;
import com.kevin.bmsclone.model.entity.ShowSeat;
import com.kevin.bmsclone.repository.ShowSeatRepository;
import com.kevin.bmsclone.service.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Override
    public void createShowSeats(Hall hall, double price, Show show) {
        int totalRows = hall.getTotalRows();
        int totalSeats = hall.getTotalSeats();

        for (int row = 0; row < totalRows; row++) {
            for (int seat = 1; seat <= totalSeats; seat++) {
                ShowSeat showSeat = new ShowSeat();
                showSeat.setSeatRow((char)('A' + row));
                showSeat.setSeatNumber(seat);
                showSeat.setPrice(price);
                showSeat.setSeatStatus(SeatStatus.EMPTY);
                showSeat.setShow(show);

                showSeatRepository.save(showSeat);
            }
        }

    }

}
