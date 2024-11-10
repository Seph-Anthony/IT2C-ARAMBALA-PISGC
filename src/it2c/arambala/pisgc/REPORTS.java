/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it2c.arambala.pisgc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class REPORTS {
    
    public void reportinfo() {
        Scanner in = new Scanner(System.in);
        config conf = new config();
        CUSTOMER cus = new CUSTOMER();
        int customerId = 0;

        
        String test = "SELECT * FROM CUSTOMER_DETAILS";
                String[] headers = {"ID", "NAME", "LAST NAME"};
                String[] Columns = {"c_id", "c_fname", "c_lname"};

    conf.viewRecords(test, headers, Columns);
        while (true) {
            System.out.print("Enter your Customer ID to view your report: ");
            String input = in.nextLine().trim();

            try {
                customerId = Integer.parseInt(input);
                if (customerId > 0) {
                    break; 
                } else {
                    System.out.println("Customer ID must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid Customer ID.");
            }
        }

        
        String customerQuery = "SELECT c_fname, c_lname, c_email, c_contact FROM CUSTOMER_DETAILS WHERE c_id = ?";
        String[] customerInfo = new String[4]; 

        try (Connection conn = conf.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(customerQuery)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                customerInfo[0] = rs.getString("c_fname");
                customerInfo[1] = rs.getString("c_lname");
                customerInfo[2] = rs.getString("c_email");
                customerInfo[3] = rs.getString("c_contact");
            } else {
                System.out.println("No customer found for the given Customer ID.");
                return; 
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customer information: " + e.getMessage());
            return; 
        }

        
        String orderQuery = "SELECT p_name, t_quantity, t_totalam, t_date FROM PROCESS_DETAILS " +
                            "JOIN PRODUCT_DETAILS ON PROCESS_DETAILS.p_id = PRODUCT_DETAILS.p_id " +
                            "WHERE PROCESS_DETAILS.c_id = ?";
        
        System.out.println("\nCustomer Information:");
        System.out.printf("Full Name: %s %s\n", customerInfo[0], customerInfo[1]);
        System.out.printf("Email: %s\n", customerInfo[2]);
        System.out.printf("Contact: %s\n", customerInfo[3]);
        System.out.println("\nOrder Details:");

        try (Connection conn = conf.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(orderQuery)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();

        
            System.out.printf("%-30s %-10s %-10s %-10s\n", "Product Name", "Quantity", "Total", "Date");
            System.out.println("-------------------------------------------------------------");

            boolean hasOrders = false; 
            while (rs.next()) {
                hasOrders = true; 
                String productName = rs.getString("p_name");
                int quantity = rs.getInt("t_quantity");
                double totalAmount = rs.getDouble("t_totalam");
                String date = rs.getString("t_date");

                System.out.printf("%-30s %-10d %-10.2f %-10s\n", productName, quantity, totalAmount, date);
            }

            if (!hasOrders) {
                System.out.println("No orders found for this customer.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving order details: " + e.getMessage());
        }
    }
}
