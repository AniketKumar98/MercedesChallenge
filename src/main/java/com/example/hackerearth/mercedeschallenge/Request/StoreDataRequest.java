package com.example.hackerearth.mercedeschallenge.Request;

import java.sql.Date;

public class StoreDataRequest {
	
	public String name;
	public int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String occur;
	public String getOccur() {
		return occur;
	}
	public void setOccur(String occur) {
		this.occur = occur;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date fromdate;
	public Date todate;
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
}
