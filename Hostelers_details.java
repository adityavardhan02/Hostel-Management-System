package com.hostelhibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Getter
//@Setter
@NoArgsConstructor
public class Hostelers_details {
	@Id
	private Integer Hosteler_id;
	private String Candidate_name;
	private Integer Candidate_room_no;
	private Integer Paid_amount;
	private Integer Due_amount;
	private String Check_in_date;
	
	
	@ManyToOne()
	Mahi_hostel mahi_hostel;
	
	public Integer getHosteler_id() {
		return Hosteler_id;
	}

	public void setHosteler_id(Integer hosteler_id) {
		Hosteler_id = hosteler_id;
	}

	public String getCandidate_name() {
		return Candidate_name;
	}

	public void setCandidate_name(String candidate_name) {
		Candidate_name = candidate_name;
	}

	public Integer getCandidate_room_no() {
		return Candidate_room_no;
	}

	public void setCandidate_room_no(Integer candidate_room_no) {
		Candidate_room_no = candidate_room_no;
	}

	public Integer getPaid_amount() {
		return Paid_amount;
	}

	public void setPaid_amount(Integer paid_amount) {
		Paid_amount = paid_amount;
	}

	public Integer getDue_amount() {
		return Due_amount;
	}

	public void setDue_amount(Integer due_amount) {
		Due_amount = due_amount;
	}

	public String getCheck_in_date() {
		return Check_in_date;
	}

	public void setCheck_in_date(String check_in_date) {
		Check_in_date = check_in_date;
	}

	public Mahi_hostel getMahi_hostel() {
		return mahi_hostel;
	}

	public void setMahi_hostel(Mahi_hostel mahi_hostel) {
		this.mahi_hostel = mahi_hostel;
	}

	@Override
	public String toString() {
		return "Hostelers_details [Hosteler_id=" + Hosteler_id + ", Candidate_name=" + Candidate_name
				+ ", Candidate_room_no=" + Candidate_room_no + ", Paid_amount=" + Paid_amount + ", Due_amount="
				+ Due_amount + ", Check_in_date=" + Check_in_date + "]";
	}
	
}
