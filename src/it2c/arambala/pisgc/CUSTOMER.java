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
        System.out.println("|5. EXIT \t\t|");
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
                
              custom.viewcustomer();
                custom.deletecustomer();
            
                break;
                
            case 5:
                
 
                 
         
                
                break;
            
        }
         
           System.out.println("Would you like to Input Another Customer Transactions(Yes|No)?");
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
        
         
        System.out.println("||ADD CUSTOMER||");
        
        do{
        
            System.out.print("Enter the number of customers: ");
          
        while(!in.hasNextInt()){
            System.out.println("Character is Invalid: ");
            System.out.print("Enter an ID Again: ");
            in.nextLine();
            
        }
        int cus = in.nextInt();
        in.nextLine();
            
            for(int i = 0; i<cus; i++){
                while(true){
                System.out.printf("%d. CUSTOMER FIRST NAME: ",i+1);
                fname = in.nextLine().trim();
                
                if(!fname.equals("")){
                    if(fname.matches("^[a-z A-Z]+$")){
                        break;
                    }
                    else {
                        System.out.println("Customer First Name SHould Only Contain Characters");
                        
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
        
//        System.out.println("1. VIEW ONLY ID\t");
//        System.out.println("2. VIEW ONLY CUSTOMER NAME\t");
//        System.out.println("3. VIEW ONLY EMAIL");
//        System.out.println("4. VIEW ONLY CONTACT");
//        System.out.println("5. VIEW ALL");
//        System.out.println("Select choice: ");
//        while(!in.hasNextInt()){
//            System.out.print("!Character is Invalid!");
//            System.out.print("Enter again: ");
//            in.nextLine();
//        }
//        int choice = in.nextInt();
//        in.nextLine();
//        
//        switch(choice){
//        
//            case 1:
//        String sql ="SELECT c_id FROM CUSTOMER_DETAILS";
//        
//        String[] header = {"CUSTOMER ID"};
//        String[] colom = {"c_id"};
//        
//        conf.viewRecords(sql, header, colom);
//        break;
//        
//            case 2:
//                
//                String sql2 = "SELECT * FROM CUSTOMER_DETAILS";
//                String[] headerr = {"CUSTOMER FIRST NAME","CUSTOMER LAST NAME"};
//        String[] colomm = {"c_fname","c_fname"};
//        
//               conf.viewRecords(sql2, headerr, colomm);
//                break;
    
        
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
        
        do{
        System.out.print("Enter the ID of the Customer to Update: ");
                  while(!in.hasNextInt()){
            System.out.println("Character is Invalid: ");
            System.out.print("Enter an ID Again: ");
            in.nextLine();
            
        }
        int action = in.nextInt();
        in.nextLine();
      
        while(conf.getSingleValue("SELECT c_id FROM CUSTOMER_DETAILS WHERE c_id = ? ", action) == 0){
            
            System.out.print("ID doesn't exist \n Try Again: ");
            action = in.nextInt();
            
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
                 
                     System.out.printf(" Enter the New Customer Email: ");
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
        
        String another = null;
        int id = 0;
        
        System.out.println("||DELETE CUSTOMER||");
        do{
            System.out.print("Enter the ID of the Customer: ");
               while(!in.hasNextInt()){
            System.out.println("Character is Invalid: ");
            System.out.print("Enter an ID Again: ");
            in.nextLine();
            
        }
         id = in.nextInt();
         in.nextLine();
         
         while(conf.getSingleValue("SELECT c_id FROM CUSTOMER_DETAILS WHERE c_id = ? ", id)==0){
             System.out.println("ID doesn't exist\n Try Again: ");
             id=in.nextInt();
             
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