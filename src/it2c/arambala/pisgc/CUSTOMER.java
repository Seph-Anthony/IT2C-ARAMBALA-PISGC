 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it2c.arambala.pisgc;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CUSTOMER {
    
    public void infocustomer(){
        IT2CARAMBALAPISGC done = new IT2CARAMBALAPISGC();
        Scanner in = new Scanner (System.in);
        CUSTOMER custom = new CUSTOMER();
        String another = null;
        String input = null;
        int action = 0;
        do{
          System.out.println("||CUSTOMER||");
        System.out.println("|1. ADD CUSTOMER \t|");
        System.out.println("|2. VIEW CUSTOMER \t|");
        System.out.println("|3. UPDATE CUSTOMER\t|");
        System.out.println("|4. DELETE CUSTOMER\t|");
        System.out.println("|5. BACK \t\t|");
        System.out.println("___________________________");
     while(true){
            System.out.print("INPUT: ");
             input = in.nextLine().trim();
           
                
              
            
                
                
            
            
            try{
                
                action = Integer.parseInt(input);
                if(action>=1 && action <=5){
                    
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
         switch (action){
            
            case 1:
               custom.addcustomer();
                        
                break;
                
                
            case 2: 
              
                 custom.viewcustomer();
                
                
                
            
                break;
                
            case 3:
                
custom.viewcustomer();
custom.updatecustomer();
                break;
                
            case 4:
                
              
                custom.deletecustomer();
            
                break;
                
            case 5:
                
 done.main(new String[] {});
                
             
         
                
                break;
            
        }
         
           System.out.print("Would you like to Input Another Customer Transactions(Yes|No): ");
            another = in.nextLine();
             while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
        }
         
        }while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
        
        
        
    }
    
    public void addcustomer(){
        Scanner in = new Scanner (System.in);
        config conf = new config();
        
        String another = null;
        String fname = null;
        String lname = null;
        String email = null;
        String contact =null;
        String number = null;
         int cus = 0;
        System.out.println("||ADD CUSTOMER||");
        
        do{
        
            while(true){
            System.out.print("Enter the number of customers: ");
          number = in.nextLine().trim();
          
          try{
              cus = Integer.parseInt(number);
              if(cus>=0){
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
       
    
            for(int i = 0; i<cus; i++){
                while(true){
                System.out.printf("%d. CUSTOMER FIRST NAME: ",i+1);
                fname = in.nextLine().trim();
                
                if(!fname.equals("")){
                    if(fname.matches("^[a-z A-Z]+$")){
                        break;
                    }
                    else {
                        System.out.println("Customer First Name Should Only Contain Characters");
                        
                    }
                    
                }
                else {
                    System.out.println("Customer First Name Cannot Be Empty");
                }
                
                }
                 
                    while(true){
                System.out.printf("%d.CUSTOMER LAST NAME: ",i+1);
                lname = in.nextLine().trim();
                
                if(!lname.equals("")){
                    if(lname.matches("^[a-z A-Z]+$")){
                        break;
                    }
                    else {
                        System.out.println("Customer Last Name SHould Only Contain Characters");
                        
                    }
                    
                }
                else {
                    System.out.println("Customer Last Name Cannot Be Empty");
                }
                
                }
                    while(true){
                 
                     System.out.printf("%d. CUSTOMER EMAIL: ", i + 1);
    email = in.nextLine().trim();
    
   
    if (!email.equals("")) {
       
        if (email.toLowerCase().endsWith("@gmail.com")) {
            break; 
        } else {
            System.out.println("Email must end with @gmail.com. Please enter your email again.");
        }
    } else {
        System.out.println("Email cannot be empty.");
    }
                    }
                    
                    
                   
                    while(true){
                    System.out.printf("%d. CUSTOMER CONTACT NO: ",i+1);
                    contact=in.nextLine().trim();
                    
                    if(!contact.equals("")){
                    if(contact.matches("\\d+" )){
    break;
    
}
                    
                    else {
                        System.out.println("Should only contain numberic values");   
                    }
                    
                    }
                    
                    else {
                        
                        System.out.println("Contact No. Invalid");
                    }
  
                    }
            }
            String sql = "INSERT INTO CUSTOMER_DETAILS (c_fname, c_lname, c_email, c_contact) VALUES (?, ?, ?, ?)";
         conf.addRecord(sql, fname, lname, email, contact);
            
            System.out.println("ADD ANOTHER CUSTOMER(Yes|No)?");
            another = in.nextLine();
             while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
        }
        
    }while (another.equals("yes") || another.equals("Yes") || another.equals("YES"));
            
    
}
    
    public void viewcustomer(){
        config conf = new config();
        Scanner in = new Scanner(System.in);
        System.out.println("||VIEW CUSTOMER||");

        
        String sql = "SELECT * FROM CUSTOMER_DETAILS";
        String[] header = {"CUSTOMER ID","CUSTOMER FIRST NAME","CUSTOMER LAST NAME","CUSTOMER EMAIL","CUSTOMER CONTACT NO."};
        String[] colom = {"c_id","c_fname", "c_lname", "c_email", "c_contact"};
        
        
conf.viewRecords(sql, header, colom);
}
    
    public void updatecustomer(){
        Scanner in = new Scanner (System.in);
        config conf = new config();
        String fname = null;
        String lname = null;
        String email = null;
        String contact = null;
        String another = null;
        String customerinput = null;
        int action = 0;
        int customerId = 0;
        
        do{
            
           while (true) {
            System.out.print("Enter the ID of the Customer to Update: ");
            String customerInput = in.nextLine().trim();

            try {
                customerId = Integer.parseInt(customerInput);
                if (customerId >= 0) {
                    
                    if (conf.getSingleValue("SELECT c_id FROM CUSTOMER_DETAILS WHERE c_id = ?", customerId) != 0) {
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

      
   
        
   
        while(true){
                System.out.print("Enter the new First Name: ");
                 fname = in.nextLine().trim();
                  if(!fname.equals("")){
           if(fname.matches("^[a-z A-Z]+$")){
           break;
        }
        else {
            System.out.println("Product name should only contain characters");
        }
        }
        else{
            System.out.println("Product name cannot be empty. ");
        }
                
                     }
        while(true){
                System.out.print("Enter the new Last Name: ");
                 lname = in.nextLine().trim();
                  if(!lname.equals("")){
           if(lname.matches("^[a-z A-Z]+$")){
           break;
        }
        else {
            System.out.println("Product name should only contain characters");
        }
        }
        else{
            System.out.println("Product name cannot be empty. ");
        }
                
                     }
        
   while(true){
                 
                     System.out.printf("Enter the New Customer Email: ");
    email = in.nextLine().trim();
    
   
    if (!email.equals("")) {
        
        if (email.toLowerCase().endsWith("@gmail.com")) {
            break;
        } else {
            System.out.println("Email must end with @gmail.com. Please enter your email again.");
        }
    } else {
        System.out.println("Email cannot be empty.");
    }
                    }
        
               while(true){
                    System.out.printf("Enter the new Customer Contact No: ");
                    contact=in.nextLine().trim();
                    
                    if(!contact.equals("")){
                    if(contact.matches("\\d+")){
    break;
    
}
                    else {
                        System.out.println("Should only contain numberic values");   
                    }
                    
                    }
                    
                    else {
                        
                        System.out.println("Contact No. Invalid");
                    }
  
                    }
               
               String sql ="UPDATE CUSTOMER_DETAILS SET c_fname = ?, c_lname = ?, c_email = ?, c_contact = ? WHERE c_id = ?";
        conf.updateRecord(sql, fname, lname, email, contact, action);
        
        
         System.out.print("\nUPDATE ANOTHER CUSTOMER (Yes|No):");
        another = in.nextLine();
        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" \n ENTER: ");
            another=in.nextLine();
            
        }
        
        }while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
    }
    
    public void deletecustomer(){
        Scanner in =new Scanner (System.in);
        config conf = new config();
        CUSTOMER custom = new CUSTOMER();
        String another = null;
        String delete = null;
        int id = 0;
        
        
      
        
        System.out.println("||DELETE CUSTOMER||");
        do{
            custom.viewcustomer();
          
             while (true) {
            System.out.print("Enter the ID of the Customer to Delete: ");
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
         
         
               String deleteSQL = "DELETE FROM CUSTOMER_DETAILS WHERE c_id = ?";
          
          conf.deleteRecord(deleteSQL, id);
            
            
            
              System.out.print("\nDELETE ANOTHER CUSTOMER (Yes|No):");
        another = in.nextLine();
            
             while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" \n ENTER: ");
            another=in.nextLine();
            
        }
            
        }while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
        
        
    }
}