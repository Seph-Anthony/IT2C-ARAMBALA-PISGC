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
        
    SALES sal = new SALES();
        Scanner in = new Scanner(System.in);
        String another = null;
        String input = null;
        int action = 0;
        
        do{
        System.out.println("___________________________");
        System.out.println("||SALES ORDER\t||");
        System.out.println("|1. ADD SALES\t||");
        System.out.println("|2. VIEW SALES\t||");
        System.out.println("|3. UPDATE SALES||");
        System.out.println("|4. DELETE SALES||");
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
                
                break;
                
            case 4:
                
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
 String priceqry = null, stockqry = null, quantityqry = null, updatesql = null;
  System.out.println("|| SELECT CUSTOMER ID ||");
   
 cus.viewcustomer();
 
 while(true){
        System.out.print("Enter the ID of the Customer: ");
           idcus = in.nextLine().trim();
           
           try{
               id = Integer.parseInt(idcus);
               
               if(id>=0){
                   break;
                   
               }
               
               else{
                   System.out.println("Number Input is Invalid"); 
                   
               }
               
               
           }
           catch(NumberFormatException e){
               System.out.println("Invalid Input");
               
           }
  
        
        
 }
        
            
            while(conf.getSingleValue("SELECT c_id FROM CUSTOMER_DETAILS WHERE c_id = ? ", id) == 0){
            
                
                
            System.out.print("ID doesn't exist \n Try Again: ");
            cusid = in.nextInt();
            in.nextLine();
            
        }
            
            System.out.println("|| SELECT PRODUCT ID ||");
            prod.viewprod();
            
            System.out.print("Enter the ID of the Product: ");
           pid = in.nextInt();
           
              stockqry = "SELECT STOCK FROM PRODUCT_DETAILS WHERE ID = ?";
            stock = conf.getSingleValue(stockqry, pid);
           
            while(stock == 0 ){
                
                System.out.print("PRODUCT STOCK NOT AVAILABLE \n Try Again: ");
                pid=in.nextInt();
                stock = conf.getSingleValue(stockqry, pid);
            }
           
            
     
            
             while(conf.getSingleValue("SELECT ID FROM PRODUCT_DETAILS WHERE ID = ? ", pid) == 0){
            
                
                
            System.out.print("ID doesn't exist \n Try Again: ");
            cusid = in.nextInt();
            
        }
             
              
             while(true){
             System.out.print("Enter the quantity of the Product: ");
             quantity = in.nextDouble();
            
               if (quantity > stock) {
            System.out.print("PRODUCT QUANTITY EXCEEDS THE PRODUCT STOCK QUANTITY  \n");
        } else {
            break; 
        }
             
             }
             
             updatequan = stock - quantity;
             
             updatesql = "UPDATE PRODUCT_DETAILS SET STOCK = ? WHERE ID = ?";
             updateconfi.updateRecord(updatesql, updatequan, pid);
             
//             String stocksql = "UPDATE PRODUCT_DETAILS SET STOCK = ?, STATUS = ? WHERE ID = ?";
//                stockconfi.updateRecord(stocksql, stock, id, status);
//             
             
             priceqry = "SELECT PRICE FROM PRODUCT_DETAILS WHERE ID = ?";
            price = conf.getSingleValue(priceqry, pid);
            total = price * quantity;
            
            System.out.println("\n________________________________");
            System.out.print("Total Amount: "+total);
            System.out.println("\n________________________________");
            
            System.out.print("\nEnter the Cash: ");
             gcash = in.nextDouble();
        
            while(gcash<total){
                
                System.out.print("Insufficient Cash Amount\n Try Again: ");
                gcash = in.nextDouble();
            }
         
            
            change = gcash - total;
            
         LocalDate currdate = LocalDate.now();
         DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
         date = currdate.format(format);
         
           status = (total<=gcash)? "COMPLETED":"PENDING";
           
           String ordersql = "INSERT INTO PROCESS_DETAILS (c_id, p_id , t_quantity , t_totalam , t_cash , t_change , t_status , t_date ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
           conf.addRecord(ordersql,id, pid,quantity, total, gcash, change, status, date );
        
        
        
}
    
    public void viewprocess(){
        
          config conf = new config();
        Scanner in = new Scanner(System.in);
        System.out.println("||VIEW SALES ORDERS||");
        
        String sql = "SELECT * FROM PROCESS_DETAILS";
     
    }
}