package com.hostelhibernate.service;

import org.hibernate.SessionFactory;

public interface Menu_details_services {
	void insertMenu_details_Service(SessionFactory sf);
	 void updateMenu_details_Service(SessionFactory sf);
	 void deleteMenu_details_Service(SessionFactory sf);
	 void getallMenu_details_Service(SessionFactory sf);
	 void getMenu_details_Service(SessionFactory sf);

}
