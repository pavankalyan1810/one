package org.TableBookingSystem.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private String username;
    private String email;
    private LocalDate date;
    private LocalTime time;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<BookingCuisine> bookedCuisines = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "tableId")
    private Table table;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public List<BookingCuisine> getBookedCuisines() {
		return bookedCuisines;
	}

	public void setBookedCuisines(List<BookingCuisine> bookedCuisines) {
		this.bookedCuisines = bookedCuisines;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Booking(Long bookingId, String username, String email, LocalDate date, LocalTime time,
			List<BookingCuisine> bookedCuisines, Table table) {
		super();
		this.bookingId = bookingId;
		this.username = username;
		this.email = email;
		this.date = date;
		this.time = time;
		this.bookedCuisines = bookedCuisines;
		this.table = table;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructors, getters, and setters...
}