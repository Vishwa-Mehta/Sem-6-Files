class Test {
	public static void main(String args[]) {
		HP h1 = new HP();
		h1.scan("sindhu");
		Canon c1 = new Canon();
		c1.print("sindhu");
	}	
}

interface IXerox {
	void print(String ocntent);
	void photocopy(String content);
	void printduplex(String content);
}

interface IScan {
	void scan(String content);
}

interface IFax {
	void fax(String content);
}

class HP implements IXerox, IScan, IFax {
	public void print(String content) {
		System.out.println("printing done");
	}
	public void scan(String content) {
		System.out.println("scanning done");
	}
	public void fax(String content) {
		System.out.println("fax done");
	}
	public void photocopy(String content) {
		System.out.println("photocopy done");
	}
	public void printduplex(String content) {
		System.out.println("printing duplex done");
	}
}

class Canon implements IXerox {
	public void print(String content) {
		System.out.println("printing done");
	}
	public void photocopy(String content) {
		System.out.println("photocopy done");
	}
	public void printduplex(String content) {
		System.out.println("printing duplex done");
	}
}
