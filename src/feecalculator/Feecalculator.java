/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feecalculator;

/**
 * Creating class name Feecaluclator
 * @author Ashwith Gundu
 */
public class Feecalculator {
    
    /**
     * Under Graduate Incidental Tuition Fee
     */
    public static final double UG_INCIDENTAL_FEE = 406.35;

    /**
     *Under Graduate Designated Fee
     */
    public static final double UG_DESIGNATED_FEE = 104.80;

    /**
     *Under Graduate Textbook Fee
     */
    public static final double UG_TEXTBOOK_FEE = 6;

    /**
     *Under Graduate Technology Fee
     */
    public static final double TECHNOLOGY_FEE = 20.70;

    /**
     * Computer Science Fee
     */
    public static final double CS_FEE = 38;

    /**
     * Graduate Incidental Fee
     */
    public static final double G_INCIDENTAL_FEE = 505.72;

    /**
     *Graduate Designated Fee
     */
    public static final double G_DESIGNATED_FEE = 115.55;

    /**
     *Graduate Textbook Fee
     */
    public static final double G_TEXTBOOK_FEE = 0;

    /**
     * SCHOLORSIP
     */
    public static final double SCHOLARSHIP=1000;
   
    /**
     * Insurance for 1ST and 4TH semester
     */
    public static final double INSURANCE_1_4 = 456.48;

    /**
     * Insurance for both 2nd and 3rd semester
     */
    public static final double INSURANCE_2_3 = 760.2;

    /**
     *  International fee
     */
    public static final double INTERNATIONAL_ALL = 75;

    /**
     *ORIENTATION fee
     */
    public static final double ORIENTATION_1= 75;
     
    private String  studentName;
    
    /**
     * Cunstructor with no-args
     */
    public Feecalculator(){
        
    }

    /**
     * Constructor with Student name as parameter
     * @param studentName
     */
    public Feecalculator(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Getting Student name
     * @return 
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * setting student name
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    /**
     *  /takes name as parameter 
     * @param name
     * @return name with .
     */
    public String getNameInitials(String name) {
          name=name.trim();
            String aa;
            aa=name.charAt(0)+".";           
                 
            for(int i=0;i<name.length();i++)
            {
                if(name.charAt(i)==' ')
                aa += (name.charAt(i+1)+".");
          
            }
         
        return aa.toUpperCase();
    }
    
    /**
     * 
     * @param req is required pre-requisites
     * @return caluclate pre req cost for one course
     */
    public double calcPrereqCost(int req)
  
      {    double d;
           d = req*3*(UG_INCIDENTAL_FEE+UG_DESIGNATED_FEE+UG_TEXTBOOK_FEE+TECHNOLOGY_FEE+CS_FEE);
           return d;
        } 
      
    /**
     * courses required for Ist sem
     * @param nn 
     * @return courses
     */
    public int findReqCoursesForSem1(int nn)
    {      int a = 0;
        if (nn==0)
        a= 3;
        else if (nn==1|nn==2)
            a= 2;
          
        return a;
      
        
                
    }

    /**
     * Cost caluclation
     * @return one course fee
     */
    public double calcReqCourseCostForOneCourse()
    {
       
        return (G_INCIDENTAL_FEE+G_DESIGNATED_FEE+TECHNOLOGY_FEE+CS_FEE)*3;
    }
   
    /**
     * Scholorship Caluclation
     * @param sem
     * @param pre
     * @param gpa
     * @return
     */
    public double calcScholarship(int sem, int pre, double gpa )
     {
         double sch = 0;
         if (sem==1)
         {
               
                sch = 1000;
         }
         
         
          else if(sem == 2||sem ==3) 
          { if(gpa>=3.3)
             
              sch =  3*3*0.50*G_INCIDENTAL_FEE;
               }
          
          else if(sem ==4)
          {
              if(gpa >= 3.3)
              {
                  if(pre==0)
                  {        
                     sch = 6*0.50*G_INCIDENTAL_FEE;
                  }
              else
                  {
               sch =  9*0.50*G_INCIDENTAL_FEE;
          }
              }
       
         
         
     }
         return sch;
         
     }
     
    /**
     *  total scholorship for all semester
     * @param sem
     * @param pre
     * @param gpa
     * @return total scholorship
     */
    public double calcTotalScholarship(int sem, int pre, double gpa)
     { 
         double totalValue = 0.00; 
            for(int i=1;i<=4;i++)
               {
                totalValue +=   calcScholarship(i,pre,gpa);
            }
            return totalValue;
         
       
     }
     
    /**
     *  Semester cost
     * @param sem
     * @param pre
     * @param gpa
     * @return semester cost
     */
    public double calcSemCost(int sem, int pre, double gpa )
            
    {
        double total=0.0;
        int z = 0;
      
            switch (sem) {
                case 1:
                   total = calcPrereqCost(pre) + (findReqCoursesForSem1(pre)*calcReqCourseCostForOneCourse())+
                    INSURANCE_1_4+INTERNATIONAL_ALL+ORIENTATION_1-calcScholarship(sem,pre,gpa);
                   
                    return total;
                case 2:
                    
                    total = calcReqCourseCostForOneCourse()*3+INSURANCE_2_3+INTERNATIONAL_ALL-calcScholarship(sem,pre,gpa);
                    
                    return total;
                    
                case 3:
                  
                  total = calcReqCourseCostForOneCourse()*3+INTERNATIONAL_ALL-calcScholarship(sem,pre,gpa);
                   return total;
                case 4:
                    if(pre == 0)
                    {
                          z = 2;
                          
                    }
                    else 
                            {
                                
                           z=3;
                            }
                    
              total = (z*calcReqCourseCostForOneCourse())+INTERNATIONAL_ALL+INSURANCE_1_4-calcScholarship(sem,pre,gpa);
                    break;
                
            }
        return total;
          
            }
        
    /**
     * total cost
     * @param sem
     * @param pre
     * @param gpa
     * @return
     */
    public double calcTotalCost(int sem, int pre, double gpa )
        {
            double totalValue = 0.00; 
            for(int i=1;i<=4;i++)
               {
                totalValue +=   calcSemCost(i,pre,gpa);
            }
            return totalValue;
        }
   
    /**
     *  conversion of Dollors to Rupees
     * @param total
     * @return dollors
     */
    public double exchUSDToINR(double total)
{
      double con = total * 64.55;
      return con;
}

    /**
     * Dollors to Pounds Conversion
     * @param total
     * @return pounds
     */
    public double exchUSDToEuro(double total)
{
      double co = total * 0.83;
      return co;
}

    @Override
    public String toString()
{
   return getNameInitials(getStudentName());
}
    
    /**
     * Prints the Reciept
     * @param sem
     * @param pre
     * @param gpa
     * @return receipt
     */
    public String printReceipt(int sem,int pre,double gpa)
        {

   return toString()+" on a whole the total scholarship till semester "+
           sem+"is: $ "+String.format("%.2f",calcTotalScholarship(sem,pre,gpa))+
           "\nTotal cost till semester "+sem+" is: $ "+String.format("%.2f",calcTotalCost(sem,pre,gpa));
                        
           
         }
    
  } 
