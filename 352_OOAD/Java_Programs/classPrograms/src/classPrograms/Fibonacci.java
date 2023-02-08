package classPrograms;
import java.util.Scanner;
// don't access static variable from instance method 
public class Fibonacci {

	public static void fibonacci(int a, int b, int n) {
		if((a+b) <= n) {
//			System.out.println(a + "," + b + "," + (a+b));
			System.out.println(a+b);
			fibonacci(b, a+b, n);
		}
		else {
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n:");
		int n = sc.nextInt();
		System.out.println("The series is:");
		System.out.println(0);
		System.out.println(1);
		fibonacci(0, 1, n);
	}

}
