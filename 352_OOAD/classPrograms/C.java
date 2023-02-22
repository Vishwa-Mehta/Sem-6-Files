class A {
	public void display() {
		System.out.println("A");
	}
}
class B {
	public void display() {
		System.out.println("b");
	}
}
class C extends A {
	public static void main(String args[]) {
		C c = new C();
		c.display();
	}
}
