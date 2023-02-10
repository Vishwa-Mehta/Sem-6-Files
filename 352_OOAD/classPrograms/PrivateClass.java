public class PrivateClass {
		public static void main(String args[]) {
		    InnerClass inner = new InnerClass(10);
		    System.out.println("The value of the inner class is " + inner.value);
		}
		private static class InnerClass {
			private int value;
			public InnerClass(int value) {
		    this.value = value;
		}
	}
}
