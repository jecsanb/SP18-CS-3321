/*
 * SpecialNumbers.java
 * Copyright (C) 2018 Jecsan Blanco <jblancolicano1@buffs.wtamu.edu>
 *
 * Distributed under terms of the MIT license.
 *
 *   @author Jecsan Blanco
 *   @version 1.0
 *   @since  02/02/2018
 */

public class SpecialNumbers
{
    private final int MIN, MAX;

    public void getSpecials(){
        int sum = 0;

        for(int i = MIN; i <= MAX; i++){
            sum = sumAndPower(getDigits(i),howManyDigits(i));
            // System.out.printf("Number: %d Sum: %d\n",i,sum);
            if(i == sum){
                System.out.printf("%d,",i);
            }
        }
        System.out.println();

    }
    
    public int sumAndPower(int[] digits,int power){
        int sum = 0;
        for(int  i : digits)
            sum += java.lang.Math.pow(i,power);
        // System.out.printf("Sum: %d\n",sum);
        return sum;

    }
    public int[] getDigits(int n){
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
    public int howManyDigits(int n){
        return 1 + (int)java.lang.Math.log10(n);
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
