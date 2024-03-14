package org.TableBookingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "`tableData`")
public class Table {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tableId;
	
	private String tableName;
	
	private Long Capacity;
	
	private boolean booked;

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getCapacity() {
	    return Capacity;
	}

	public void setCapacity(Long capacity) {
	    this.Capacity = capacity;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Table(Long tableId, String tableName, Long capacity, boolean booked) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		Capacity = capacity;
		this.booked = booked;
	}

}