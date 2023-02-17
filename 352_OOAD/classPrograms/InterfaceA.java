/* Only public
 * No method definitions unless there's a default 
 * Only final
 * Cannot override
 * No constructor
 * Class can extend interfaces and multiple inheritance allowed
 */
public interface InterfaceA {
	// cannot be protected or private
	// no constructors
	int a = 10; // public static and final by default
	static void method() {
		System.out.println("Welcome");
	}
	default void method1() {
		// if class which implements does not override it
		// uses the default implementation
		System.out.println("Hi");
	}
	// cannot define a method without static or default keyword
}
