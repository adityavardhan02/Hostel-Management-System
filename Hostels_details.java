package com.hostelhibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Getter
//@Setter
@NoArgsConstructor
public class Hostels_details {
	@Id
	private Integer Hstl_id;
	private String Hstl_name;
	private String Address;
	private String Hostel_type;
	private Integer Total_capacity;
	
	@OneToOne()
	private Mahi_hostel mahi_hostel;
	

	public Integer getHstl_id() {
		return Hstl_id;
	}


	public void setHstl_id(Integer hstl_id) {
		Hstl_id = hstl_id;
	}


	public String getHstl_name() {
		return Hstl_name;
	}


	public void setHstl_name(String hstl_name) {
		Hstl_name = hstl_name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getHostel_type() {
		return Hostel_type;
	}


	public void setHostel_type(String hostel_type) {
		Hostel_type = hostel_type;
	}


	public Integer getTotal_capacity() {
		return Total_capacity;
	}


	public void setTotal_capacity(Integer total_capacity) {
		Total_capacity = total_capacity;
	}


	public Mahi_hostel getMahi_hostel() {
		return mahi_hostel;
	}


	public void setMahi_hostel(Mahi_hostel mahi_hostel) {
		this.mahi_hostel = mahi_hostel;
	}


	@Override
	public String toString() {
		return "Hostels_details [Hstl_id=" + Hstl_id + ", Hstl_name=" + Hstl_name + ", Address=" + Address
				+ ", Hostel_type=" + Hostel_type + ", Total_capacity=" + Total_capacity + ", mahi_hostel=" + mahi_hostel
				+ "]";
	}
	
}

