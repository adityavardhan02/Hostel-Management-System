package com.hostelhibernate.service;

import org.hibernate.SessionFactory;

public interface Hostels_details_services {
	 void insertHostels_details_services(SessionFactory sf);
	 void updateHostels_details_services(SessionFactory sf);
	 void deleteHostels_details_services(SessionFactory sf);
	 void getallHostels_details_services(SessionFactory sf);
	 void getHostels_details_services(SessionFactory sf);
}
