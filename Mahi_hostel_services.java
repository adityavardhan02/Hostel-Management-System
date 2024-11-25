package com.hostelhibernate.service;

import org.hibernate.SessionFactory;

public interface Mahi_hostel_services {
	void insertMahi_hostel_services(SessionFactory sf);
	 void updateMahi_hostel_services(SessionFactory sf);
	 void deleteMahi_hostel_services(SessionFactory sf);
	 void getallMahi_hostel_services(SessionFactory sf);
	 void getMahi_hostel_services(SessionFactory sf);
}
