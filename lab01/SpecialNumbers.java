//SpecialNumbers.java
/******************************************************************************
* This class is a homework assignment 1;
* This program calculates the "narcissistic" numbers between a MIN and a MAX
* where the MIN >= 100 and the MAX <= 1,000,000. 
*
* <b>Note:</b><br>
* A narcissistic number is a number where the sum of each digit raised to the number
* of digits is equal to the number. For example  153 = 1^3+5^3+3^3 = 153;
*
* This is only for lab purposes and is ONLY guaranteed to work for the ranges given above.
* This lab is very inefficient as of 02,02,2018 and MAY get optimized later. 
*
* Copyright (C) 2018 Jecsan Blanco <jblancolicano1@buffs.wtamu.edu>
*   @author Jecsan Blanco
*   @version 1.0
*   @since  02/02/2018
*
******************************************************************************/

public class SpecialNumbers
{
    private final int  MIN,MAX;


    public void getSpecials(){
       /**
       * Prints out the "narcissistic" numbers between the given ranges.<br>
       * <b>Precondition:</b><br>
       *   Valid MIN and MAX are given.
       * <b>Postcondition:</b><br>
       * The narcissistic numbers a printed to the screen.
       **/
        int sum = 0;

        for(int i = MIN; i <= MAX; i++){
            sum = sumAndPower(getDigits(i),howManyDigits(i));
            // System.out.printf("Number: %d Sum: %d\n",i,sum);
            if(i == sum){
                System.out.printf("%,d\n",i);
            }
        }
        System.out.println();

    }
    
    private int sumAndPower(int[] digits,int power){
       /**
       *The digits in the provided array are raised to power and summed.
       **/
        int sum = 0;
        for(int  i : digits)
            sum += java.lang.Math.pow(i,power);
        // System.out.printf("Sum: %d\n",sum);
        return sum;

    }
    private  int[] getDigits(int n){
       /**
       *Returns an array of the digits in n.
       **/
        int len = howManyDigits(n);
        int[] digits = new int[len];

        int d = 1;
        for(int i = 1; i <= len; i++){
            digits[len - i] =( (n /(1*d)) % 10);
            d *= 10;
        }
        // System.out.printf("Digits [%d %d %d]\n",digits[0],digits[1],digits[2]);
        return digits;
    }
    private int howManyDigits(int n){
       /**
       * Returns the number of digits in n; 
       **/
        int howMany = 1 + (int)java.lang.Math.log10(n);
        // System.out.printf("Digits: %d",howMany);
        return howMany;

    }

    SpecialNumbers(int MIN, int MAX){
        this.MIN = MIN;
        this.MAX = MAX;
    } 
    public static void main(String[] args){
        SpecialNumbers numbers = new SpecialNumbers(100,1000000);
        numbers.getSpecials();
	}
}

