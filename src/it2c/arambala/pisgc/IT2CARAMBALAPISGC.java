
package it2c.arambala.pisgc;

import java.util.Scanner;


public class IT2CARAMBALAPISGC {

  
  

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        String another = null;
        
IT2CARAMBALAPISGC prod = new IT2CARAMBALAPISGC();
        
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
                System.out.println("Program exiting. . .");
                System.exit(0);
                break;
            
        }
        
        System.out.print("INPUT ANOTHER TRANSACTION (Yes|No):");
        another = in.nextLine();
        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
            
        }
        } while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
        
        
        System.out.println("Thank you for using");
    
}
    
      public void addprod(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("PRODUCT NAME: ");
        String name = sc.next();
        System.out.print("PRODUCT PRICE: ");
        String price = sc.next();
        System.out.print("PRODUCT STOCK: ");
        String stock = sc.next();
        System.out.print("PRODUCT SOLD: ");
        String sold = sc.next();
       
        
      
        String sql = "INSERT INTO PRODUCT_DETAILS ( NAME, PRICE, STOCK, SOLD) VALUES (?, ?, ?, ?)";

        
        conf.addRecord(sql, name, price, stock, sold);
        
    
    }
      
      public void deleteprod(){
          Scanner in = new Scanner(System.in);
          config del = new config();
          
          System.out.println("||DELETE PRODUCT||");
          
          System.out.print("Enter the ID you want to delete: ");
          String id = in.next();
          String deleteSQL = "DELETE FROM PRODUCT_DETAILS WHERE ID = ?";
          
          del.deleteRecord(deleteSQL, id);
      }
      
      public void viewprod(){
    
      config conf = new config();
    String test = "SELECT * FROM PRODUCT_DETAILS";
                String[] headers = {"ID", "NAME", "PRICE", "SOLD", "STOCK"};
                String[] Columns = {"ID", "NAME", "PRICE", "SOLD", "STOCK"};

    conf.viewRecords(test, headers, Columns);
    
}
      public void updateprod(){
       Scanner in = new Scanner (System.in);
       
  String another  = null;
  
  
       do {
          System.out.print("Enter the ID you want to Update: ");
          int id = in.nextInt();
          
          System.out.println("INPUT UPDATE");
          System.out.println("____________");
          System.out.println("1. NEW PRODUCT NAME");
          System.out.println("2. NEW PRODUCT PRICE");
          System.out.println("3. NEW PRODUCT STOCK");
          System.out.println("4. NEW PRODUCT SOLD");
         
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
                System.out.print("Enter the new product name: ");
                String name = in.next();
                
                String namesql = "UPDATE PRODUCT_DETAILS SET NAME = ? WHERE ID = ?";
                nameconfi.updateRecord(namesql, name, id);
                
                
                break;
                
            case 2:
                
                config priceconfi = new config();
                System.out.print("Enter the new product price: ");
                Double price = in.nextDouble();
                
                String pricesql = "UPDATE PRODUCT_DETAILS SET PRICE = ? WHERE ID = ?";
                priceconfi.updateRecord(pricesql, price, id);
                
                break;
                
            case 3: 
                 config stockconfi = new config();
                System.out.print("Enter the new product stock: ");
                Double stock = in.nextDouble();
                
                String stocksql = "UPDATE PRODUCT_DETAILS SET STOCK = ? WHERE ID = ?";
                stockconfi.updateRecord(stocksql, stock, id);
                
                break;
                  
            case 4:
                config soldconfi = new config();
                System.out.print("Enter the new product sold: ");
                Double sold = in.nextDouble();
                
                String soldsql = "UPDATE PRODUCT_DETAILS SET SOLD = ? WHERE ID = ?";
                soldconfi.updateRecord(soldsql, sold, id);
                
                break;
                
        }
        System.out.print("UPDATE ANOTHER PRODUCT (Yes|No):");
        another = in.nextLine();
        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" \n ENTER: ");
            another=in.nextLine();
            
        }
        } while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
        
                
                
                
              
              
          }
          
          
          
      }


  
