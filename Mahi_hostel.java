package com.hostelhibernate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//@Getter
//@Setter
@NoArgsConstructor
@ToString
public class Mahi_hostel {
	@Id
	private Integer Mahi_hostel_id;
	public Integer getMahi_hostel_id() {
		return Mahi_hostel_id;
	}

	public void setMahi_hostel_id(Integer mahi_hostel_id) {
		Mahi_hostel_id = mahi_hostel_id;
	}

	public String getOwner_name() {
		return Owner_name;
	}

	public void setOwner_name(String owner_name) {
		Owner_name = owner_name;
	}

	public Integer getNo_of_rooms() {
		return no_of_rooms;
	}

	public void setNo_of_rooms(Integer no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public Hostels_details getHostels_details() {
		return hostels_details;
	}

	public void setHostels_details(Hostels_details hostels_details) {
		this.hostels_details = hostels_details;
	}

	public List<Menu_details> getMenu_details() {
		return menu_details;
	}

	public void setMenu_details(List<Menu_details> menu_details) {
		this.menu_details = menu_details;
	}

	public List<Hostelers_details> getHostelers_details() {
		return hostelers_details;
	}

	public void setHostelers_details(List<Hostelers_details> hostelers_details) {
		this.hostelers_details = hostelers_details;
	}

	private String Owner_name;
	private Integer no_of_rooms;
	private Integer Price;
	
	@OneToOne(targetEntity=Hostels_details.class)
	private Hostels_details hostels_details;
	
	@OneToMany(mappedBy="mahi_hostel")
	List<Menu_details> menu_details=new ArrayList<Menu_details>();
	
	@OneToMany(mappedBy="mahi_hostel")
	List<Hostelers_details> hostelers_details=new ArrayList<Hostelers_details>();

	
	}

	

	
	

