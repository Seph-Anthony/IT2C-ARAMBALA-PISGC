
package it2c.arambala.pisgc;

import java.util.Scanner;


public class IT2CARAMBALAPISGC {

  
    public void addStudents(){
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


    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        String another = null;
        
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
                IT2CARAMBALAPISGC prod = new IT2CARAMBALAPISGC();
                        prod.addStudents();
                        
                        
                break;
                
                
            case 2: 
                config conf = new config();
                String test = "SELECT * FROM PRODUCT_DETAILS";
                String[] headers = {"ID", "NAME", "PRICE", "SOLD", "STOCK"};
                String[] Columns = {"ID", "NAME", "PRICE", "SOLD", "STOCK"};

                conf.viewRecords(test, headers, Columns);
            
                break;
                
            case 3:
                
                break;
                
            case 4:
                
                break;
                
            case 5:
                System.out.println("Program exiting. . .");
                System.exit(0);
                break;
            
        }
        
        System.out.println("Continue (yes|no)");
        another = in.next();
        
        } while(another.equals("yes"));
        System.out.println("Thank you for using");
    
    
}
}