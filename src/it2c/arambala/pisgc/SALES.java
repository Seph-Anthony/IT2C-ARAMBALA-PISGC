/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it2c.arambala.pisgc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class SALES {
    
    public void salesprocess(){
        IT2CARAMBALAPISGC deal = new IT2CARAMBALAPISGC();
    SALES sal = new SALES();
        Scanner in = new Scanner(System.in);
        String another = null;
        String input = null;
        int action = 0;
        
        do{
        System.out.println("___________________________");
        System.out.println("||SALES ORDER\t||");
        System.out.println("|1.ADD SALES\t||");
        System.out.println("|2.VIEW SALES\t||");
        System.out.println("|3.DELETE SALES ||");
         System.out.println("|4.BACK         ||");   
        System.out.println("___________________________");
        while(true){
            System.out.print("INPUT: ");
             input = in.nextLine().trim();
           
                
              
            
                
                
            
            
            try{
                
                action = Integer.parseInt(input);
                if(action>=1 && action <=4){
                    
                    break;
                }
                
               
                
                else{
                    
                    System.out.println("Number Input Invalid");
                }
            }
            
            catch(NumberFormatException e){
                
                System.out.println("Invalid Input");
                
            }
            
            
            
        }
        
        
        switch(action){
            
            case 1:
                
                sal.addprocess();
                
                break;
                
            case 2:
                sal.viewprocess();
                
                break;
                
            case 3:
                sal.deleteprocess();
                break;
                
            case 4:
                deal.main(new String[]{});
                break;
                
           
            
        
    }
        
        System.out.print("\nWould you like to input another Sales Order(Yes|No): ");
    another = in.nextLine();
    
    while(!another.equalsIgnoreCase("yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("Yes") &&
            !another.equalsIgnoreCase("No") && !another.equalsIgnoreCase("no") && !another.equalsIgnoreCase("NO") ){
        
        System.out.print("||INVALID INPUT|| \n Try again: ");
        another=in.nextLine();
        
        
    }
    
        }while(another.equals("yes") || another.equals("YES") || another.equals("Yes"));
        System.out.println("\n THANK YOU FOR USING ");
}
    
    public void addprocess(){
 Scanner in = new Scanner(System.in);
 config conf = new config();
 CUSTOMER cus = new CUSTOMER();
 PRODUCT prod = new PRODUCT();
 config updateconfi = new config();
int cusid = 0;
String idcus = null;
int id = 0;
 int pid= 0;
 String pinput = null;
 double quantity = 0;
 double total = 0;
 double price = 0;
 double gcash = 0;
 String date = null;
 String status = null;
 double change = 0;
 double stock = 0;
 double quan = 0;
 double updatequan = 0;
 String another = null;
 
 
 config view = new config();
 String priceqry = null, stockqry = null, quantityqry = null, updatesql = null;
 
 do{
  System.out.println("|| SELECT CUSTOMER ID ||");
   
 cus.viewcustomer();
 
 while (true) {
            System.out.print("Enter the ID of the Customer: ");
            String customerInput = in.nextLine().trim();

            try {
                id = Integer.parseInt(customerInput);
                if (id >= 0) {
                    
                    if (conf.getSingleValue("SELECT c_id FROM CUSTOMER_DETAILS WHERE c_id = ?", id) != 0) {
                        break; 
                    } else {
                        System.out.println("ID doesn't exist. Try Again.");
                    }
                } else {
                    System.out.println("Number Invalid Input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please enter a valid number.");
            }
        }

            
            System.out.println("|| SELECT PRODUCT ID ||");
        
    String test = "SELECT * FROM PRODUCT_DETAILS WHERE p_status != 0 ";
                String[] headers = {"ID", "NAME", "PRICE", "STOCK", "STATUS"};
                String[] Columns = {"p_id", "p_name", "p_price", "p_stock","p_status"};

    view.viewRecords(test, headers, Columns);
            while(true){
            System.out.print("Enter the ID of the Product: ");
            String productinput = in.nextLine().trim();
            
            try{
                pid = Integer.parseInt(productinput);
                
                if(pid>=0){
                    if(conf.getSingleValue("SELECT p_id FROM PRODUCT_DETAILS WHERE p_id = ?", pid) != 0){
                    break;
                } 
                    else{
                        System.out.println("ID doesn't Exist");
                        
                        }
                }else{
                    System.out.println("Invalid Input. Please enter a valid number.");
                }
            }
            catch(NumberFormatException e){
          
           System.out.println("Invalid Input. Please enter a valid number.");
            }
            }
      
              stockqry = "SELECT p_stock FROM PRODUCT_DETAILS WHERE p_id = ?";
            stock = conf.getSingleValue(stockqry, pid);
           
            while(stock == 0 ){
                
                System.out.print("PRODUCT STOCK NOT AVAILABLE \n Try Again: ");
                pid=in.nextInt();
                stock = conf.getSingleValue(stockqry, pid);
            }
           
            
     
            
             while(conf.getSingleValue("SELECT p_id FROM PRODUCT_DETAILS WHERE p_id = ? ", pid) == 0){
            
                
                
            System.out.print("ID doesn't exist \n Try Again: ");
            cusid = in.nextInt();
           
        }
             
              
           while (true) {
            System.out.print("Enter the quantity of the Product: ");
            String quantityInput = in.nextLine().trim();

            try {
            
                quantity = Double.parseDouble(quantityInput);
                if (quantity > 0 && quantity <= stock) {
                    break; 
                } else {
                    System.out.println("Quantity must be a positive number and cannot exceed available stock (" + stock + ").");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a valid number.");
            } 
        }
             
             updatequan = stock - quantity;
             
             updatesql = "UPDATE PRODUCT_DETAILS SET p_stock = ? WHERE p_id = ?";
             updateconfi.updateRecord(updatesql, updatequan, pid);
             
//             String stocksql = "UPDATE PRODUCT_DETAILS SET STOCK = ?, STATUS = ? WHERE ID = ?";
//                stockconfi.updateRecord(stocksql, stock, id, status);
//             
             
           priceqry = "SELECT p_price FROM PRODUCT_DETAILS WHERE p_id = ?";
            price = conf.getSingleValue(priceqry, pid);
            total = price * quantity;
            
            System.out.println("\n________________________________");
            System.out.print("Total Amount: "+total);
            System.out.println("\n________________________________");
            
                    while (true) {
            System.out.print("\nEnter the Cash: ");
            String cashInput = in.nextLine().trim();
            try {
               gcash = Double.parseDouble(cashInput);
                if (gcash >= total) {
                    break; 
                } else {
                    System.out.println("Insufficient Cash Amount. Please enter a valid amount.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please enter a valid number");   
            }
            }

            change = gcash - total;
            System.out.print("CHANGE: "+change+"\n");
         LocalDate currdate = LocalDate.now();
         DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
         date = currdate.format(format);
       String nowmonth = currdate.getMonth().toString();
         
         
         
           status = (total<=gcash)? "COMPLETED":"PENDING";
           
           String ordersql = "INSERT INTO PROCESS_DETAILS (c_id, p_id , t_quantity , t_totalam , t_cash , t_change , t_status , t_date, t_month ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
           conf.addRecord(ordersql,id, pid,quantity, total, gcash, change, status, date, nowmonth );
        
        
           
           
          System.out.print("\nWould you like to input another(Yes|No): ");
    another = in.nextLine();
    
    while(!another.equalsIgnoreCase("yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("Yes") &&
            !another.equalsIgnoreCase("No") && !another.equalsIgnoreCase("no") && !another.equalsIgnoreCase("NO") ){
     
        another=in.nextLine();
        
        
    }
    
 }while(another.equals("yes") || another.equals("YES") || another.equals("Yes"));
           
        
}
    
public void viewprocess() {
    config conf = new config();
    Scanner in = new Scanner(System.in);
    String choice = null;
    int date = 0;

    System.out.println("||VIEW SALES ORDERS||");
    System.out.println("1. VIEW ALL SALES");
    System.out.println("2. VIEW SALES BY MONTH(UPPERCASE): ");

    // Loop to ensure valid user input
    while(true){
        
        System.out.print("Enter choice: ");
        choice = in.nextLine().trim();
        
        try{
            
            date = Integer.parseInt(choice);
            if(date==1 || date==2){
                
                break;
                
            }
            else{
                
                System.out.println("Invalid Number Input");
            }
        }
        catch(NumberFormatException e){
            
            System.out.println("Invalid Input");
        }
    }
    // Switch to handle logic based on user choice
    switch (date) {
        case 1:
            
            String sql = "SELECT t_id, c_fname, c_lname, p_name, t_totalam, t_status, t_date, t_month FROM PROCESS_DETAILS "
                    + "LEFT JOIN CUSTOMER_DETAILS ON CUSTOMER_DETAILS.c_id = PROCESS_DETAILS.c_id "
                    + "LEFT JOIN PRODUCT_DETAILS ON PRODUCT_DETAILS.p_id = PROCESS_DETAILS.p_id";
            String[] header = {"PROCESS ID", "CUSTOMER FIRST NAME", "CUSTOMER LASTNAME", "PRODUCT NAME", "TOTAL AMOUNT", "STATUS", "DATE", "MONTH"};
            String[] columns = {"t_id", "c_fname", "c_lname", "p_name", "t_totalam", "t_status", "t_date", "t_month"};
            conf.viewRecords(sql, header, columns);  
            break;

        case 2:
            // Case 2: View sales by month
            System.out.print("Enter the month (e.g., JANUARY, FEBRUARY, etc.): ");
            String month = in.nextLine().toUpperCase();  // Convert input to uppercase for consistency

            // Check if the entered month is valid
            if (isValidMonth(month)) {
                // Proceed with viewing records for the selected month

                // Dynamically create the SQL query for the selected month
                String monthSql = "SELECT t_id, c_fname, c_lname, p_name, t_totalam, t_status, t_date, t_month "
                        + "FROM PROCESS_DETAILS "
                        + "LEFT JOIN CUSTOMER_DETAILS ON CUSTOMER_DETAILS.c_id = PROCESS_DETAILS.c_id "
                        + "LEFT JOIN PRODUCT_DETAILS ON PRODUCT_DETAILS.p_id = PROCESS_DETAILS.p_id "
                        + "WHERE t_month = '" + month + "'";  // Inject month directly into the SQL query

                // Define the headers and columns for the month-specific view
                String[] monthHeader = {"PROCESS ID", "CUSTOMER FIRST NAME", "CUSTOMER LASTNAME", "PRODUCT NAME", "TOTAL AMOUNT", "STATUS", "DATE", "MONTH"};
                String[] monthColumns = {"t_id", "c_fname", "c_lname", "p_name", "t_totalam", "t_status", "t_date", "t_month"};

                // Call the existing viewRecords method with the dynamically created SQL query
                conf.viewRecords(monthSql, monthHeader, monthColumns);
            } else {
                System.out.println("Invalid month entered. Please enter a valid month (e.g., JANUARY).");
            }
            break;
    }
}


// Helper method to validate the month input (uppercase string)
private boolean isValidMonth(String month) {
    String[] validMonths = {
        "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", 
        "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"
    };

    // Check if the month is in the list of valid months
    for (String validMonth : validMonths) {
        if (validMonth.equals(month)) {
            return true;  // Month is valid
        }
    }
    return false;  // Invalid month
}

    public void deleteprocess(){
        config conf = new config();
        Scanner in = new Scanner(System.in);
          SALES view = new SALES();
          String another = null;
          String idcus =null;
          int id =0;
          
          do{
          view.viewprocess();
              System.out.println("||DELETE PROCESS||");
              
           while (true) {
            System.out.print("Enter the ID of the Sales you want to delete: ");
            String customerInput = in.nextLine().trim();

            try {
                id = Integer.parseInt(customerInput);
                if (id >= 0) {
                    
                    if (conf.getSingleValue("SELECT t_id FROM PROCESS_DETAILS WHERE t_id = ?",id) != 0) {
                        break; 
                    } else {
                        System.out.println("ID doesn't exist. Try Again.");
                    }
                } else {
                    System.out.println("Number Invalid Input");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please enter a valid number.");
            }
        }
           
 String deleteSQL = "DELETE FROM PROCESS_DETAILS WHERE t_id = ?";
          
          conf.deleteRecord(deleteSQL, id);
            
             
             
              
    
     
          System.out.print("\nWould you like to input another(Yes|No): ");
    another = in.nextLine();
    
    while(!another.equalsIgnoreCase("yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("Yes") &&
            !another.equalsIgnoreCase("No") && !another.equalsIgnoreCase("no") && !another.equalsIgnoreCase("NO") ){
        
        another=in.nextLine();
        
        
    }

          }while(another.equals("YES") || another.equals("Yes")|| another.equals("yes"));
          
        
    }
   
    
    
}