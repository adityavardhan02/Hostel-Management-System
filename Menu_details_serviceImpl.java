package com.hostelhibernate.ServiceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hostelhibernate.entity.Mahi_hostel;
import com.hostelhibernate.entity.Menu_details;
import com.hostelhibernate.service.Menu_details_services;

import java.util.List;
import java.util.Scanner;

public class Menu_details_serviceImpl implements Menu_details_services {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void insertMenu_details_Service(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Menu_details menuDetails = new Menu_details();

        System.out.print("Enter Menu ID: ");
        menuDetails.setMenu_id(sc.nextInt());

        System.out.print("Enter Day (e.g., Monday): ");
        menuDetails.setDay(sc.next());

        System.out.print("Enter Breakfast details: ");
        menuDetails.setBreakfast(sc.next());

        System.out.print("Enter Lunch details: ");
        menuDetails.setLunch(sc.next());

        System.out.print("Enter Dinner details: ");
        menuDetails.setDinner(sc.next());

        System.out.print("Enter Mahi Hostel ID to associate with this menu: ");
        int mahiHostelId = sc.nextInt();
        Mahi_hostel mahiHostel = session.get(Mahi_hostel.class, mahiHostelId);
        if (mahiHostel != null) {
            menuDetails.setMahi_hostel(mahiHostel);
        } else {
            System.out.println("Mahi Hostel not found with ID: " + mahiHostelId);
        }

        session.save(menuDetails);
        transaction.commit();
        System.out.println("Menu details inserted successfully!");

        session.close();
    }

    @Override
    public void updateMenu_details_Service(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter Menu ID to update: ");
        int menuId = sc.nextInt();
        Menu_details menuDetails = session.get(Menu_details.class, menuId);

        if (menuDetails != null) {
            System.out.println("Menu found: " + menuDetails);

            System.out.print("Enter new Day: ");
            menuDetails.setDay(sc.next());

            System.out.print("Enter new Breakfast details: ");
            menuDetails.setBreakfast(sc.next());

            System.out.print("Enter new Lunch details: ");
            menuDetails.setLunch(sc.next());

            System.out.print("Enter new Dinner details: ");
            menuDetails.setDinner(sc.next());

            System.out.print("Do you want to update Mahi Hostel association? (y/n): ");
            if (sc.next().equalsIgnoreCase("y")) {
                System.out.print("Enter Mahi Hostel ID to associate: ");
                int mahiHostelId = sc.nextInt();
                Mahi_hostel mahiHostel = session.get(Mahi_hostel.class, mahiHostelId);
                if (mahiHostel != null) {
                    menuDetails.setMahi_hostel(mahiHostel);
                } else {
                    System.out.println("Mahi Hostel not found.");
                }
            }

            session.update(menuDetails);
            transaction.commit();
            System.out.println("Menu details updated successfully!");
        } else {
            System.out.println("Menu not found with ID: " + menuId);
        }

        session.close();
    }

    @Override
    public void deleteMenu_details_Service(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.print("Enter Menu ID to delete: ");
        int menuId = sc.nextInt();
        Menu_details menuDetails = session.get(Menu_details.class, menuId);

        if (menuDetails != null) {
            session.delete(menuDetails);
            transaction.commit();
            System.out.println("Menu details deleted successfully!");
        } else {
            System.out.println("Menu not found with ID: " + menuId);
        }

        session.close();
    }

    @Override
    public void getallMenu_details_Service(SessionFactory sf) {
        Session session = sf.openSession();

        Query<Menu_details> query = session.createQuery("from Menu_details", Menu_details.class);
        List<Menu_details> menuDetailsList = query.getResultList();

        if (!menuDetailsList.isEmpty()) {
            System.out.println("All Menu Details:");
            for (Menu_details menu : menuDetailsList) {
                System.out.println(menu);
            }
        } else {
            System.out.println("No menu details found.");
        }

        session.close();
    }

    @Override
    public void getMenu_details_Service(SessionFactory sf) {
        Session session = sf.openSession();

        System.out.print("Enter Menu ID to retrieve: ");
        int menuId = sc.nextInt();
        Menu_details menuDetails = session.get(Menu_details.class, menuId);

        if (menuDetails != null) {
            System.out.println("Menu found: " + menuDetails);
        } else {
            System.out.println("Menu not found with ID: " + menuId);
        }

        session.close();
    }
}
