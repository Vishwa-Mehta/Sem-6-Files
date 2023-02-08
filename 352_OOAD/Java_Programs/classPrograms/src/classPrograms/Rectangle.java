package classPrograms;
import java.util.Scanner;

/*
 * Write a java prog to create a class called rectangle with the fields for the length and the 
 * width. the class should have a constructor to init the length and the width, and a copy 
 * constructor the creates a new rect obj of an existing rect obj
 * the prog should create 2 rect objs, display their info and then use the copy constructor 
 * to create a 3rd rect obj as a copy of the 2nd obj. the prog should then display the info of 
 * all the 3 rect objs to demonstrate the use of copy constructor.
 * */
public class Rectangle {
	
	private int length;
	private int width;
	
	public Rectangle(int l, int w) {
		length = l;
		width = w;
	}
	
	public Rectangle(Rectangle r) {
		this.length = r.length;
		this.width = r.width;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length (int():");
		int l = sc.nextInt();
		int w = sc.nextInt();
		
		
		

	}

}
