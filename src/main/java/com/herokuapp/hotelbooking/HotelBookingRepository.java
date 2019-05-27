package com.herokuapp.hotelbooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //initialize database
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {
    // https://docs.spring.io/spring-data/jpa/docs/2.1.8.RELEASE/reference/html/#repositories
    // refer to this docs for LessThan method
    // don't have to write implementation for the findBy-LessThan, just need to define it in a
    // blocking repository interface, the rest will be taken care of by framework
    List<HotelBooking> findByPricePerNightLessThan(double price);
}
