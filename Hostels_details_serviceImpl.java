package com.hostelhibernate.ServiceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hostelhibernate.entity.Hostels_details;
import com.hostelhibernate.entity.Mahi_hostel;
import com.hostelhibernate.service.Hostels_details_services;

import java.util.List;
import java.util.Scanner;

public class Hostels_details_serviceImpl implements Hostels_details_services {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void insertHostels_details_services(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Hostels_details hostelsDetails = new Hostels_details();
        Mahi_hostel mahiHostel = new Mahi_hostel();

        System.out.print("Hostels Details ID: ");
        hostelsDetails.setHstl_id(sc.nextInt());

        System.out.print("Hostels Name: ");
        hostelsDetails.setHstl_name(sc.next());

        System.out.print("Address: ");
        hostelsDetails.setAddress(sc.next());

        System.out.print("Hostel Type: ");
        hostelsDetails.setHostel_type(sc.next());

        System.out.print("Total Capacity: ");
        hostelsDetails.setTotal_capacity(sc.nextInt());

        System.out.print("Enter Mahi Hostel ID to associate with this Hostels Details: ");
        int mahiHostelId = sc.nextInt();
        mahiHostel = session.get(Mahi_hostel.class, mahiHostelId);

        if (mahiHostel != null) {
            hostelsDetails.setMahi_hostel(mahiHostel);
        } else {
            System.out.println("Mahi Hostel not found with ID: " + mahiHostelId);
        }

        session.save(hostelsDetails);
        transaction.commit();
        System.out.println("Hostels Details inserted successfully!");

        session.close();
    }

    @Override
    public void updateHostels_details_services(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter Hostels Details ID to update: ");
        int hstlId = sc.nextInt();
        Hostels_details hostelsDetails = session.get(Hostels_details.class, hstlId);

        if (hostelsDetails != null) {
            System.out.println("Hostels Details found: " + hostelsDetails);

            System.out.print("Enter new Hostels Name: ");
            hostelsDetails.setHstl_name(sc.next());

            System.out.print("Enter new Address: ");
            hostelsDetails.setAddress(sc.next());

            System.out.print("Enter new Hostel Type: ");
            hostelsDetails.setHostel_type(sc.next());

            System.out.print("Enter new Total Capacity: ");
            hostelsDetails.setTotal_capacity(sc.nextInt());

            System.out.print("Do you want to update Mahi Hostel? (y/n): ");
            if (sc.next().equalsIgnoreCase("y")) {
                System.out.print("Enter Mahi Hostel ID to associate: ");
                int mahiHostelId = sc.nextInt();
                Mahi_hostel mahiHostel = session.get(Mahi_hostel.class, mahiHostelId);
                if (mahiHostel != null) {
                    hostelsDetails.setMahi_hostel(mahiHostel);
                } else {
                    System.out.println("Mahi Hostel not found.");
                }
            }

            session.update(hostelsDetails);
            transaction.commit();
            System.out.println("Hostels Details updated successfully!");
        } else {
            System.out.println("Hostels Details not found with ID: " + hstlId);
        }

        session.close();
    }

    @Override
    public void deleteHostels_details_services(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter Hostels Details ID to delete: ");
        int hstlId = sc.nextInt();
        Hostels_details hostelsDetails = session.get(Hostels_details.class, hstlId);

        if (hostelsDetails != null) {
            session.delete(hostelsDetails);
            transaction.commit();
            System.out.println("Hostels Details deleted successfully!");
        } else {
            System.out.println("Hostels Details not found with ID: " + hstlId);
        }

        session.close();
    }

    @Override
    public void getallHostels_details_services(SessionFactory sf) {
        Session session = sf.openSession();

        Query<Hostels_details> query = session.createQuery("from Hostels_details", Hostels_details.class);
        List<Hostels_details> hostelsDetailsList = query.getResultList();

        if (!hostelsDetailsList.isEmpty()) {
            System.out.println("All Hostels Details:");
            for (Hostels_details hostelsDetails : hostelsDetailsList) {
                System.out.println(hostelsDetails);
            }
        } else {
            System.out.println("No Hostels Details found.");
        }

        session.close();
    }

    @Override
    public void getHostels_details_services(SessionFactory sf) {
        Session session = sf.openSession();

        System.out.print("Enter Hostels Details ID to retrieve: ");
        int hstlId = sc.nextInt();
        Hostels_details hostelsDetails = session.get(Hostels_details.class, hstlId);

        if (hostelsDetails != null) {
            System.out.println("Hostels Details found: " + hostelsDetails);
        } else {
            System.out.println("Hostels Details not found with ID: " + hstlId);
        }

        session.close();
    }
}
