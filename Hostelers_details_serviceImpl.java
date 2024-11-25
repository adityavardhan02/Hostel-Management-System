package com.hostelhibernate.ServiceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hostelhibernate.entity.Hostelers_details;
import com.hostelhibernate.entity.Mahi_hostel;
import com.hostelhibernate.service.Hostelers_details_Service;

import java.util.List;
import java.util.Scanner;

public class Hostelers_details_serviceImpl implements Hostelers_details_Service {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void insertHostelers_details_Service(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        // Create a new Hosteler
        Hostelers_details hosteler = new Hostelers_details();

        System.out.println("Enter Hosteler details:");
        System.out.print("Hosteler ID: ");
        hosteler.setHosteler_id(sc.nextInt());
        System.out.print("Candidate Name: ");
        hosteler.setCandidate_name(sc.next());
        System.out.print("Candidate Room No: ");
        hosteler.setCandidate_room_no(sc.nextInt());
        System.out.print("Paid Amount: ");
        hosteler.setPaid_amount(sc.nextInt());
        System.out.print("Due Amount: ");
        hosteler.setDue_amount(sc.nextInt());
        System.out.print("Check-in Date (YYYY-MM-DD): ");
        hosteler.setCheck_in_date(sc.next());

        // Fetch Mahi_hostel object to link with Hosteler
        System.out.print("Enter Mahi_hostel ID: ");
        int hostelId = sc.nextInt();
        Mahi_hostel mahiHostel = session.get(Mahi_hostel.class, hostelId);
        
        if (mahiHostel != null) {
            hosteler.setMahi_hostel(mahiHostel);  // Set the Mahi_hostel object
        } else {
            System.out.println("Mahi_hostel not found with ID: " + hostelId);
        }

        // Save the hosteler
        session.save(hosteler);
        transaction.commit();
        session.close();

        System.out.println("Hosteler details inserted successfully!");
    }

    @Override
    public void updateHostelers_details_Service(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter Hosteler ID to update: ");
        int hostelerId = sc.nextInt();
        Hostelers_details hosteler = session.get(Hostelers_details.class, hostelerId);

        if (hosteler != null) {
            System.out.println("Hosteler found: " + hosteler.getCandidate_name());

            // Update Hosteler details
            System.out.print("New Candidate Name: ");
            hosteler.setCandidate_name(sc.next());
            System.out.print("New Room No: ");
            hosteler.setCandidate_room_no(sc.nextInt());
            System.out.print("New Paid Amount: ");
            hosteler.setPaid_amount(sc.nextInt());
            System.out.print("New Due Amount: ");
            hosteler.setDue_amount(sc.nextInt());
            System.out.print("New Check-in Date (YYYY-MM-DD): ");
            hosteler.setCheck_in_date(sc.next());

            // Optionally update the Mahi_hostel information
            System.out.print("Update Mahi_hostel ID? (y/n): ");
            if (sc.next().equalsIgnoreCase("y")) {
                System.out.print("Enter new Mahi_hostel ID: ");
                int hostelId = sc.nextInt();
                Mahi_hostel mahiHostel = session.get(Mahi_hostel.class, hostelId);
                if (mahiHostel != null) {
                    hosteler.setMahi_hostel(mahiHostel);
                } else {
                    System.out.println("Mahi_hostel not found with ID: " + hostelId);
                }
            }

            // Save the updated hosteler
            session.update(hosteler);
            transaction.commit();
            System.out.println("Hosteler details updated successfully!");
        } else {
            System.out.println("Hosteler not found with ID: " + hostelerId);
        }

        session.close();
    }

    @Override
    public void deleteHostelers_details_Service(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter Hosteler ID to delete: ");
        int hostelerId = sc.nextInt();
        Hostelers_details hosteler = session.get(Hostelers_details.class, hostelerId);

        if (hosteler != null) {
            session.delete(hosteler);  // Delete the hosteler
            transaction.commit();
            System.out.println("Hosteler deleted successfully!");
        } else {
            System.out.println("Hosteler not found with ID: " + hostelerId);
        }

        session.close();
    }

    @Override
    public void getallHostelers_details_Service(SessionFactory sf) {
        Session session = sf.openSession();

        Query<Hostelers_details> query = session.createQuery("from Hostelers_details", Hostelers_details.class);
        List<Hostelers_details> hostelersList = query.getResultList();

        if (!hostelersList.isEmpty()) {
            System.out.println("Hosteler details:");
            for (Hostelers_details hosteler : hostelersList) {
                System.out.println(hosteler);
            }
        } else {
            System.out.println("No Hostelers found.");
        }

        session.close();
    }

    @Override
    public void getHostelers_details_Service(SessionFactory sf) {
        Session session = sf.openSession();

        System.out.print("Enter Hosteler ID to retrieve: ");
        int hostelerId = sc.nextInt();
        Hostelers_details hosteler = session.get(Hostelers_details.class, hostelerId);

        if (hosteler != null) {
            System.out.println("Hosteler details: " + hosteler);
        } else {
            System.out.println("Hosteler not found with ID: " + hostelerId);
        }

        session.close();
    }
}
