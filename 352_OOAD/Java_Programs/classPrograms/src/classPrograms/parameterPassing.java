package classPrograms;

class test {
	int x;
	test(int i) {
		x = i;
	}
	test() {
		x = 0;
	}
}

public class parameterPassing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t = new test(5);
		System.out.println(t.x);
		change(t);
		System.out.println(t.x);
	}
	public static void change(test t) {
//		t = new test(); // creates new object and that value is assigned as 10 later 
//		so it doesn't reflect outside the method.
		t.x = 10; // pass by reference
	}

}
