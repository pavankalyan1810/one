package org.TableBookingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BookingCuisine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Booking booking;
    
    @ManyToOne
    private Cuisine cuisine;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public BookingCuisine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingCuisine(Long id, Booking booking, Cuisine cuisine) {
		super();
		this.id = id;
		this.booking = booking;
		this.cuisine = cuisine;
	}
    
    
}
