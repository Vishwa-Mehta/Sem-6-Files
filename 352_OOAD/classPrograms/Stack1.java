import java.util.Stack;

public class Stack1 {
	public static void main(String args[]) {
		Stack<Integer> st = new Stack<>();
		boolean result = st.empty();
		System.out.println("stack empty?" + result);
		st.push(23);
		st.push(5);
		st.push(45);
		st.push(3);
		System.out.println("Elements:" + st);
		result = st.empty();
		System.out.println("stack empty?" + result);
	}
}
