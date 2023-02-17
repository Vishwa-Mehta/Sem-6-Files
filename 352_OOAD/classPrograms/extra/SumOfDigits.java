// program to split number into it's digits
import java.util.Scanner;
public class SumOfDigits {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int n = sc.nextInt();
		int num = n;
		int d = 0;
		int count = 0;
		while(n > 0) {
			n /= 10;
			count++;
		}
		int[] digits = new int[count];
		for(int i = 0; i < count; i++) {
			d = num % 10;
			digits[i] = d;
			num /= 10;
		}
		int sum = 0;
		for(int i = 0; i < count; i++) {
			sum += digits[i];
		}
		System.out.println("Sum of digits = " + sum);
	}
}
