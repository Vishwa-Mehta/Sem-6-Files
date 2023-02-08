package classPrograms;

public class StaticMethod {
	int a;
	static int b;
	void printinfo() {
		System.out.print("a="+a); // error
		System.out.print("b="+b);
	}
//	public static void main(String args[]) {
////		printinfo(); // error
//	}
}
