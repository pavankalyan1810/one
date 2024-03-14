package org.TableBookingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cuisine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cuisineId;
	
	private String cuisineName;
	
	private String cuisineItem;
	
	private Long cuisnePrice;
	

	public Long getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(Long cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	public String getCuisineItem() {
		return cuisineItem;
	}

	public void setCuisineItem(String cuisineItem) {
		this.cuisineItem = cuisineItem;
	}

	public Long getCuisnePrice() {
		return cuisnePrice;
	}

	public void setCuisnePrice(Long cuisnePrice) {
		this.cuisnePrice = cuisnePrice;
	}

	public Cuisine(Long cuisineId, String cuisineName, String cuisineItem, Long cuisnePrice) {
		super();
		this.cuisineId = cuisineId;
		this.cuisineName = cuisineName;
		this.cuisineItem = cuisineItem;
		this.cuisnePrice = cuisnePrice;
	}

	public Cuisine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
