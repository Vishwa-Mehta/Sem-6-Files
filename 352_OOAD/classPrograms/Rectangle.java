// 
// Decompiled by Procyon v0.5.36
// 

// package classPrograms;

import java.util.Scanner;

public class Rectangle
{
    private int length;
    private int width;
    
    public Rectangle(final int l, final int w) {
        this.length = l;
        this.width = w;
    }
    
    public Rectangle(final Rectangle r) {
        this.length = r.length;
        this.width = r.width;
    }
    
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length (int():");
        final int l = sc.nextInt();
        final int w = sc.nextInt();
    }
}
