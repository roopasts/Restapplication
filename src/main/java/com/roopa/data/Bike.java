package com.roopa.data;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Bike{ 

	public String colour;
	public String model;
	public String year;
	
	
	public Vehicle vehicle;

	
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
		 
	}
	
	public void display(){
		System.out.println("bike making");
		Bike bike = new Bike();
     	bike.getYear();
		vehicle.Title();
	}
	
//	public void show() {
//		Bike bike = new Bike();
//		bike.model = getModel();
//		System.out.println("engine details");
//		vehicle.Title();
//	}
}
