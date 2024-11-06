
package it2c.arambala.pisgc;

import java.util.Scanner;


public class IT2CARAMBALAPISGC {

  
  

    public static void main(String [] args) {
    Scanner in = new Scanner (System.in);
  PRODUCT inven = new PRODUCT();
  CUSTOMER cus = new CUSTOMER ();
  SALES sal = new SALES();
    String another = null;
   String input = null;
    int action = 0;
    boolean exit = true;
  
  do{
      
        System.out.println("****************************************************************|");
        System.out.println("PRODUCT INVENTORY TRANSACTION GENERATION (CONVENIENCE STORE)  \t|");
        System.out.println("****************************************************************|");
        System.out.println("|1. PRODUCT\t|                                               |");
        System.out.println("|2. CUSTOMER\t|                                               |");
        System.out.println("|3. SALES ORDER\t|                                               |");
        System.out.println("|4. EXIT\t|                                               |");
        System.out.println("----------------------------------------------------------------|");
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
        
        switch (action) {
            case 1:
                inven.infoproduct();
                break;
                
            case 2:
                   cus.infocustomer();
                    break;
                    
            case 3:
                sal.salesprocess();
                break;
                
                
            case 4:
                System.out.print(" DO YOU REALLY WISH TO EXIT(yes|no):  ");
                String choice=in.next();
                
                while(!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("Yes") && !choice.equalsIgnoreCase("YES") && !choice.equalsIgnoreCase("no") && !choice.equalsIgnoreCase("No") && !choice.equalsIgnoreCase("NO")){
                    System.out.print("Input Invalid\n Try again: ");
                    choice = in.next();
                    
                }
                
                if(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("YES")){
                    
                    
                
            exit = false;
                }
                break;
            
            
}
     
        
  }while (exit);
  
          
          
          
      }

}
//  git init
//git config --global user.name ""
//git config --global user.email ""
//git add . 
//git status
//copy remote link
//git commit -m "message"
//git push -u origin master
//
//git add .
//git commit -m ""
//git push