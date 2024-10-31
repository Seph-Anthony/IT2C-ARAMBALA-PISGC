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
        System.out.println("|3. DELETE SALES||");
        System.out.println("___________________________");
        while(true){
            System.out.print("INPUT: ");
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
        
        
        switch(action){
            
            case 1:
                
                sal.addprocess();
                
                break;
                
            case 2:
                sal.viewprocess();
                
                break;
                
            case 3:
                
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
int cusid = 0;
 
  System.out.println("|| SELECT CUSTOMER ID ||");
        
 cus.viewcustomer();
 
 
        System.out.print("Enter the ID of the Customer: ");

         
          while(!in.hasNextInt()){
            System.out.println("Character is Invalid: ");
            System.out.print("Enter an ID Again: ");
            in.nextLine();
            
        }
         cusid = in.nextInt();
        in.nextLine();
            
            while(conf.getSingleValue("SELECT t_id FROM PROCESS_DETAILS WHERE t_id = ? ", cusid) == 0){
            
            System.out.print("ID doesn't exist \n Try Again: ");
            cusid = in.nextInt();
            
        }
        
         
         
         
         
 
 
        
        
        
}
    
    public void viewprocess(){
        
        
        
    }
}