import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name:");
		String name = input.nextLine();
		System.out.println("Enter the age:");
		int age = input.nextInt();
		Person o1 = new Person(name, age);
		System.out.println(o1);
	}
}

public class Person {
	private String name;
	private int age;
	Person(String name, int age) {

	}
}
