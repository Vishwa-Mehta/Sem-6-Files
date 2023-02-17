public class College {
	static String cname;
}

class Student {
	private String name;
	private int age;
	private String c_name;
	private int sem;
	private char sec;
	private int[] marks;
	private int total;
	
	public String getName() {
		return this.name;
	}
	public void setName(String n) {
		name = n;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int a) {
		age = a;
	}
	public String getCollege() {
		return this.c_name;
	}
	public void setCollege(College c) {
		c_name = c.cname;
	}
}
