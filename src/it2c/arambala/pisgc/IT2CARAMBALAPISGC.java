
package it2c.arambala.pisgc;

import java.util.Scanner;


public class IT2CARAMBALAPISGC {

  
  

    public static void main(String [] args) {
    Scanner in = new Scanner (System.in);
  PRODUCT inven = new PRODUCT();
    String another = null;
    
    boolean exit = true;
  
  do{
      
  
        System.out.println("PRODUCT INVENTORY TRANSACTION GENERATION (CONVENIENCE STORE)");
        System.out.println("1. PRODUCT");
        System.out.println("2. CUSTOMER");
        System.out.println("3. TRANSACTIONS");
        System.out.println("4. EXIT");
        
        System.out.print("Enter a choice: ");
        
        
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
        
        switch (action) {
            case 1:
                inven.infoproduct();
                break;
                
            case 2:
                    
                    break;
                    
            case 3:
                
                break;
                
                
            case 4:
                System.out.println(" THANK YOU FOR USING ");
            exit = false;
                
                break;
            
            
}
     
        
  }while (exit);
  
          
          
          
      }

}
  
