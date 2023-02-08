package classPrograms;
import java.util.Scanner;

/* Write a Java program to create a class called "Employee" with fields for an 
 * employee's name, ID number, and salary. The class should have methods to get and set 
 * the values for each field, 
 * as well as a method to calculate the employee's raise by a specified percentage. 
 * The program should create three Employee objects and display their 
 * information before and after the raise. 
*/
public class Employee {
	private String name;
	private int id;
	private double salary;
	
	public Employee(String n, int i, double s) {
		name = n;
		id = i;
		salary = s;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int i) {
		id = i;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double s) {
		salary = s;
	}
	
	public void raise(double per) {
		salary += (salary * per);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
