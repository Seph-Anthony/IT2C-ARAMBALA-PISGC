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
        
        String another = null;
        
PRODUCT prod = new PRODUCT();
        
        do{
            
        System.out.println("CONVINIENCE: PRODUCT INVENTORY || SALES GENERATION ");
        System.out.println("|1. ADD PRODUCT \t|");
        System.out.println("|2. VIEW PRODUCT \t|");
        System.out.println("|3. UPDATE PRODUCT\t|");
        System.out.println("|4. DELETE PRODUCT\t|");
        System.out.println("|5. EXIT PRODUCT\t|");
        System.out.println("___________________________");
        System.out.print("Enter Action: ");
        
        while(!in.hasNextInt()){
            System.out.println("Character is Invalid: ");
            System.out.print("Enter a choice: ");
            in.nextLine();
            
        }
        int action = in.nextInt();
        in.nextLine();
        while (action>5){
            System.out.print("!!SELECTION INVALID!\n TRY AGAIN: ");
             action = in.nextInt();
            
        }
        
        
        switch (action){
            
            case 1:
               
                        prod.addprod();
                        
                        
                break;
                
                
            case 2: 
              
                 
                      prod.viewprod();
                
                
            
                break;
                
            case 3:
                
//                System.out.println("||WELCOME TO UPDATE PRODUCT||");
                
                     prod.viewprod();
                      prod.updateprod();
                  
                break;
                
            case 4:
                
              
                  prod.viewprod();
                
                  
                
               
                prod.deleteprod();
            
                break;
                
            case 5:
                
    
                 
         
                
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

        String another = null;
        String name;
   double price = 0;
   int stock = 0;
        do{
        
            
            
           
            System.out.print("Enter Number of Products to be Add: ");
            int prod = in.nextInt();
            
            in.nextLine();
            
            for(int i = 0; i<prod; i++){
            
        while(true){
        System.out.print("PRODUCT NAME: ");
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
     

//        
//        if (!password.matches(".*\\d.*")) {
//            System.out.println("Password must have a number");
//            return false;

//while(!in.hasNextInt()){
//            System.out.println("Character is Invalid: ");
//            System.out.print("Enter a choice: ");
//            in.nextLine();
//            
//        }
//  int action = in.nextInt();


while (true) {
    System.out.print("PRODUCT PRICE: ");
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
      System.out.print("PRODUCT STOCK: ");
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


      
        
      
        String sql = "INSERT INTO PRODUCT_DETAILS ( NAME, PRICE, STOCK) VALUES (?, ?, ?)";

        
        conf.addRecord(sql, name, price, stock);
        
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
          
          String another = null;
          do{
          System.out.println("||DELETE PRODUCT||");
          
          System.out.print("Enter the ID you want to delete: ");
        
          
           while(!in.hasNextInt()){
            System.out.println("Character is Invalid: ");
            System.out.print("Enter an ID again: ");
            in.nextLine();
            
        }
        int id = in.nextInt();
        in.nextLine();
          
          String deleteSQL = "DELETE FROM PRODUCT_DETAILS WHERE ID = ?";
          
          del.deleteRecord(deleteSQL, id);
          
          
          System.out.print("\nDELETE ANOTHER PRODUCT (Yes|No):");
        another = in.nextLine();
        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
          
         }
      }while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
      
         }
      public void viewprod(){
    
      config conf = new config();
    String test = "SELECT * FROM PRODUCT_DETAILS";
                String[] headers = {"ID", "NAME", "PRICE", "STOCK"};
                String[] Columns = {"ID", "NAME", "PRICE", "STOCK"};

    conf.viewRecords(test, headers, Columns);
    
}
      public void updateprod(){
       Scanner in = new Scanner (System.in);
               
PRODUCT prod = new PRODUCT();
  String another  = null;
   double price = 0;
     double stock = 0;
     String name = null;
  
       do {
               prod.viewprod();
          System.out.print("Enter the ID you want to Update: ");
          int id = in.nextInt();
          
          System.out.println("INPUT UPDATE");
          System.out.println("____________");
          System.out.println("1. NEW PRODUCT NAME");
          System.out.println("2. NEW PRODUCT PRICE");
          System.out.println("3. NEW PRODUCT STOCK");
                 
          System.out.print("Enter action: ");
        
      
                    while(!in.hasNextInt()){
            System.out.println("Character is Invalid: ");
            System.out.print("Enter a choice: ");
            in.nextLine();
            
        }
        int action = in.nextInt();
        in.nextLine();
        while (action>4){
            System.out.print("!!SELECTION INVALID!\n TRY AGAIN: ");
             action = in.nextInt();
            
        }
        switch (action){
            
  
            case 1:
                     config nameconfi = new config();
                     
                     while(true){
                System.out.print("Enter the new product name: ");
                 name = in.nextLine();
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
                String namesql = "UPDATE PRODUCT_DETAILS SET NAME = ? WHERE ID = ?";
                nameconfi.updateRecord(namesql, name, id);
                
                     
//        while(true){
//        System.out.print("PRODUCT NAME: ");
//         name = in.nextLine().trim();
//      
//        if(!name.equals("")){
//           if(name.matches("^[a-z A-Z]+$")){
//           break;
//        }
//        else {
//            System.out.println("Product name should only contain characters");
//        }
//        }
//        else{
//            System.out.println("Product name cannot be empty. ");
//        }
//        }
     
                
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
              
              System.out.println("Product Stock should not be a negative: ");
          }
          
      }
      
      catch (NumberFormatException e){
          System.out.println("Product Stock Invalid");
          
      }
      
               
                }
                       
                
                String pricesql = "UPDATE PRODUCT_DETAILS SET PRICE = ? WHERE ID = ?";
                priceconfi.updateRecord(pricesql, price, id);
                
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
                
                String stocksql = "UPDATE PRODUCT_DETAILS SET STOCK = ? WHERE ID = ?";
                stockconfi.updateRecord(stocksql, stock, id);
                
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
