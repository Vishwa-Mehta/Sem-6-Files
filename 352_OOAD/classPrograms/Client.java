class Client {
	public static void main(String arrgs[]) {
		// Irep i1 = new BusinessLayer();
		Irep i1 = new DataAccess();
		Irep i2 = new BusinessLayer(i1);
		i2.save();
		i1.save();
	}
}

interface Irep {
	void save();
}

class BusinessLayer implements Irep {
	Irep DAL;
	BusinessLayer(Irep i) {
		DAL = i;
	}
	public void save() {
		DAL.save();
	}
}

class DataAccess implements Irep {
	public void save() {
		System.out.println("Saved");
	}
}
