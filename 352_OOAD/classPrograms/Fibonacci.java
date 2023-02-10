// 
// Decompiled by Procyon v0.5.36
// 

// package classPrograms;

import java.util.Scanner;

public class Fibonacci
{
    public static void fibonacci(final int a, final int b, final int n) {
        if (a + b <= n) {
            System.out.println(a + b);
            fibonacci(b, a + b, n);
        }
        else {
            System.out.println();
        }
    }
    
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        final int n = sc.nextInt();
        System.out.println("The series is:");
        System.out.println(0);
        System.out.println(1);
        fibonacci(0, 1, n);
    }
}
