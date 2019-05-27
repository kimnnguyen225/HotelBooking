package com.herokuapp.hotelbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/listOfHotels")
public class HotelBookingController {
    private HotelBookingRepository hotelBookingRepository;

    @Autowired
    public HotelBookingController(HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAllHotels() {
        return hotelBookingRepository.findAll();
    }

    @RequestMapping(value = "/byPrice/{price}", method = RequestMethod.GET)
    // @PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable
    // With the @PathVariable annotation, we bind the request URL template path variable to the method variable
    // http://zetcode.com/springboot/pathvariable/
    public List<HotelBooking> hotelListByPrice(@PathVariable double price) {
        // stream, the task is to convert this stream to ArrayList in Java8
        // Collect the stream as List using collect() and Collectors.toList() methods
        // https://www.geeksforgeeks.org/how-to-get-arraylist-from-stream-in-java-8/

        //lambda arrow operator ->
        // https://dzone.com/articles/java-8-lambda-functions-usage-examples

        // if x is less than or equal to pathvariable price (given by user)
        // then collect all the results
        // return hotelBookingsArrList.stream().filter(x -> x.getPricePerNight() <= price).collect
        // (Collectors.toList());
        return hotelBookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/addHotel", method = RequestMethod.POST)
    public List<HotelBooking> addHotel(@RequestBody HotelBooking hotelBooking) {
        //PostMan - make sure to have default constructor
        hotelBookingRepository.save(hotelBooking);
        return hotelBookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<HotelBooking> deleteHotel(@PathVariable long id) {
        hotelBookingRepository.deleteById(id);
        return hotelBookingRepository.findAll();
    }
}
