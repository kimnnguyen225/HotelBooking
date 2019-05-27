package com.herokuapp.hotelbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    // after the app starts up, after all the  bins and app context are created
    // all the classes that implements CommandLineRunner are executed

    private List<HotelBooking> hotelBookingsArrList;
    private HotelBookingRepository hotelBookingRepository;

    @Autowired
    public DatabaseSeeder(HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
    }

    @Override
    public void run(String... args) {
        hotelBookingsArrList = new ArrayList<>();
        hotelBookingsArrList.add(new HotelBooking("Marriot", 200.50, 3));
        hotelBookingsArrList.add(new HotelBooking("RedRoof", 110.99, 5));
        hotelBookingsArrList.add(new HotelBooking("Holiday Inn", 121, 2));
    }
}
