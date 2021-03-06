/*=========================
author: Jerome Gifford
file: Program10.java
Program: Program10
Class: CS116 t/th
Input: Tax brackets for 2009 and 2001, tax rates for 2001 and 2009, and an annual income with filing status
Process: use the filing status and annual income to find out what tax bracket and rate the user is income
then caculate the total amount in taxes they will pay for the year.
Output: Output the total amount of taxes payed for year for the user
This program is made as a sample and does not except user input. instead it will display all of the tax brackets for 
both 2001 and 2009 for a speific income (50,000 in this case).
============================*/
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author gpcorser
 */
public class program10{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //create Tax instatnce 
        Tax tx = new Tax();
        
		//load brackets for 2001 and 50,000 $
        System.out.println(2001);
        double income = 50000;
        double single = 0, marriedJ = 0, marriedS = 0, headOfHousehold = 0; 
        int[][] br = loadBrackets(2001);
        double[] rt = loadRates(2001);
        
        //print out brackets for each filing status
        System.out.println();
        System.out.println("Income  Single  MarriedJ    MarriedS    HOH");
        System.out.println("------  ------  --------    --------    ---");
        while(income <= 60000){
        tx = new Tax(Tax.SINGLE_FILER, br, rt, income);
        single = tx.getTax();
        tx = new Tax(Tax.MARRIED_JOINTLY, br, rt, income);
        marriedJ = tx.getTax();
        tx = new Tax(Tax.MARRIED_SEPARATELY, br, rt, income);
        marriedS = tx.getTax();
        tx = new Tax(Tax.HEAD_OF_HOUSEHOLD, br, rt, income);
        headOfHousehold = tx.getTax();
        
        System.out.println(income + " " + single + " "
                    + marriedJ + " " + marriedS + " " + headOfHousehold);
        income += 1000;
        }
        
		//repeat above steps for 2009
        System.out.println(2009);
        income = 50000;
        br = loadBrackets(2009);
        rt = loadRates(2009);
        
        
        System.out.println();
        System.out.println("Income  Single  MarriedJ    MarriedS    HOH");
        System.out.println("------  ------  --------    --------    ---");
        while(income <= 60000){
        tx = new Tax(Tax.SINGLE_FILER, br, rt, income);
        single = tx.getTax();
        tx = new Tax(Tax.MARRIED_JOINTLY, br, rt, income);
        marriedJ = tx.getTax();
        tx = new Tax(Tax.MARRIED_SEPARATELY, br, rt, income);
        marriedS = tx.getTax();
        tx = new Tax(Tax.HEAD_OF_HOUSEHOLD, br, rt, income);
        headOfHousehold = tx.getTax();
        
        System.out.println(income + " " + single + " "
                    + marriedJ + " " + marriedS + " " + headOfHousehold);
        income += 1000;
        
        }
    }

    public static int[][] loadBrackets(int year) throws FileNotFoundException{
     // load the brackets
        Scanner sc = new Scanner(new File(year + ".brackets"));
        int[][] br = new int[10][10];
        int i =0; int j = 0;
        while(sc.hasNextInt()){
            br[i][j] = sc.nextInt();
            if(j == 3){
                i++; j =0; 
            }
            else {
                j++;
            }
        
        }
        return br;
    }
    
    public static double[] loadRates(int year) throws FileNotFoundException{
          //load the rates
        Scanner sc = new Scanner(new File(year + ".rates"));
        double[] rates = new double[10];
        int i = 0;
        while(sc.hasNextDouble()){
            rates[i] = sc.nextDouble();
            i++;
        }
        return rates;
    }
    
} // end class: program10

class Tax {
    
    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;
    
    // filingStatus must be one of the constants above
    private int filingStatus;
    
    public static int [][] brackets = {
        {27050, 45200, 22600, 36250}, 
        {65550, 109250, 54625, 93650},
        {136750, 166500, 83250, 151650},
        {297350, 297350, 148675, 297350}, 
        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}
    };
    
    public static double [] rates = {0.15, 0.275, 0.305, 0.355, 0.391};
   
    private double taxableIncome;
    
    /**
     * @param status the filing status of the taxpayer
     */
    public void setFilingStatus (int status) {
        this.filingStatus = status;
    }
    
    /**
     * @param none
     */
    public int getFilingStatus () {
        return this.filingStatus;
    }
        
    /**
     * @param income the taxable income of the taxpayer
     */
    public void setTaxableIncome (double income) {
        this.taxableIncome = income;
    }
    
    /**
     * @param none
     */
    public double getTaxableIncome () {
        return this.taxableIncome;
    }
    
    Tax () {
        this.taxableIncome = 10000;
        this.filingStatus = Tax.SINGLE_FILER;
    }
    
    /**
     * @param fs the filing status of the taxpayer
     * @param br the 2d table of tax brackets
     * @param rt is the 1d array of tax rates
     * @param ti the taxable income of the taxpayer
     */
    Tax (int fs, int [][] br, double [] rt, double ti) {
        this.filingStatus = fs;
        this.brackets = br;
        this.rates = rt;
        this.taxableIncome = ti;
    }
    public static void loadBracketsAndRates(int year) throws FileNotFoundException{
        // load the brackets
        Scanner sc = new Scanner(new File(year + ".brackets"));
        brackets = new int[10][10];
        int i =0; int j = 0;
        while(sc.hasNextInt()){
            brackets[i][j] = sc.nextInt();
            if(j == 3){
                i++; j =0; 
            }
            else {
                j++;
            }
        
        }
        
        //load the rates
        sc = new Scanner(new File(year + ".rates"));
        rates = new double[10];
        i = 0;
        while(sc.hasNextDouble()){
            rates[i] = sc.nextDouble();
            i++;
        }
    }
    
    public double getTax(){
        double tax = 0;
        
        double rti = taxableIncome; //rti : remaining taxable income
        
        if (rti <= brackets[0][filingStatus]){
            tax = rti * rates[0];
        }
        else{
			//gets the tax with the max of each bracket up to remaining income
            tax = brackets[0][filingStatus] * rates[0];
            rti -= brackets[0][filingStatus];
            int br = 1; //index for brackets array
            while(rti > 0){
                if (rti > brackets[br][filingStatus] - brackets[br - 1][filingStatus]){
                    tax += rates[br] *  (brackets[br][filingStatus] - brackets[br - 1][filingStatus]);
                    rti -= brackets[br][filingStatus] - brackets[br - 1][filingStatus];
                }
                else{
                    tax += rti * rates[br];
                    rti = 0; //exit loop
                }
                br++;
            }
        }
        
        return tax;
    }
}
