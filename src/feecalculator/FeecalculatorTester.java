package feecalculator;


import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashwith Gundu
 */
public class FeecalculatorTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        feecalculator.Feecalculator a = new feecalculator.Feecalculator();
   
         String q ;
       do{
           System.out.println("*******************************\n" +
                           "***Northwest Cost Calculator***\n" +
                            "*******************************");
        String b;
         int cff=0;
            double cgg = 0.00;
            int pp=0;
            
        Scanner name = new Scanner(System.in);
            int num = 0;
        do{
            if(num > 0)
                System.out.println("If no name is entered, user should be prompted to enter name again.");
            else
        System.out.print("Please enter the full name (Firstname Lastname): ");
        
        b = name.nextLine();
        num++;
        a.setStudentName(b);
        }while(b.isEmpty());
        num=0;
        do{
            if(num>0)  
                
                System.out.println("You have entered invalid number, please re-enter either 0 or 1 or 2:" );
                else
        System.out.print("Please enter the name of pre-requisites: ");
        Scanner pre = new Scanner(System.in);     
         pp = pre.nextInt();
         num++;
        }while(!(pp==0 || pp==1 || pp==2));
        
        num=0;
        do{
             
             if(num>0)
                 System.out.println("You have entered invalid number, please re-enter either 1 or 2 or 3 or 4: ");
             else
             {System.out.print("Please enter the number of semesters you want "
                + "to calculate the cumulative fee: ");
             }
         Scanner cf = new Scanner(System.in);     
        cff = cf.nextInt() ;
        num++;
             
         }while(!(cff==1||cff==2||cff==3||cff==4));
         
        num=0;
        do{
             if(num>0)
                 System.out.println("The GPA value should be between 0 and 4 , please Re-Enter");
               else 
             System.out.print("Enter the cumulative GPA: ");
         Scanner cg = new Scanner(System.in);     
        cgg = cg.nextDouble();
        num++;
        }while (!(cgg >=0 &&  cgg<=4) );
        
        System.out.println("****************************************");          
       System.out.println("* Hello, "+a.getNameInitials(b));
        System.out.println("*------------------------------------");
        System.out.println("* Your Account Summary");
        System.out.println("*------------------------------------");
        System.out.println("*");
        
        for(int i=1; i<=cff ;i++)
        {
        System.out.println("* Semester "+i+" fee is:    $ "+String.format("%4.2f",a.calcSemCost(i,pp,cgg) )+" *");
        }
        
        System.out.println("*----------------------------------  ");
        System.out.println("* Total cost:           $ "+String.format("%4.2f",a.calcTotalCost(cff,pp,cgg))+" *");
         System.out.println("*----------------------------------  ");
        System.out.println("*"); 
        System.out.println("* USD to INR: Rs. "+String.format("%4.2f",a.exchUSDToINR(a.calcTotalCost(cff,pp,cgg))));
        System.out.println("* USD to Euro: € "+String.format("%4.2f",a.exchUSDToEuro(a.calcTotalCost(cff,pp,cgg))));
        System.out.println("****************************************");
        System.out.println(a.printReceipt(cff,pp,cgg));
        System.out.println(" ");
        System.out.println("Do you want to calculate again?(Y/N): "+" ");
        
        Scanner o = new Scanner(System.in);
        q = o.nextLine();
        name.close();
      
       }while(q.equals("y")||q.equals("Y"));
       
       System.out.println("Thank You! All the best.");
    }
  }

        

  
    
