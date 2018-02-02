/*
 * Lab_01.java
 * Copyright (C) 2018 Jecsan Blanco <jblancolicano1@buffs.wtamu.edu>
 *
 * Distributed under terms of the MIT license.
 *
 *   @author Jecsan Blanco
 *   @version 1.0
 *   @since  02/01/2018
 *
 *   This program computes and displays  all numbers between 100 and 1 million which has the property that 
 *   the sum of each digit raised to the power of the number of digits in 
 *   the number is equal the number.
 */

import java.lang.Math;
public class Lab_01
{

    public static int  sumOfPowDigits(int[] digits){
        int sum = 0;
        for(int i : digits)
            sum += Math.pow(i,digits.length);
        return sum;

    }
    public static int[] getDigits(int n){
        int len = howManyDigits(n);
        int digits[] = new int[n];

        for(int p = 0; p < len; p++){
           digits[p] = ((int) (n / Math.pow(1,p)) % 10); 
        }
        return digits;
    }
    public static int howManyDigits(int n){
        return 1 + (int)Math.floor(Math.log10(n));
    }

    public static void main(String[] args){

        
        final int MIN = 100;
        final int MAX = 10000;

        for(int i = MIN; i <= MAX; i++){
            System.out.println(i);
         }
        
	}
}
