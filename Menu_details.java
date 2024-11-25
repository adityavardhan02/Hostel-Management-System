package com.hostelhibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
//@Getter
//@Setter
@NoArgsConstructor
public class Menu_details {
	

	@Id
	private Integer Menu_id;
	private String day;
	private String Breakfast;
	private String Lunch;
	private String Dinner;
	
	@ManyToOne()
	Mahi_hostel mahi_hostel;
	public Integer getMenu_id() {
		return Menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		Menu_id = menu_id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getBreakfast() {
		return Breakfast;
	}

	public void setBreakfast(String breakfast) {
		Breakfast = breakfast;
	}

	public String getLunch() {
		return Lunch;
	}

	public void setLunch(String lunch) {
		Lunch = lunch;
	}

	public String getDinner() {
		return Dinner;
	}

	public void setDinner(String dinner) {
		Dinner = dinner;
	}

	public Mahi_hostel getMahi_hostel() {
		return mahi_hostel;
	}

	public void setMahi_hostel(Mahi_hostel mahi_hostel) {
		this.mahi_hostel = mahi_hostel;
	}


	
	@Override
	public String toString() {
		return "Menu_details [Menu_id=" + Menu_id + ", day=" + day + ", Breakfast=" + Breakfast + ", Lunch=" + Lunch
				+ ", Dinner=" + Dinner + "]";
	}
	
	
	
}
