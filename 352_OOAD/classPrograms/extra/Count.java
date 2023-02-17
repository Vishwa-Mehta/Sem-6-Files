// program to count letters, space, numbers and other characters
import java.util.Scanner;
public class Count {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int l = 0;
		int n = 0;
		int space = 0;
		int o = 0;
		for(int i = 0; i < input.length(); i++) {
			if(Character.isLetter(input.charAt(i))) {
				l++;
			}
			else if(Character.isDigit(input.charAt(i))) {
				n++;
			}
			else if(input.charAt(i) == ' ') {
				space++;
			}
			else {
				o++;
			}
		}
		System.out.println("The number of letters is " + l);
		System.out.println("The number of digits is " + n);
		System.out.println("The number of spaces is " + space);
		System.out.println("The number of other characters is " + o);
	}
}
