package com.hostelhibernate.service;

import org.hibernate.SessionFactory;

public interface Hostelers_details_Service {
	 void insertHostelers_details_Service(SessionFactory sf);
	 void updateHostelers_details_Service(SessionFactory sf);
	 void deleteHostelers_details_Service(SessionFactory sf);
	 void getallHostelers_details_Service(SessionFactory sf);
	 void getHostelers_details_Service(SessionFactory sf);

}
