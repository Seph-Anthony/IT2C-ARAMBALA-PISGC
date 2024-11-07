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
public class REPORTS {
    
    public void reportinfo(){
        Scanner in = new Scanner (System.in);
        String another = null;
        SALES sal = new SALES();
        config conf = new config();
        int id = 0;
        
        do{
            sal.viewprocess();
            
            while (true) {
            System.out.print("Enter the ID of the Customer: ");
            String customerInput = in.nextLine().trim();

            try {
                id = Integer.parseInt(customerInput);
                if (id >= 0) {
                    
                    if (conf.getSingleValue("SELECT t_id FROM PROCESS_DETAILS WHERE t_id = ?", id) != 0) {
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
            
            
                      System.out.print("\nWould you like to input another(Yes|No): ");
    another = in.nextLine();
    
    while(!another.equalsIgnoreCase("yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("Yes") &&
            !another.equalsIgnoreCase("No") && !another.equalsIgnoreCase("no") && !another.equalsIgnoreCase("NO") ){
        
        another=in.nextLine();
        
        
    }
        }while(another.equals("YES") || another.equals("Yes")|| another.equals("yes"));
        
        
        
        
        
        
        
    }
    
    
}
