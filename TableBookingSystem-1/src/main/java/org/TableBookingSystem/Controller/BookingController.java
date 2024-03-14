package org.TableBookingSystem.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.TableBookingSystem.Service.BookingService;
import org.TableBookingSystem.model.BookingRequest;
import org.TableBookingSystem.model.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTable(@RequestBody BookingRequest bookingRequest) {
        // Convert date and time strings to LocalDate and LocalTime
        LocalDate bookingDate = LocalDate.parse(bookingRequest.getDate());
        LocalTime bookingTime = LocalTime.parse(bookingRequest.getTime());

        // Call the booking service method
        String result = bookingService.bookTable(bookingRequest.getTableId(), bookingRequest.getCuisineIds(),
                bookingDate, bookingTime);

        // Return appropriate response based on the result
        if ("success".equals(result)) {
            return ResponseEntity.ok("Table successfully booked");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}