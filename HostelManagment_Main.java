package com.hostelhibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.hostelhibernate.ServiceImpl.Hostels_details_serviceImpl;
import com.hostelhibernate.ServiceImpl.Hostelers_details_serviceImpl;
import com.hostelhibernate.ServiceImpl.Mahi_hostel_serviceImpl;
import com.hostelhibernate.ServiceImpl.Menu_details_serviceImpl;
import com.hostelhibernate.Utility.ConfigurationUtility;
import com.hostelhibernate.entity.Hostels_details;
import com.hostelhibernate.entity.Hostelers_details;
import com.hostelhibernate.entity.Mahi_hostel;
import com.hostelhibernate.entity.Menu_details;

import java.util.Scanner;

public class HostelManagment_Main {
    
    public static void main(String[] args) {
        
        // Create SessionFactory using Hibernate Configuration utility
        SessionFactory sessionFactory = ConfigurationUtility.getsFactory(); // Assuming your custom method
        Scanner sc = new Scanner(System.in);
        int choice;
        
        // Menu-driven system to perform CRUD operations
        do {
            System.out.println("----- Hostel Management System -----");
            System.out.println("1. Hostels Details Operations");
            System.out.println("2. Hostelers Details Operations");
            System.out.println("3. Mahi Hostel Operations");
            System.out.println("4. Menu Details Operations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Hostels Details Operations
                    System.out.println("----- Hostels Details Operations -----");
                    hostelsDetailsMenu(sessionFactory);
                    break;

                case 2:
                    // Hostelers Details Operations
                    System.out.println("----- Hostelers Details Operations -----");
                    hostelersDetailsMenu(sessionFactory);
                    break;

                case 3:
                    // Mahi Hostel Operations
                    System.out.println("----- Mahi Hostel Operations -----");
                    mahiHostelMenu(sessionFactory);
                    break;

                case 4:
                    // Menu Details Operations
                    System.out.println("----- Menu Details Operations -----");
                    menuDetailsMenu(sessionFactory);
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        // Clean up resources after main menu loop exits
        sessionFactory.close();
    }

    private static void hostelsDetailsMenu(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        Hostels_details_serviceImpl hostelsDetailsService = new Hostels_details_serviceImpl();
        
        int hostelsChoice;
        System.out.println("1. Add Hostels Details");
        System.out.println("2. Update Hostels Details");
        System.out.println("3. Delete Hostels Details");
        System.out.println("4. View All Hostels Details");
        System.out.println("5. View Hostels Details by ID");
        System.out.print("Enter your choice: ");
        hostelsChoice = sc.nextInt();
        
        switch (hostelsChoice) {
            case 1:
                hostelsDetailsService.insertHostels_details_services(sessionFactory);
                break;
            case 2:
                hostelsDetailsService.updateHostels_details_services(sessionFactory);
                break;
            case 3:
                hostelsDetailsService.deleteHostels_details_services(sessionFactory);
                break;
            case 4:
                hostelsDetailsService.getallHostels_details_services(sessionFactory);
                break;
            case 5:
                hostelsDetailsService.getHostels_details_services(sessionFactory);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void hostelersDetailsMenu(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        Hostelers_details_serviceImpl hostelersDetailsService = new Hostelers_details_serviceImpl();
        
        int hostelersChoice;
        System.out.println("1. Add Hosteler");
        System.out.println("2. Update Hosteler");
        System.out.println("3. Delete Hosteler");
        System.out.println("4. View All Hostelers");
        System.out.println("5. View Hosteler by ID");
        System.out.print("Enter your choice: ");
        hostelersChoice = sc.nextInt();
        
        switch (hostelersChoice) {
            case 1:
                hostelersDetailsService.insertHostelers_details_Service(sessionFactory);
                break;
            case 2:
                hostelersDetailsService.updateHostelers_details_Service(sessionFactory);
                break;
            case 3:
                hostelersDetailsService.deleteHostelers_details_Service(sessionFactory);
                break;
            case 4:
                hostelersDetailsService.getallHostelers_details_Service(sessionFactory);
                break;
            case 5:
                hostelersDetailsService.getHostelers_details_Service(sessionFactory);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void mahiHostelMenu(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        Mahi_hostel_serviceImpl mahiHostelService = new Mahi_hostel_serviceImpl();
        
        int mahiHostelChoice;
        System.out.println("1. Add Mahi Hostel");
        System.out.println("2. Update Mahi Hostel");
        System.out.println("3. Delete Mahi Hostel");
        System.out.println("4. View All Mahi Hostels");
        System.out.println("5. View Mahi Hostel by ID");
        System.out.print("Enter your choice: ");
        mahiHostelChoice = sc.nextInt();
        
        switch (mahiHostelChoice) {
            case 1:
                mahiHostelService.insertMahi_hostel_services(sessionFactory);
                break;
            case 2:
                mahiHostelService.updateMahi_hostel_services(sessionFactory);
                break;
            case 3:
                mahiHostelService.deleteMahi_hostel_services(sessionFactory);
                break;
            case 4:
                mahiHostelService.getallMahi_hostel_services(sessionFactory);
                break;
            case 5:
                mahiHostelService.getMahi_hostel_services(sessionFactory);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void menuDetailsMenu(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        Menu_details_serviceImpl menuDetailsService = new Menu_details_serviceImpl();
        
        int menuChoice;
        System.out.println("1. Add Menu Details");
        System.out.println("2. Update Menu Details");
        System.out.println("3. Delete Menu Details");
        System.out.println("4. View All Menu Details");
        System.out.println("5. View Menu Details by ID");
        System.out.print("Enter your choice: ");
        menuChoice = sc.nextInt();
        
        switch (menuChoice) {
            case 1:
                menuDetailsService.insertMenu_details_Service(sessionFactory);
                break;
            case 2:
                menuDetailsService.updateMenu_details_Service(sessionFactory);
                break;
            case 3:
                menuDetailsService.deleteMenu_details_Service(sessionFactory);
                break;
            case 4:
                menuDetailsService.getallMenu_details_Service(sessionFactory);
                break;
            case 5:
                menuDetailsService.getMenu_details_Service(sessionFactory);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
