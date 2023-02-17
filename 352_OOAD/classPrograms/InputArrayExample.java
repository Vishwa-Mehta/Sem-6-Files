import java.util.Scanner;

public class InputArrayExample {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("enter the no of elements:");
		int arr[] = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();	
			System.out.println(arr[i]);
		}
	}
}
