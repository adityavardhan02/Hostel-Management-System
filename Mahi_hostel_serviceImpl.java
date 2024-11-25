package com.hostelhibernate.ServiceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hostelhibernate.entity.Hostels_details;
import com.hostelhibernate.entity.Mahi_hostel;
import com.hostelhibernate.service.Mahi_hostel_services;

import java.util.List;
import java.util.Scanner;

public class Mahi_hostel_serviceImpl implements Mahi_hostel_services {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void insertMahi_hostel_services(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Mahi_hostel mahiHostel = new Mahi_hostel();

        System.out.print("Enter Mahi Hostel ID: ");
        mahiHostel.setMahi_hostel_id(sc.nextInt());

        System.out.print("Enter Owner Name: ");
        mahiHostel.setOwner_name(sc.next());

        System.out.print("Enter Number of Rooms: ");
        mahiHostel.setNo_of_rooms(sc.nextInt());

        System.out.print("Enter Price: ");
        mahiHostel.setPrice(sc.nextInt());

        System.out.print("Enter Hostels Details ID to associate with this Mahi Hostel: ");
        int hostelsDetailsId = sc.nextInt();
        Hostels_details hostelsDetails = session.get(Hostels_details.class, hostelsDetailsId);
        if (hostelsDetails != null) {
            mahiHostel.setHostels_details(hostelsDetails);
        } else {
            System.out.println("Hostels Details not found with ID: " + hostelsDetailsId);
        }

        session.save(mahiHostel);
        transaction.commit();
        System.out.println("Mahi Hostel inserted successfully!");

        session.close();
    }

    @Override
    public void updateMahi_hostel_services(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter Mahi Hostel ID to update: ");
        int mahiHostelId = sc.nextInt();
        Mahi_hostel mahiHostel = session.get(Mahi_hostel.class, mahiHostelId);

        if (mahiHostel != null) {
            System.out.println("Mahi Hostel found: " + mahiHostel);

            System.out.print("Enter new Owner Name: ");
            mahiHostel.setOwner_name(sc.next());

            System.out.print("Enter new Number of Rooms: ");
            mahiHostel.setNo_of_rooms(sc.nextInt());

            System.out.print("Enter new Price: ");
            mahiHostel.setPrice(sc.nextInt());

            System.out.print("Do you want to update Hostels Details? (y/n): ");
            if (sc.next().equalsIgnoreCase("y")) {
                System.out.print("Enter Hostels Details ID to associate: ");
                int hostelsDetailsId = sc.nextInt();
                Hostels_details hostelsDetails = session.get(Hostels_details.class, hostelsDetailsId);
                if (hostelsDetails != null) {
                    mahiHostel.setHostels_details(hostelsDetails);
                } else {
                    System.out.println("Hostels Details not found.");
                }
            }

            session.update(mahiHostel);
            transaction.commit();
            System.out.println("Mahi Hostel updated successfully!");
        } else {
            System.out.println("Mahi Hostel not found with ID: " + mahiHostelId);
        }

        session.close();
    }

    @Override
    public void deleteMahi_hostel_services(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter Mahi Hostel ID to delete: ");
        int mahiHostelId = sc.nextInt();
        Mahi_hostel mahiHostel = session.get(Mahi_hostel.class, mahiHostelId);

        if (mahiHostel != null) {
            session.delete(mahiHostel);
            transaction.commit();
            System.out.println("Mahi Hostel deleted successfully!");
        } else {
            System.out.println("Mahi Hostel not found with ID: " + mahiHostelId);
        }

        session.close();
    }

    @Override
    public void getallMahi_hostel_services(SessionFactory sf) {
        Session session = sf.openSession();

        Query<Mahi_hostel> query = session.createQuery("from Mahi_hostel", Mahi_hostel.class);
        List<Mahi_hostel> mahiHostels = query.getResultList();

        if (!mahiHostels.isEmpty()) {
            System.out.println("All Mahi Hostels:");
            for (Mahi_hostel mahiHostel : mahiHostels) {
                System.out.println(mahiHostel);
            }
        } else {
            System.out.println("No Mahi Hostels found.");
        }

        session.close();
    }

    @Override
    public void getMahi_hostel_services(SessionFactory sf) {
        Session session = sf.openSession();

        System.out.print("Enter Mahi Hostel ID to retrieve: ");
        int mahiHostelId = sc.nextInt();
        Mahi_hostel mahiHostel = session.get(Mahi_hostel.class, mahiHostelId);

        if (mahiHostel != null) {
            System.out.println("Mahi Hostel found: " + mahiHostel);
        } else {
            System.out.println("Mahi Hostel not found with ID: " + mahiHostelId);
        }

        session.close();
    }
}
