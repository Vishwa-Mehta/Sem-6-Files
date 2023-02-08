package classPrograms;
import java.util.Scanner;

public class SumOfDigits {

	public static int sumOfDigits(int n) {
		if(n == 0) {
			return 0;
		}
		return sumOfDigits(n/10) + n % 10;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n:");
		n = sc.nextInt();
		System.out.println("Sum of the digits = " + sumOfDigits(n));
	}
}