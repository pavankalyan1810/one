package org.TableBookingSystem.model;

import java.util.List;

public class BookingRequest {
    private Long tableId;
    private List<Long> cuisineIds;
    private String date;
    private String time;
	public Long getTableId() {
		return tableId;
	}
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	public List<Long> getCuisineIds() {
		return cuisineIds;
	}
	public void setCuisineIds(List<Long> cuisineIds) {
		this.cuisineIds = cuisineIds;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

    // Getters and setters
}