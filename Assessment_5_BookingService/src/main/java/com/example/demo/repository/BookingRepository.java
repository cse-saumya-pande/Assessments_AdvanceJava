package com.example.demo.repository;

import com.example.demo.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookingRepository {

    private final Map<Long, Booking> bookingStore = new HashMap<>();
    private long idCounter = 101;

    public Booking save(Booking booking) {
        booking.setBookingId(idCounter);
        bookingStore.put(idCounter, booking);
        idCounter++;
        return booking;
    }

    public List<Booking> findAll() {
        return new ArrayList<>(bookingStore.values());
    }
}