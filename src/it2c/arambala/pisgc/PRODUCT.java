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
public class PRODUCT {
    
    public void infoproduct(){
        
         Scanner in = new Scanner (System.in);
        IT2CARAMBALAPISGC done = new IT2CARAMBALAPISGC();
        String another = null;
        String input = null;
        int action = 0;
PRODUCT prod = new PRODUCT();
        
        do{
            
        System.out.println("||PRODUCT||");
        System.out.println("|1. ADD PRODUCT \t|");
        System.out.println("|2. VIEW PRODUCT \t|");
        System.out.println("|3. UPDATE PRODUCT\t|");
        System.out.println("|4. DELETE PRODUCT\t|");
        System.out.println("|5. BACK         \t|");
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
               
                        prod.addprod();
                        
                        
                break;
                
                
            case 2: 
              
                 
                      prod.viewprod();
                
                
            
                break;
                
            case 3:
                

                
                  
                      prod.updateprod();
                  
                break;
                
            case 4:
                
              
         
                
                  
                
               
                prod.deleteprod();
            
                break;
                
            case 5:
                
  
                 done.main(new String[]{});
         
                
                break;
            
        }
        
        System.out.print("\nINPUT ANOTHER TRANSACTION FOR PRODUCT (Yes|No):");
        another = in.nextLine();
        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
            
        }
        } while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
        
        
        System.out.println("Thank you for using\n");   
        
    }
    
     public void addprod(){
        Scanner in = new Scanner(System.in);
        config conf = new config();
String status = null;
        String another = null;
        String name;
   double price = 0;
   int stock = 0;
   String num = null;
   int prod = 0;
        do{
        
            
            
           while(true){
               
           
            System.out.print("Enter Number of Products to be Add: ");
           num = in.nextLine().trim();
           
           try{
               prod = Integer.parseInt(num);
               
               if(prod >= 0){
                   
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
      
     
            for(int i = 0; i<prod; i++){
            
        while(true){
        System.out.printf("%d. PRODUCT NAME: ",i+1);
         name = in.nextLine().trim();
      
        if(!name.equals("")){
           if(name.matches("^[a-z A-Z]+$")){
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
     



while (true) {
    System.out.printf("%d. PRODUCT PRICE: ",i+1);
String priceinput = in.nextLine().trim();
    
try{
    price = Double.parseDouble(priceinput);
    if(price >= 0){
        break;
    }
    
    else {
        
        System.out.println("Product Price should not be a negative: ");
    }
    
    
}
catch (NumberFormatException e){
    System.out.println("Product Price Invalid");
    
}
    
    
   
    
}


while(true){
      System.out.printf("%d. PRODUCT STOCK: ",i+1);
      String stockinput = in.nextLine().trim();
      try {
          stock = Integer.parseInt(stockinput);
          if(stock >=0){
              
              break;
          }
          else {
              
              System.out.println("Product Stock should not be a negative: ");
          }
          
      }
      
      catch (NumberFormatException e){
          System.out.println("Product Stock Invalid");
          
      }
      
}


      status = (stock == 0)  ?"NOT AVAILABLE":"AVAILABLE";
        
      
        String sql = "INSERT INTO PRODUCT_DETAILS ( p_name, p_price, p_stock, p_status) VALUES (?, ?, ?, ?)";

        
        conf.addRecord(sql, name, price, stock, status);
        
            }
        
         System.out.print("\nINPUT ANOTHER PRODUCT (Yes|No):");
        another = in.nextLine();
        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
        
        
        }
        
        }while (another.equals("yes") || another.equals("Yes") || another.equals("YES"));
        
        
     } 
    
        
        
     
         public void deleteprod(){
          Scanner in = new Scanner(System.in);
          config del = new config();
          PRODUCT prod = new PRODUCT();
          String another = null;
          String idinput = null;
          int id = 0;
          do{
                 prod.viewprod();
          System.out.println("||DELETE PRODUCT||");
          
while (true) {
            System.out.print("Enter the ID of the Customer to Delete: ");
            String customerInput = in.nextLine().trim();

            try {
                id = Integer.parseInt(customerInput);
                if (id >= 0) {
                    
                    if (del.getSingleValue("SELECT p_id FROM PRODUCT_DETAILS WHERE p_id = ?", id) != 0) {
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

        
          String deleteSQL = "DELETE FROM PRODUCT_DETAILS WHERE p_id = ?";
          
          del.deleteRecord(deleteSQL, id);
          
          
          System.out.print("\nDELETE ANOTHER PRODUCT (Yes|No):");
        another = in.nextLine();
        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" \n Again: ");
            another=in.nextLine();
          
         }
      }while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
      
         }
      public void viewprod(){
    
      config conf = new config();
    String test = "SELECT * FROM PRODUCT_DETAILS";
                String[] headers = {"ID", "NAME", "PRICE", "STOCK", "STATUS"};
                String[] Columns = {"p_id", "p_name", "p_price", "p_stock","p_status"};

                String updatesql = "UPDATE PRODUCT_DETAILS SET p_status = 'NOT AVAILABLE' WHERE p_stock = 0";
                
                
                conf.updateRecord(updatesql);
    conf.viewRecords(test, headers, Columns);
    
}
      public void updateprod(){
       Scanner in = new Scanner (System.in);
               config conf = new config();
PRODUCT prod = new PRODUCT();
String status = null;
  String another  = null;
   double price = 0;
     int stock = 0;
     String name = null;
     String input = null;
  int action = 0;  
  String idinput = null;
  int id = 0;

  
       do {
               prod.viewprod();
               while (true) {
            System.out.print("Enter the ID of the Customer to Update: ");
            String customerInput = in.nextLine().trim();

            try {
                id = Integer.parseInt(customerInput);
                if (id >= 0) {
                    
                    if (conf.getSingleValue("SELECT p_id FROM PRODUCT_DETAILS WHERE p_id = ?", id) != 0) {
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

          System.out.println("INPUT UPDATE");
          System.out.println("____________");
          System.out.println("1. NEW PRODUCT NAME");
          System.out.println("2. NEW PRODUCT PRICE");
          System.out.println("3. NEW PRODUCT STOCK");
                 while (true){
          System.out.print("Enter action: ");
        input = in.nextLine().trim();
          
          
           
            try{
                
                action = Integer.parseInt(input);
                if(action>=1 && action <=3){
                    
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
                     config nameconfi = new config();
                     
                     while(true){
                System.out.print("Enter the new product name: ");
                 name = in.nextLine().trim();
                  if(!name.equals("")){
           if(name.matches("^[a-z A-Z]+$")){
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
                     
                     
                String namesql = "UPDATE PRODUCT_DETAILS SET p_name = ? WHERE p_id = ?";
                nameconfi.updateRecord(namesql, name, id);
                
                      prod.viewprod();

                
                break;
                
            case 2:
                
                config priceconfi = new config();
                while (true){
                System.out.print("Enter the new product price: ");
               String stockinput = in.nextLine().trim();
                  try {
          stock = Integer.parseInt(stockinput);
          if(stock >= 0){
              
              break;
          }
          else {
              
              System.out.println("Product Price should not be a negative: ");
          }
          
      }
      
      catch (NumberFormatException e){
          System.out.println("Product Price Invalid");
          
      }
      
               
                }
                 
                 
                String pricesql = "UPDATE PRODUCT_DETAILS SET p_price = ? WHERE p_id = ?";
                priceconfi.updateRecord(pricesql, price, id);
                prod.viewprod();
                break;
                
            case 3: 
                 config stockconfi = new config();
                 
                 while(true){
                System.out.print("Enter the new product stock: ");
              String stockinput = in.nextLine().trim();
               try {
          stock = Integer.parseInt(stockinput);
          if(stock >= 0){
              
              break;
          }
          else {
              
              System.out.println("Product Stock should not be a negative: ");
          }
          
      }
      
      catch (NumberFormatException e){
          System.out.println("Product Stock Invalid");
          
      }
                 }
         status = (stock == 0)  ?"NOT AVAILABLE":"AVAILABLE";
                 
//                 
//                   String updatestock = "UPDATE PRODUCT_DETAILS SET p_status = 'NOT AVAILABLE' WHERE p_stock = 0";
                
                      
                
                 
                String stocksql = "UPDATE PRODUCT_DETAILS SET p_stock = ?, p_status = ? WHERE p_id = ?";
                stockconfi.updateRecord(stocksql, stock, status, id);
                        prod.viewprod();
                break;
                  
           
                
        }
        
        System.out.print("\nUPDATE ANOTHER PRODUCT (Yes|No):");
        another = in.nextLine();
        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" \n ENTER: ");
            another=in.nextLine();
            
        }
        } while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
        
                
                
                
              
              
          }
     
     
      
    
    
}
