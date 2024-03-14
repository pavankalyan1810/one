package org.TableBookingSystem.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.TableBookingSystem.Repository.BookingRepository;
import org.TableBookingSystem.Repository.CuisineRepository;
import org.TableBookingSystem.Repository.TableRepository;
import org.TableBookingSystem.model.Booking;
import org.TableBookingSystem.model.BookingCuisine;
import org.TableBookingSystem.model.Cuisine;
import org.TableBookingSystem.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private CuisineRepository cuisineRepository; // Autowire the CuisineRepository
    
    public String bookTable(Long tableId, List<Long> cuisineIds, LocalDate date, LocalTime time) {
        Optional<Table> optionalTable = tableRepository.findById(tableId);
        
        if (optionalTable.isPresent()) {
            Table table = optionalTable.get();
            
            if (table.isBooked()) {
                return "Table is already booked";
            } 
            
            Booking booking = new Booking();
            booking.setTable(table);
            booking.setDate(date);
            booking.setTime(time);
            
            for (Long cuisineId : cuisineIds) {
                Optional<Cuisine> optionalCuisine = cuisineRepository.findById(cuisineId);
                if (optionalCuisine.isPresent()) {
                    Cuisine cuisine = optionalCuisine.get();
                    BookingCuisine bookingCuisine = new BookingCuisine();
                    bookingCuisine.setCuisine(cuisine);
                    bookingCuisine.setBooking(booking);
                    booking.getBookedCuisines().add(bookingCuisine);
                } else {
                    return "Cuisine with ID " + cuisineId + " not found";
                }
            }
            
            bookingRepository.save(booking);
            table.setBooked(true);
            tableRepository.save(table);
            
            return "success";
        } else {
            return "Table not found";
        }
    }
}