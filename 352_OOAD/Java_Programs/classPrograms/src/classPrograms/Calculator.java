package classPrograms;

//	write a java program to create a class "calculator" with overloaded methods 
//	for addition, subtraction, multiplication and division of 2 numbers. 
//	Program should allow user to enter 2 numbers and select an operation to perform
//	Result should be displayed to the user.

import java.util.Scanner;

public class Calculator {
	
	static int add(int x, int y) {
		return x+y;
	}
	static double mul(double x, double y) {
		return x*y;
	}
	static int mul(int x, int y) {
		return x*y;
	}
	static double div(double x, double y) {
		if(y != 0) {
			return x/y;
		}
		else {
			System.out.println("Division error, second number cannot be 0!!! :/");
			return 0.0;
		}
	}
	static int sub(int x, int y) {
		return x-y;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. int add");
		System.out.println("2. int sub");
		System.out.println("3. int mul");
		System.out.println("4. double mul");
		System.out.println("5. double div");
		System.out.println("Enter choice:");
		int option = sc.nextInt();
		System.out.println("Enter the numbers:");
		int a;
		int b;
		switch(option) {
		case 1:
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a + "+" + b + "=" + add(a,b));
			
		case 2:
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a + "-" + b + "=" + sub(a,b));
		
		case 3:
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a + "*" + b + "=" + mul(a,b));
		
		case 4:
			double e = sc.nextDouble();
			double f = sc.nextDouble();
			System.out.println(e + "*" + f + "=" + mul(e,f));
			
		case 5:
			
		}
		
	}
}
