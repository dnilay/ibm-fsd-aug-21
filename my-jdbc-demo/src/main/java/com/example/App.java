package com.example;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class App {
    private CustomerDao customerDao;
    private static Scanner scanner = new Scanner(System.in);

    {
        customerDao = new CustomerDaoImpl();
    }

    public static void main(String[] args) throws SQLException {
        App app = new App();
        int choice = 0;
        do {
            System.out.println("1. Create Customer: ");
            System.out.println("2. Display All Customer: ");
            System.out.println("0.Exit: ");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("First Name: ");
                    String firstName = scanner.next();
                    System.out.print("Last Name: ");
                    String lastName = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    Customer customer = new Customer(firstName, lastName, email);
                    Customer tempCustomer = app.customerDao.createCustomer(customer);
                    System.out.println("Customer Created: " + customer);
                    break;
                case 2:
                    List<Customer> list=app.customerDao.displayAllCustomer();
                    for(Customer c:list)
                    {
                        System.out.println(c);
                    }
                    break;
                case 0:
                    System.out.println("Bye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice....");
                    break;
            }


        } while (choice != 0);

    }
}