// 
// Decompiled by Procyon v0.5.36
// 

// package classPrograms;

import java.util.Scanner;

public class SumOfDigits
{
    public static int sumOfDigits(final int n) {
        if (n == 0) {
            return 0;
        }
        return sumOfDigits(n / 10) + n % 10;
    }
    
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        final int n = sc.nextInt();
        System.out.println("Sum of the digits = " + sumOfDigits(n));
    }
}
