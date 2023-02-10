public class Prog1 {
	public static void main(String args[]) {
		System.out.println("b " + A.b);
		A o1= new A();
		o1.a= 5;
		A.b = 10;
		System.out.println("a " + o1.a + " b " + o1.b);
		o1.instanceMethod();
		o1.a = 5;
		System.out.println("a " + o1.a + " b " + o1.b);
		A.staticMethod();
		System.out.println("a " + o1.a + " b " + A.b);
		System.out.println("a " + o1.a + " b " + A.b);
	}
	static {
		System.out.println("Welcome to static where we can init all the static variables of the class");
		A.b = 11;
	}
}
class A {
	int a; // instance var
	static int b; //static variable or class variables
	void instanceMethod() {
		a = 15;
		b = 20;
	}
	static void staticMethod() {
		// a = 14; cannot be accessed 
		A o1 = new A();
		o1.a = 18;
		b = 25;
	}
}

/*
public class PrivateClass {
	private static class InnerClass {
		private int value;
		public InnerClass(int value) {
			this.value = value;
		}
		public static void main(String args[]) {
			InnerClass inner = new InnerClass(10);
			System.out.println("The value of the inner class is " + inner.value);
		}
	}
}
*/
