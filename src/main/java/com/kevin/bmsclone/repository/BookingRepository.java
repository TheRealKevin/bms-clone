package com.kevin.bmsclone.repository;

import com.kevin.bmsclone.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
